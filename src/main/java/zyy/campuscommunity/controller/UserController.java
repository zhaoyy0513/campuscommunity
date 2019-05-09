package zyy.campuscommunity.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.Focus;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Tab;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.FocusService;
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
    @Autowired
    FocusService focusService;

    @Resource(name = "redisTemplate")
    RedisTemplate<String, List> listRedisTemplate;

    //跳转到登录界面·
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    //跳转到注册界面
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "user/register";
    }

    //跳转到主页
    @RequestMapping("/toIndex")
    public String toIndex(HttpServletRequest request) {
        List<Post> list = postService.getPostByParentId(1);
        request.getSession().setAttribute("posts", list);
        return "index";
    }

    //用户注册
    @RequestMapping("/register")
    public void userRegister() {
        //记得默认设置好未读信息个数0，关注0，帖子收藏0等
    }

    //用户登录
    @RequestMapping(value = "/login")
    public String userLogin(HttpServletRequest request) throws ParseException {
        //先将一级标题所有的标签获取到
        List<Tab> tabList = (List<Tab>) listRedisTemplate.opsForList().rightPop("tabList");
        if (null == tabList) {
            //如果Redis没有找到这个对应的tabList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            tabList = tabService.getTabsByParentId(0);
            listRedisTemplate.opsForList().rightPush("tabList", tabList);
            System.out.println("从数据库查询得到tabList");
        } else {
            System.out.println("从Redis查询得到tabList");
        }
        System.out.println(tabList.toString());
        //将数据库查询到的一级标签添加到tabList中,并渲染到首页
        request.getSession().setAttribute("tabList", tabList);
        //获取一级标签'学霸'所有的帖子，并放到首页进行渲染,学霸的id是1
        List<Post> list = postService.getPostByParentId(1);
        Iterator<Post> iterator = list.iterator();
        //设置回复时间差值(当前时间减去帖子最后一次回复时间的差值)
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (iterator.hasNext()) {
            Post post = iterator.next();
            String now = df.format(date);
            //计算回复的时间差
            Date d1 = df.parse(now);
            Date d2 = df.parse(post.getPostLastReplyTime());
            if (d2 != null) {
                long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
                long days = diff / (1000 * 60 * 60 * 24);
                long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
                long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
                long seconds = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / 1000;
                if (((int) days) < 1) {
                    if (((int) hours) < 1) {
                        if (minutes < 1) {
                            if (((int) seconds) <= 60) {
                                post.setPostLastReplyTimeSimple("" + seconds + "秒之前");
                            }
                        } else {
                            post.setPostLastReplyTimeSimple("" + minutes + "分钟之前");
                        }
                    } else {
                        post.setPostLastReplyTimeSimple("" + hours + "小时" + minutes + "分钟之前"); //设置最后回复时间
                    }
                } else {
                    post.setPostLastReplyTimeSimple("" + days + "天" + hours + "小时" + minutes + "分钟之前"); //设置最后回复时
                }
            }
            postService.updatePost(post);  //更新帖子
        }
        request.getSession().setAttribute("posts", list);
        //获得一级标题中'学霸'对应的二级标题，用于默认被选中
        List<Tab> xuebaList = (List<Tab>) listRedisTemplate.opsForList().rightPop("tabsByParentIdList");
        if (null == xuebaList) {
            //如果Redis没有找到这个对应的xuebaList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            xuebaList = tabService.getTabsByParentId(1);
            listRedisTemplate.opsForList().rightPush("tabsByParentIdList", xuebaList);
            System.out.println("从数据库查询得到tabsByParentIdList");
        } else {
            System.out.println("从Redis查询得到tabsByParentIdList");
        }
        Collections.sort(xuebaList, new Comparator<Tab>() {
            public int compare(Tab o1, Tab o2) {
                return o1.getTabName().length() - o2.getTabName().length();
            }
        });
        //将数据库查询到的学霸对应的二级标签添加到xuebaList中,并渲染到首页
        request.getSession().setAttribute("xuebaList", xuebaList);
        //获取登录页面传来的用户名
        String name = request.getParameter("userName");
        //获取传来的密码
        String password = request.getParameter("userPwd");
        List<User> user_list = userService.getUserByName(name);
        User user = user_list.get(0);
        if (password.equals(user.getUserPwd())) {
            request.getSession().setAttribute("user", user);
            return "index";
        } else {
            User user1 = new User();
            user1.setUserName("游客");
            request.getSession().setAttribute("user", user1);
            return "index";
        }
    }

    //用户退出
    @RequestMapping(value = "/logout")
    public String user_LogOut(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "redirect:../";
    }

    //游客登录

    /**
     * @Description: 登录页的游客登录按钮调转进来的逻辑操作
     * @Param: [request]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/4/8 9:47
     */
    @RequestMapping(value = "tourist")
    public String tourist_login(HttpServletRequest request) {
        //先将一级标题所有的标签获取到
        List<Tab> tabList = (List<Tab>) listRedisTemplate.opsForList().rightPop("tabList");
        if (null == tabList) {
            //如果Redis没有找到这个对应的tabList这个键名，则从数据库查找，并将其放入Redis中，以便下次使用
            tabList = tabService.getTabsByParentId(0);
            listRedisTemplate.opsForList().rightPush("tabList", tabList);
            System.out.println("从数据库查询得到tabList");
        } else {
            System.out.println("从Redis查询得到tabList");
        }
        System.out.println(tabList.toString());
        //将数据库查询到的一级标签添加到tabList中,并渲染到首页
        request.getSession().setAttribute("tabList", tabList);
        //获取一级标签'学霸'所有的帖子，并放到首页进行渲染,学霸的id是1
        List<Post> list = postService.getPostByParentId(1);
        request.setAttribute("posts", list);
        //获得一级标题中'学霸'对应的二级标题，用于默认被选中
        List<Tab> xuebaList = tabService.getTabsByParentId(1);
        Collections.sort(xuebaList, new Comparator<Tab>() {
            public int compare(Tab o1, Tab o2) {
                //将tab名按长度进行排序
                return o1.getTabName().length() - o2.getTabName().length();
            }
        });
        //将数据库查询到的学霸对应的二级标签添加到xuebaList中,并渲染到首页
        request.getSession().setAttribute("xuebaList", xuebaList);
        User user1 = new User();
        user1.setUserName("游客");
        request.getSession().setAttribute("user", user1);
        return "index";
    }

    /**
     * @Description: 游客进入页面之后，点击登录后出现的弹出层操作逻辑
     * @Param: []
     * @return: java.util.Map<java.lang.String               ,               java.lang.Object>
     * @Author: zhaoyy
     * @Date: 2019/4/8 13:41
     */
    @RequestMapping(value = "/tourist_login")
    @ResponseBody
    public Map<String, Object> tourist_login(HttpServletRequest request, String userName, String userPwd) {
        System.out.println("跳转成功");
        Map<String, Object> map = new HashMap<>();
        List list = userService.getUserByName(userName);
        if (list.size() == 0) {
            map.put("msg", "未找到该用户");
        } else {
            User user = (User) list.get(0);
            if (userPwd.equals(user.getUserPwd())) {
                request.getSession().setAttribute("user", user);
                map.put("username", userName);
                map.put("msg", "验证通过");
            } else {
                map.put("msg", "密码错误");
            }
        }

        return map;
    }

    @RequestMapping("/getFocus/{user_id}")
    public String getFocus(@PathVariable("user_id") int user_id, HttpServletRequest request) {
        request.getSession().setAttribute("user", request.getSession().getAttribute("user"));
        String focusUserIdByUid = focusService.getFocusUserIdByUid(user_id);
        System.out.println("所有关注的用户id字符串:" + focusUserIdByUid);
        String[] arr = focusUserIdByUid.split(";");
        List<Post> posts = new ArrayList<>();
        //arr.for可以快速书写增强型for循环
        for (String str : arr) {
            //将切割出来的用户id进行转换，用于查找
            List<Post> post = postService.getPostByUid(Integer.valueOf(str));
            try {
                posts.addAll(post); //列表拼接 因为每次循环一次都是很多小的post
            } catch (Exception e) {
                break; //如果出现空指针异常，跳出当前，执行下个查询即可
            }
        }
        request.getSession().setAttribute("Posts", posts);
        request.getSession().setAttribute("postCount", posts.size());
        for (int i = 0; i < posts.size(); i++) {
            System.out.println(posts.get(i).toString());
        }
        return "post/focusPosts";
    }

    /**
     * @Description:用户点击完相应帖子的用户头像或者名字后跳转的controller
     * @Param: [userId, request]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/4/24 16:23
     */
    @RequestMapping("/userInfo/{uid}")
    public String UserInfo(@PathVariable("uid") int userId, HttpServletRequest request) {
        System.out.println("要跳转的用户id" + userId);
        User user = userService.getUserById(userId);
        request.getSession().setAttribute("focus", user);
        List<Post> posts = postService.getPostByUid(userId);
        request.getSession().setAttribute("Posts", posts);
        request.getSession().setAttribute("postCount", posts.size());
        User currentUser = (User) request.getSession().getAttribute("user");//获取当前登录的对象
        int currentId = currentUser.getId();
        System.out.println("当前登录用户id" + currentId);
        if (currentId == userId) {
            //如果进来的是用户自己，则设置状态为userSelf
            request.getSession().setAttribute("status", "userSelf");//用来前台校验改变button的值
        } else {

            if (currentUser.getFocusNumber() == 0) {
                //判断如果当前登录的用户如果关注数为0，则直接设置为未关注
                request.getSession().setAttribute("status", "unFocused");
            } else {
                String focusedId = focusService.getFocusUserIdByUid(currentUser.getId());//获取当前用户所有关注的人的id
                int i = focusedId.indexOf(String.valueOf(userId));//如果是关注的人
                if (i >= 0) {
                    request.getSession().setAttribute("status", "focused");//用来前台校验改变button的值
                } else {
                    //并不是自己关注的人
                    request.getSession().setAttribute("status", "unFocused");
                }
            }
        }

        return "user/otherInfo";
    }

    /**
     * @Description: 添加关注
     * @Param: [userId, focusId]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/4/25 10:05
     */
    @RequestMapping(value = "/addFocus")
    @ResponseBody
    public String addFocus(int userId, int focusId, HttpServletRequest request) {
        User currentUser = userService.getUserById(userId);
        if (currentUser.getFocusNumber() == 0) { //如果没有Focus，则创建
            Focus focus = new Focus();
            focus.setUserId(userId); //设置focus
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(focusId) + ";");
            String resultStr = sb.toString();
            focus.setFocusedId(resultStr);
            //下面操作用户的关注数量
            currentUser.setFocusNumber(1);
            //重新设置用户信息
            int userResult = userService.updateUser(currentUser);
            request.getSession().setAttribute("user", currentUser);
            int focusResult = focusService.addFocus(focus);
            //更新
            System.out.println("操作完成后focused:" + focus.getFocusedId());
            if (userResult < 0 || focusResult < 0) {
                //有一个失败则操作失败
                return JSONArray.toJSONString("error");
            } else {
                return JSONArray.toJSONString("correct");
            }
        } else {//如果有focus
            Focus focused = focusService.getFocusByUid(userId);  //首先获取当前用户所对应的的Focus实体
            System.out.println("操作完成前focused:" + focused.getFocusedId());
            String focusedId = focused.getFocusedId(); //获取Focus实体中对应的关注用户的id字符串
            StringBuffer sb = new StringBuffer(focusedId);
            sb.append(String.valueOf(focusId) + ";");
            String resultStr = sb.toString();
            focused.setFocusedId(resultStr);
            //下面操作用户的关注数量
            currentUser.setFocusNumber(currentUser.getFocusNumber() + 1);
            int userResult = userService.updateUser(currentUser);
            //重新设置用户信息
            request.getSession().setAttribute("user", currentUser);
            int focusResult = focusService.updateFocus(focused);
            //更新
            System.out.println("操作完成后focused:" + focused.getFocusedId());
            if (userResult < 0 || focusResult < 0) {
                //有一个失败则操作失败
                return JSONArray.toJSONString("error");
            } else {
                return JSONArray.toJSONString("correct");
            }
        }
    } //

    /**
     * @Description: 用来取消特别关注的controller
     * @Param: [] 第一个参数是当前用户的id,第二个参数是被关注那个用户的id
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/4/24 16:25
     */
    @RequestMapping(value = "/cancelFocus")
    @ResponseBody
    public String cancelFocus(int userId, int focusId, HttpServletRequest request) {
        Focus focused = focusService.getFocusByUid(userId);  //首先获取当前用户所对应的的Focus实体
        System.out.println("操作完成前focused:" + focused.getFocusedId());
        String focusedId = focused.getFocusedId(); //获取Focus实体中对应的关注用户的id字符串
        int index = focusedId.indexOf(String.valueOf(focusId));
        if (index >= 0) {
            StringBuilder sb = new StringBuilder(focusedId);
            //单线程StringBuilder更快
            //数据格式是1;2;3;这种
            sb.deleteCharAt(index);  //删除一个之后索引原来的位置上就变成一个;
            sb.deleteCharAt(index);  //然后继续删除该位置上的;就成了最后新的字符串
            String resultStr = sb.toString();
            focused.setFocusedId(resultStr);
            //下面操作用户的关注数量
            User currentUser = userService.getUserById(userId);
            currentUser.setFocusNumber(currentUser.getFocusNumber() - 1);
            //重新设置用户信息

            if (currentUser.getFocusNumber() == 0) {
                //如果得到关注数为0，直接删除focus数据库对应的一整行数据
                int deleteResult = focusService.deleteFocusByUid(userId);
                if (deleteResult < 0) {
                    //如果删除失败
                    return JSONArray.toJSONString("error");
                } else {
                    //更新
                    int userResult = userService.updateUser(currentUser);
                    if(userResult < 0){
                        return JSONArray.toJSONString("error");
                    }else{
                        request.getSession().setAttribute("user", currentUser);
                        return JSONArray.toJSONString("correct");
                    }

                }
            } else {
                //如果关注数不是0,则更新对应的行数据
                int focusResult = focusService.updateFocus(focused);
                System.out.println("操作完成后focused:" + focused.getFocusedId());
                if (focusResult < 0) {
                    //有一个失败则操作失败
                    return JSONArray.toJSONString("error");
                }else{
                    //更新
                    int userResult = userService.updateUser(currentUser);
                    if(userResult >= 0){
                        request.getSession().setAttribute("user", currentUser);
                        return JSONArray.toJSONString("correct");
                    }else{
                        return JSONArray.toJSONString("error");
                    }
                }
            }
        }else{
            //未找到关注的id
            return JSONArray.toJSONString("error");
        }
    }
}
