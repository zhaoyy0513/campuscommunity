package zyy.campuscommunity.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.TabService;
import zyy.campuscommunity.service.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {	
	@Autowired
	UserService userService;
	@Autowired
	TabService tabService;
	@Autowired
    PostService postService;
    @Resource(name="redisTemplate")
    RedisTemplate<String,List> listRedisTemplate;

	//跳转到登录界面·
	@RequestMapping(value = "/toLogin")
    public String toLogin(){
	    return "login";
    }

	//跳转到注册界面
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "userPage/register";
	}

	//跳转到主页
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest request) {
        List<Post> list = (List<Post>)listRedisTemplate.opsForList().rightPop("indexList");
        if (null==list) {
            //如果Redis没有找到这个对应的list这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            list = postService.getPostByParentId(1);
            listRedisTemplate.opsForList().rightPush("indexList",list);
            System.out.println("从数据库查询得到indexList");
        } else {
            System.out.println("从Redis查询得到indexList");
        }
        System.out.println(list.toString());
        request.setAttribute("posts",list);
		return "index";
	}

	//用户注册
	@RequestMapping("/register")
	public void userRegister() {
	}

	//用户登录
	@RequestMapping(value="/login")
	public String userLogin(HttpServletRequest request) throws ParseException {
		//先将一级标题所有的标签获取到
        List<Tab> tabList = (List<Tab>)listRedisTemplate.opsForList().rightPop("tabList");
        if (null==tabList) {
            //如果Redis没有找到这个对应的tabList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            tabList = tabService.getTabsByParentId(0);
            listRedisTemplate.opsForList().rightPush("tabList",tabList);
            System.out.println("从数据库查询得到tabList");
        } else {
            System.out.println("从Redis查询得到tabList");
        }
        System.out.println(tabList.toString());
        //将数据库查询到的一级标签添加到tabList中,并渲染到首页
        request.getSession().setAttribute("tabList",tabList);
        //获取一级标签'学霸'所有的帖子，并放到首页进行渲染,学霸的id是1
        List<Post> list = (List<Post>)listRedisTemplate.opsForList().rightPop("postByParentIdList");
        if (null==list) {
            //如果Redis没有找到这个对应的list这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            list = postService.getPostByParentId(1);
            listRedisTemplate.opsForList().rightPush("postByParentIdList",list);
            System.out.println("从数据库查询得到postByParentIdList");
        } else {
            System.out.println("从Redis查询得到postByParentIdList");
        }
        System.out.println(list.toString());
        Iterator<Post> iterator = list.iterator();
        //设置回复时间差值(当前时间减去帖子最后一次回复时间的差值)
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (iterator.hasNext()){
            Post post = iterator.next();
            String now = df.format(date);
            //计算回复的时间差
            Date d1 = df.parse(now);
            Date d2 = df.parse(post.getPostLastReplyTime());
            if(d2!=null){
                long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
                long days = diff / (1000 * 60 * 60 * 24);
                long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
                long seconds = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000*60))/1000;
                if(((int)days)<1){
                    if(((int)hours)<1){
                        if(minutes<1){
                            if(((int)seconds)<=60){
                                post.setPostLastReplyTimeSimple(""+seconds+"秒之前");
                            }
                        }else{
                                post.setPostLastReplyTimeSimple(""+minutes+"分钟之前");
                        }
                    }else{
                        post.setPostLastReplyTimeSimple(""+hours+"小时"+minutes+"分钟之前"); //设置最后回复时间
                    }
                }
                else{
                    post.setPostLastReplyTimeSimple(""+days+"天"+hours+"小时"+minutes+"分钟之前"); //设置最后回复时
                }
            }
            postService.updatePost(post);  //更新帖子
        }
        request.setAttribute("posts",list);
        //获得一级标题中'学霸'对应的二级标题，用于默认被选中
        List<Tab> xuebaList = (List<Tab>)listRedisTemplate.opsForList().rightPop("tabsByParentIdList");
        if (null==xuebaList) {
            //如果Redis没有找到这个对应的xuebaList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            xuebaList = tabService.getTabsByParentId(1);
            listRedisTemplate.opsForList().rightPush("tabsByParentIdList",xuebaList);
            System.out.println("从数据库查询得到tabsByParentIdList");
        } else {
            System.out.println("从Redis查询得到tabsByParentIdList");
        }
        System.out.println(xuebaList.toString());
		Collections.sort(xuebaList, new Comparator<Tab>() {
			public int compare(Tab o1, Tab o2) {
				return o1.getTabName().length()-o2.getTabName().length();
			}
		});
        //将数据库查询到的学霸对应的二级标签添加到xuebaList中,并渲染到首页
        request.getSession().setAttribute("xuebaList",xuebaList);
		//获取登录页面传来的用户名
		String name = request.getParameter("userName");
		//获取传来的密码
		String password = request.getParameter("userPwd");
		List<User> user_list = userService.getUserByName(name);
		User user = user_list.get(0);
		if(password.equals(user.getUserPwd())) {
			request.getSession().setAttribute("user",user);
			return "index";
		}else{
			User user1 = new User();
			user1.setUserName("游客");
            request.getSession().setAttribute("user",user1);
            return "index";
		}
	}

	//用户退出
    @RequestMapping(value = "/logout")
	public String user_LogOut(HttpServletRequest request){
		request.getSession().setAttribute("user",null);
		return "redirect:../";
	}

	//游客登录
    /**
    * @Description:  登录页的游客登录按钮调转进来的逻辑操作
    * @Param: [request]
    * @return: java.lang.String
    * @Author: zhaoyy
    * @Date: 2019/4/8 9:47
    */
    @RequestMapping(value="tourist")
	public String tourist_login(HttpServletRequest request){
        //先将一级标题所有的标签获取到
        List<Tab> tabList = (List<Tab>)listRedisTemplate.opsForList().rightPop("tabList");
        if (null==tabList) {
            //如果Redis没有找到这个对应的tabList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            tabList = tabService.getTabsByParentId(0);
            listRedisTemplate.opsForList().rightPush("tabList",tabList);
            System.out.println("从数据库查询得到tabList");
        } else {
            System.out.println("从Redis查询得到tabList");
        }
        System.out.println(tabList.toString());
        //将数据库查询到的一级标签添加到tabList中,并渲染到首页
        request.getSession().setAttribute("tabList",tabList);
        //获取一级标签'学霸'所有的帖子，并放到首页进行渲染,学霸的id是1
        List<Post> list = (List<Post>)listRedisTemplate.opsForList().rightPop("postByParentIdList");
        if (null==list) {
            //如果Redis没有找到这个对应的list这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            list = postService.getPostByParentId(1);
            listRedisTemplate.opsForList().rightPush("postByParentIdList",list);
            System.out.println("从数据库查询得到postByParentIdList");
        } else {
            System.out.println("从Redis查询得到postByParentIdList");
        }
        System.out.println(list.toString());
        request.setAttribute("posts",list);
        //获得一级标题中'学霸'对应的二级标题，用于默认被选中
        List<Tab> xuebaList = tabService.getTabsByParentId(1);
        Collections.sort(xuebaList, new Comparator<Tab>() {
            public int compare(Tab o1, Tab o2) {
                //将tab名按长度进行排序
                return o1.getTabName().length()-o2.getTabName().length();
            }
        });
        //将数据库查询到的学霸对应的二级标签添加到xuebaList中,并渲染到首页
        request.getSession().setAttribute("xuebaList",xuebaList);
            User user1 = new User();
            user1.setUserName("游客");
            request.getSession().setAttribute("user",user1);
            return "index";
    	}

    	/** 
    	* @Description: 游客进入页面之后，点击登录后出现的弹出层操作逻辑
    	* @Param: [] 
    	* @return: java.util.Map<java.lang.String,java.lang.Object> 
    	* @Author: zhaoyy
    	* @Date: 2019/4/8 13:41
    	*/ 
    	@RequestMapping(value = "/tourist_login")
        @ResponseBody
    	public Map<String,Object> tourist_login(HttpServletRequest request,String userName,String userPwd){
            System.out.println("跳转成功");
            Map<String,Object> map = new HashMap<>();
    	    List list= userService.getUserByName(userName);
    	    if(list.size()==0){
    	        map.put("msg","未找到该用户");
            }else{
                User user = (User)list.get(0);
                if(userPwd.equals(user.getUserPwd())){
                    request.getSession().setAttribute("user",user);
                    map.put("username",userName);
                    map.put("msg","验证通过");
                }else{
                    map.put("msg","密码错误");
                }
            }

            return map;
        }

}
