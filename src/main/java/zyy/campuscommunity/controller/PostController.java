package zyy.campuscommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import zyy.campuscommunity.entity.*;
import zyy.campuscommunity.service.PostCollectionService;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.ReplyService;
import zyy.campuscommunity.service.TabService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    TabService tabService;
    @Autowired
    ReplyService replyService;
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
    public String getPostsByTabId(@PathVariable Integer id, HttpServletRequest request) throws ParseException {
        List<Post> posts = postService.getPostByTabId(id);
        Iterator<Post> iterator = posts.iterator();
        Date date = new Date();
        //设置回复时间差值(当前时间减去帖子最后一次回复时间的差值)
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (iterator.hasNext()){
            Post post = iterator.next();
            String now = df .format(date);
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
        request.getSession().setAttribute("backPreUrl",backPreUrl);
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
        User user = (User)request.getSession().getAttribute("user");
        if(user.getPostCollectionNum()==0){
            request.getSession().setAttribute("status", "uncollected");
        }else{
            PostCollection postCollection = postCollectionService.getPostCollectionByUid(user.getId());//获取该用户对应的收藏表
            String postCollectStr = postCollection.getPostId();//从收藏表中获取收藏字符串
            int index = postCollectStr.indexOf(String.valueOf(postId));
            if(index >= 0){
                //如果关注了，那么就设置状态为已经收藏
                request.getSession().setAttribute("status", "collected");
            }else{
                request.getSession().setAttribute("status", "uncollected");
            }
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
        String file_path = "D:/workplace/java_eclipse/campuscommunity/src/main/resources/static/upload";
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
    public Map releasePost(Post post) {
        Date date = new Date();
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        post.setPostTime(format);  //设置发布时间
        post.setPostReplyCount(0); //设置回复数
        post.setPostClickCount(0);  //设置点击数
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
        System.out.println(post.toString());
        int result = postService.insert(post);
        if (result > 0) {
            map.put("msg", "发布成功");
        } else {
            map.put("msg", "发布失败");
        }
        return map;
    }

}
