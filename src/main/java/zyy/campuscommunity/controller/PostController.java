package zyy.campuscommunity.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import zyy.campuscommunity.entity.*;
import zyy.campuscommunity.service.*;
import zyy.campuscommunity.util.AuthService;
import zyy.campuscommunity.util.HttpUtil;
import zyy.campuscommunity.util.SpamBean;
import zyy.campuscommunity.util.disObeyMap;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/post")
@CrossOrigin()
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    TabService tabService;
    @Autowired
    ReplyService replyService;
    @Autowired
    UnreadService unreadService;
    @Autowired
    PostCollectionService postCollectionService;

    /**
     * @Description: 通过tabId获取所有的帖子
     * @Param: [id, request]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/4/1 17:42
     */
    @RequestMapping(value = "/tabId/{id}")
    public String getPostsByTabId(@PathVariable Integer id, HttpServletRequest request) {
        List<Post> posts = postService.getPostByTabId(id);
        Iterator<Post> iterator = posts.iterator();
        Date date = new Date();
        //设置回复时间差值(当前时间减去帖子最后一次回复时间的差值)
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (iterator.hasNext()) {
            Post post = iterator.next();
            String now = df.format(date);
            //计算回复的时间差
            Date d1 = null;
            try {
                d1 = df.parse(now);
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

            } catch (ParseException e) {
                Tab tab = tabService.getTabById(id);
                //设置二级类型名描述(二级标题描述)
                String tabDescribe = tab.getTabDescribe();
                request.getSession().setAttribute("tabDescribe", tabDescribe);
                //设置帖子二级类型名
                String tabName = tab.getTabName();
                request.getSession().setAttribute("tabName", tabName);
                //设置前台页面全部主题点击事件-回到这个标签的首页目录
                //String backPreUrl = request.getHeader("Referer");  //获取的是String类型 http://localhost:8081/user/userLogin
                //String backPreUrl = request.getRequestURI();  //获取的是String类型 /post/tabId/10
                String backPreUrl = request.getRequestURL().toString();//获取的是stringBuffer类型 http://localhost:8081/post/tabId/10
                System.out.println(backPreUrl);
                request.getSession().setAttribute("backPreUrl", backPreUrl);
                if (posts.size() > 0) { //如果有帖子
                    request.getSession().setAttribute("Posts", posts);
                    //获取主题posts的长度，既为主题总数
                    request.getSession().setAttribute("tabPostNum", posts.size());
                } else {
                    request.getSession().setAttribute("Posts", posts);
                    request.getSession().setAttribute("tabPostNum", 0);
                }
                return "post/tabAllPost";
            }
        }
        Tab tab = tabService.getTabById(id);
        //设置二级类型名描述(二级标题描述)
        String tabDescribe = tab.getTabDescribe();
        request.getSession().setAttribute("tabDescribe", tabDescribe);
        //设置帖子二级类型名
        String tabName = tab.getTabName();
        request.getSession().setAttribute("tabName", tabName);
        //设置前台页面全部主题点击事件-回到这个标签的首页目录
        //String backPreUrl = request.getHeader("Referer");  //获取的是String类型 http://localhost:8081/user/userLogin
        //String backPreUrl = request.getRequestURI();  //获取的是String类型 /post/tabId/10
        String backPreUrl = request.getRequestURL().toString();//获取的是stringBuffer类型 http://localhost:8081/post/tabId/10
        System.out.println(backPreUrl);
        request.getSession().setAttribute("backPreUrl", backPreUrl);
        if (posts.size() > 0) { //如果有帖子
            request.getSession().setAttribute("Posts", posts);
            //获取主题posts的长度，既为主题总数
            request.getSession().setAttribute("tabPostNum", posts.size());
        } else {
            request.getSession().setAttribute("Posts", posts);
            request.getSession().setAttribute("tabPostNum", 0);
        }
        return "post/tabAllPost";
    }


    @RequestMapping(value = "/postDetail/{postId}")
    public ModelAndView postDetail(@PathVariable Integer postId, HttpServletRequest request) throws ParseException {
        ModelAndView model = new ModelAndView();
        Post post = postService.getPostById(postId);
        //每点击进来一次之后，将点击次数进行提取并+1然后保存至数据库
        int count = post.getPostClickCount() + 1;
        post.setPostClickCount(count);
        postService.updatePost(post);
        List<Reply> replies = replyService.getRepliesByPostId(postId);
        Iterator<Reply> iterator = replies.iterator();
        //设置回复时间差值(当前时间减去帖子最后一次回复时间的差值)
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (iterator.hasNext()) {
            Reply reply = iterator.next();
            String now = df.format(date);
            //计算回复的时间差
            Date d1 = df.parse(now);
            Date d2 = df.parse(reply.getReplyTime());
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
                                reply.setReplyTimeSimple("" + seconds + "秒之前");
                            }
                        } else {
                            reply.setReplyTimeSimple("" + minutes + "分钟之前");
                        }
                    } else {
                        reply.setReplyTimeSimple("" + hours + "小时" + minutes + "分钟之前"); //设置最后回复时间
                    }
                } else {
                    reply.setReplyTimeSimple("" + days + "天" + hours + "小时" + minutes + "分钟之前"); //设置最后回复时
                }
            }
            replyService.updateReply(reply);
        }
        //查看帖子是否是收藏过的，用来设置属性
        User user = (User) request.getSession().getAttribute("user");
        if (user.getId() != 0) {
            //0代表游客,这里意思是如果不是游客
            if (user.getPostCollectionNum() == 0) {
                request.getSession().setAttribute("status", "uncollected");
            } else {
                PostCollection postCollection = postCollectionService.getPostCollectionByUid(user.getId());//获取该用户对应的收藏表
                String postCollectStr = postCollection.getPostId();//从收藏表中获取收藏字符串
                int index = postCollectStr.indexOf(String.valueOf(postId));
                if (index >= 0) {
                    //如果关注了，那么就设置状态为已经收藏
                    request.getSession().setAttribute("status", "collected");
                } else {
                    request.getSession().setAttribute("status", "uncollected");
                }
            }
        } else {
            //如果是游客设置一个未收藏
            request.getSession().setAttribute("status", "uncollected");
        }
        model.addObject("post", post);
        model.addObject("replies", replies);
        model.setViewName("post/postDetail");
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadPic")
    public Map<String, Object> uploadPic(HttpServletRequest httpServletRequest, MultipartFile myfile) throws IOException {
        //原始名称
        String oldFileName = myfile.getOriginalFilename(); //获取上传文件的原名
//        //如果上传目录为/static/images/upload/，则可以如下获取：
//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        if(!path.exists()) path = new File("");
//        System.out.println("path:"+path.getAbsolutePath());
//        File upload = new File(path.getAbsolutePath(),"static/upload/");
//        if(!upload.exists()) upload.mkdirs();
//        //存储图片的物理路径(target/classess路径)
//        //在开发测试模式时，得到的地址为：{项目跟目录}/target/static/upload/
//        //在打包成war正式发布时，得到的地址为：{发布war包目录}/static/upload/
//         String file_path = upload.getAbsolutePath();
        String file_path = "E:/workplace/java_spboot/campuscommunity/src/main/resources/static/upload";
        System.out.println("file_path:" + file_path);
        //上传图片
        if (myfile != null && oldFileName != null && oldFileName.length() > 0) {
            //新的图片名称
            String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
            //新图片
            File newFile = new File(file_path + "/" + newFileName);
            System.out.println("newFile:" + newFile);
            //将内存中的数据写入磁盘
            myfile.transferTo(newFile);
            //将新图片名称返回到前端
            Map<String, Object> map = new HashMap<>();
            map.put("success", "成功啦");
            map.put("iurl", newFileName);
            return map;
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "图片不合法");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/releasePost")
    public Map releasePost(Post post) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>(); //这个map是用来返回状态信息的
        //首先进行帖子内容过滤
        String content = post.getPostContent();
        Map <String,Object> checkMap= checkPostContent(content);  //调用下面封装好的方法
        int spam = (int)checkMap.get("spam");
        StringBuilder sb = new StringBuilder("发布失败,帖子包含[");
        if(spam!=0){ //是否违禁标识(0表示非违禁，1表示违禁，2表示建议人工复审
           String numStr = String.valueOf(checkMap.get("disObeyType"));
            String[] numArr = numStr.split(";");
            for (String s : numArr) {
                String msg = disObeyMap.getTypeByDisObeyNum(Integer.valueOf(s));
                sb.append(msg+" ");
            }
            map.put("msg",sb.toString()+"]内容");
            return map;
        }
        //帖子过滤结束
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        post.setPostTime(format);  //设置发布时间
        post.setPostReplyCount(0); //设置回复数
        post.setPostClickCount(0);  //设置点击数
        post.setPostLastReply(""); //设置最后回复者
        post.setPostLastReplyTime(""); //设置回复时间
        post.setPostLastReplyTimeSimple("");  //设置回复时间-简写
        try {
            //进行异常拦截，有可能会发生空指针异常
            int parentId = tabService.getTabParentIdByTabId(post.getPostTabId());
            post.setTabParentid(parentId);  //设置帖子标签的父标签ID
        } catch (Exception e) {
            //输出错误信息
            System.out.println(e.getCause().getMessage());
            map.put("msg", "发布失败");
            return map;
        }
        int result = postService.insert(post);
        if (result > 0) {
            map.put("msg", "发布成功");

        } else {
            map.put("msg", "发布失败");
        }
        return map;
    }

    public static Map<String,Object> checkPostContent(String content) throws UnsupportedEncodingException {
        String SPAM_URL = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam";
        SpamBean spamBean;
        String access_token = AuthService.getAuth();
        content = "content=" + content;
        Map<String,Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        try {
            String result = HttpUtil.post(SPAM_URL, access_token, content);
            System.out.println(result.toString());
            spamBean = JSON.parseObject(result, SpamBean.class);
            int spam = spamBean.getResult().getSpam();
            System.out.println("是否违禁标识(0表示非违禁，1表示违禁，2表示建议人工复审):"+spam);
            if(spam==0){
                map.put("spam",0);
                return map;
            }
            if(spam==1){
                System.out.println("内容违禁");
                List rejectList = spamBean.getResult().getReject();
                for (Object o : rejectList) {
                    SpamBean.Reject reject = JSON.parseObject(String.valueOf(o), SpamBean.Reject.class);
                    sb = sb.append(String.valueOf(reject.getLabel())+";");
                }
                map.put("spam",1);
                map.put("disObeyType",sb.toString());  //违禁类型
                return map;
            }
            if(spam==2){
                System.out.println("建议人工复审");
                List reviewList = spamBean.getResult().getReview();
                for (Object o : reviewList) {
                    SpamBean.Reject advise = JSON.parseObject(String.valueOf(o), SpamBean.Reject.class);
                    sb = sb.append(String.valueOf(advise.getLabel())+";");
                }
                map.put("spam",2);
                map.put("disObeyType",sb.toString());  //违禁类型
                return map;
            }
        } catch (Exception e) {
            System.out.println("check"+e.getCause().getMessage());
            e.printStackTrace();
        }
        return map;
    }





    /*
     * 功能描述: <br>
     * 〈根据帖子的索引Id，删除相应的帖子,以及和其有关的逻辑操作〉
     * @Param: [Pid, request]
     * @Return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/16  9:14
     */
    @RequestMapping(value = "/deletePost/{Pid}")
    @ResponseBody
    public String deletePostByPid(@PathVariable("Pid") int Pid) {
        System.out.println("进入成功");
        //删除帖子
        int result = postService.deletePostById(Pid);
        //将于此帖子有关的内容都删掉
        //删除回复
        int deleteR = replyService.deleteReplyByPid(Pid);
        if (deleteR < 0) {
            System.out.println("deletePost里未能成功删除相应的回复");
        }
        //删除收藏,已经在postConllection(getCollectionsByUid)这个方法里设置好了
        //删除未读信息
        int deleteUn = unreadService.deleteUnreadByPid(Pid);
        if (deleteUn < 0) {
            System.out.println("deletePost里未能成功删除相应的未读信息");
        }
        if (result < 0 || deleteR < 0 || deleteUn < 0) {
            return JSONObject.toJSONString("error");
        }
        return JSONObject.toJSONString("success");
    }


    //根据索引Id获取指定帖子 ,root后台用
    @RequestMapping(value = "/getPostByIdRoot/{pid}")
    @ResponseBody
    public Post getPostByIdRoot(@PathVariable("pid") int Pid) {
        Post post = null;
        try {
            post = postService.getPostById(Pid);
            return post;
        } catch (Exception e) {
            System.out.println("getPostByIdRoot" + e.getCause().getMessage());
            return post;
        }
    }

    //root后台管理分页
    @RequestMapping(value = "/getPostsByPage")
    @ResponseBody
    public BaseResult getPostsByPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "7") Integer rows) {
        PageHelper.startPage(page, rows);
        List<Post> list = postService.getAllPost();
        PageInfo<Post> info = new PageInfo<>(list);
        BaseResult baseResult = new BaseResult();
        baseResult.setTotal(info.getTotal());
        baseResult.setData(info.getList());
        return baseResult;
    }

    //root后台管理模糊查询帖子
    @RequestMapping(value = "/getPostsByLike/{likeStr}")
    @ResponseBody
    public List<Post> getPostByLike(@PathVariable("likeStr")String likeStr){
        List<Post> posts = new ArrayList<>();
        try{
            posts = postService.getPostByLike(likeStr);
          return posts;
        }catch (Exception e){
            return posts;
        }
    }

    //root后台管理漏斗图数据来源
    @RequestMapping(value = "/getPostTypeDistribute")
    @ResponseBody
    public ChartsResult getPostTypeDistribute(){
        List<Post> allPost = postService.getAllPost();
        Map<String,Integer> map = new HashMap<>();
        for (Post post : allPost) {
            String tabName = post.getPostTabName();
            if(map.containsKey(tabName)){
                map.put(tabName,map.get(tabName)+1);
            }else{
                map.put(tabName,1);
            }
        }
        List<ChartData> chartList = new ArrayList<>();
        for(Map.Entry<String ,Integer> entry:map.entrySet()){
            String name = entry.getKey();
            Integer value = entry.getValue();  //获取相应的键名
            float result = (float)value/allPost.size();
            float num=(float)(Math.round(result*1000))/10;
            chartList.add(new ChartData(num,name));
        }
        String keys = map.keySet().toString(); //获取所有键名
        String values = map.values().toString(); //获取所有键值
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ChartsResult cResult = new ChartsResult();
        keys = keys.substring(1,keys.length()-1);
        String[] strArr = keys.split(",");
        cResult.setListData(chartList); //设置前台用的数据
        cResult.setKeys(strArr);  //前台要用的真正的值
        cResult.setValues(values);
        cResult.setCurrentTime(sdf.format(date));
        return cResult;
    }

    //itemStyle: this.createRandomItemStyle()
    //root后台管理词云图数据来源
    @RequestMapping(value = "/getPostCloud")
    @ResponseBody
    public ChartsResult getPostCloudDistribute(){
        List<Post> allPost = postService.getAllPost();
        Map<String,Integer> map = new HashMap<>();
        for (Post post : allPost) {
            String tabName = post.getPostTitle();
            if(map.containsKey(tabName)){
                map.put(tabName,map.get(tabName)+1);
            }else{
                map.put(tabName,1);
            }
        }
        List<ChartData> chartList = new ArrayList<>();
        for(Map.Entry<String ,Integer> entry:map.entrySet()){
            String name = entry.getKey();
            Integer value = entry.getValue();  //获取相应的键名
            chartList.add(new ChartData(value,name));
        }
        String keys = map.keySet().toString(); //获取所有键名
        String values = map.values().toString(); //获取所有键值
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ChartsResult cResult = new ChartsResult();
        keys = keys.substring(1,keys.length()-1);
        String[] strArr = keys.split(",");
        cResult.setListData(chartList); //设置前台用的数据
        cResult.setKeys(strArr);  //前台要用的真正的值
        cResult.setValues(values);
        cResult.setCurrentTime(sdf.format(date));
        return cResult;
    }

}
