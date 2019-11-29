package zyy.campuscommunity.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Reply;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.ReplyService;
import zyy.campuscommunity.service.UnreadService;
import zyy.campuscommunity.service.UserService;
import zyy.campuscommunity.util.disObeyMap;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 控制回复的controller
 * @Param:
 * @return:
 * @Author: zhaoyy
 * @Date: 2019/4/2 15:16
 */
@RequestMapping("/reply")
@Controller
public class ReplyController {
    @Autowired
    UserService userService;
    @Autowired
    ReplyService replyService;
    @Autowired
    PostService postService;
    @Autowired
    UnreadService unreadService;

    @RequestMapping("/replyValidate")
    @ResponseBody
    public Map<String, Object> replyValidate( Reply reply) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>(); //这个map是用来返回状态信息的
        String replyContent = reply.getReplyContent();
        Map <String,Object> checkMap= PostController.checkPostContent(replyContent);  //调用下面封装好的方法
        int spam = (int)checkMap.get("spam");
        StringBuilder sb = new StringBuilder("发布失败,回复包含[");
        if(spam!=0){ //是否违禁标识(0表示非违禁，1表示违禁，2表示建议人工复审
            String numStr = String.valueOf(checkMap.get("disObeyType"));
            String[] numArr = numStr.split(";");
            for (String s : numArr) {
                String msg = disObeyMap.getTypeByDisObeyNum(Integer.valueOf(s));
                sb.append(msg+" ");
            }
            map.put("msg",sb.toString()+"]信息");
            return map;
        }
        map.put("msg","success");
        return map;
    }

    /**
     * @Description: 帖子回复，这里并不是@用户的操作
     * @Param: [postId, reply, request]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/5 16:54
     */
    @RequestMapping("/addReply/{postId}")
    public String addReply(@PathVariable Integer postId, Reply reply, HttpServletRequest request) throws ParseException {
        User currentUser = (User) request.getSession().getAttribute("user");//获取当前登录的用户
        int currentUserId = currentUser.getId(); //登录用户的索引Id
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String replyTime = sdf.format(date);
        String replyContent = reply.getReplyContent();
        replyContent = replyContent.trim(); //取消调用回复时带的空格
        reply.setReplyContent(replyContent);
        reply.setReplyTime(replyTime); //设置回复时间
        Post post = postService.getPostById(postId); //得到要回复的帖子
        if (post.getPostUserId() != currentUserId) {
            //如果当前回复者同时不是帖子的发布者，则进行下列的操作
            int lastReplyId = replyService.getLastReplyId(); //获取最后一个回复贴的id
            //添加未读信息，既当别人回复此帖子的时候，给帖子发布者添加未读
            //参数分别是，帖子发布者索引Id，回复内容，回复者id,帖子id，回复的帖子id
            Unread unread = new Unread(post.getPostUserId(), replyContent, currentUserId,currentUser.getUserName(), replyTime,postId,post.getPostTitle(),lastReplyId+1);
            int result = unreadService.insertUnread(unread);
            if (result >= 0) {
                //如果添加未读信息成功，则将对应的用户表中的未读信息数+1;
                User msgRecUser = userService.getUserById(post.getPostUserId());
                msgRecUser.setUnreadMessage(msgRecUser.getUnreadMessage() + 1);
                userService.updateUser(msgRecUser);
            }
        }
        int floor = postService.getLastPostNum();  //获取原本帖子的回复总数
        reply.setReplyFloor(floor + 1); //在帖子的回复总数上加1就是自己所在的楼层
        //这里可能有高并发的嫌疑
        post.setPostReplyCount(post.getPostReplyCount() + 1);
        //获取回复的用户名，可以用来做最后显示回复者是谁
        String replyUserName = reply.getReplyUserName();
        post.setPostLastReply(replyUserName);  //设置最后回复者
        post.setPostLastReplyTime(replyTime);  //设置最后回复时间
        //设置发布时间和当前时间的简化时间(多少天多少小时这种);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
        try {
            replyService.insertReply(reply);
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
        return "redirect:/post/postDetail/" + postId;
    }


    /**
     * @Description: 这里的回复是用来回复@某个用户的操作
     * @Param: [postId, reply, request]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/5 16:54
     */
    @RequestMapping("/replyUser/{postId}")
    public  String replyUser(@PathVariable Integer postId, Reply reply, HttpServletRequest request) throws ParseException {
        String infoToStr = request.getParameter("infoTo");
        //这一块逻辑是处理@用户之后进行回复的逻辑
        String replyContent = reply.getReplyContent();
        String originReplyContent = "@"+reply.getReplyUserName()+replyContent; //用来发给帖子的发布者
        int pos = replyContent.indexOf(" ");
        String subReplyStr = replyContent.substring(pos); //将第一个空格后的内容拼出来
        String resultReply = subReplyStr.trim(); //去掉用户可能产生的 前后空格
        //想去两个关键ID
        int infoTouserId = Integer.valueOf(infoToStr); //转成id类型，对应数据库实体的类型
        User user = (User) request.getSession().getAttribute("user"); //获取当前登录的用户
        Post post = postService.getPostById(postId); //得到要回复的帖子
        int postUserId = post.getPostUserId(); //获取帖子的发布者Id
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String replyTime = sdf.format(date);
        int infocomeId = user.getId(); //获取发送者id
        //System.out.println("infoToStr:" + userId);
       // System.out.println("sendFrom:" + infocomeId);
        //下面进行添加未读信息的逻辑操作
        //创建的实体参数分别为，接受消息的用户，消息，发送消息的用户,发送信息的用户名，帖子标题,回复的帖子id
        int lastReplyId = replyService.getLastReplyId(); //获取最后一个回复贴的索引id
        //unread构造方法最后一个参数replyId用来进行帖子的删除
        Unread unread = new Unread(infoTouserId, resultReply, infocomeId, user.getUserName(),replyTime,postId,post.getPostTitle(),lastReplyId+1);
        //给帖子的发布者也添加一个未读信息
        Unread unread1 = new Unread(postUserId, originReplyContent, infocomeId, user.getUserName(),replyTime,postId,post.getPostTitle(),lastReplyId+1);
        int result = unreadService.insertUnread(unread);
        int resul1 = unreadService.insertUnread(unread1);
        if (result >= 0&&resul1>=0) {
            //如果添加未读信息成功，则将对应的用户表中的未读信息数+1;
            if (infocomeId != infoTouserId) {
                //如果是自己回复自己，则不添加用户未读信息
                User msgRecUser = userService.getUserById(infoTouserId);
                msgRecUser.setUnreadMessage(msgRecUser.getUnreadMessage() + 1);
                userService.updateUser(msgRecUser);
            }
        } else {
            return "../Error";
        }
        int floor = postService.getLastPostNum();  //获取帖子的回复总数,获取最大楼层数(其实就是最大的id数)
        reply.setReplyContent(replyContent.trim()); //设置回复内容，这里进行去空格处理
        reply.setReplyTime(replyTime); //设置回复时间
        reply.setReplyFloor(floor + 1); //在帖子的回复总数上加1就是自己所在的楼层
        //这里可能有高并发的嫌疑
        post.setPostReplyCount(post.getPostReplyCount() + 1);
        //获取回复的用户名，可以用来做最后显示回复者是谁
        String replyUserName = reply.getReplyUserName();
        post.setPostLastReply(replyUserName);  //设置最后回复者
        post.setPostLastReplyTime(replyTime);  //设置最后回复时间
        //设置发布时间和当前时间的简化时间(多少天多少小时这种);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
        try {
            replyService.insertReply(reply);
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
        return "redirect:/post/postDetail/" + postId;
    }

    @RequestMapping(value = "/deleteReply")
    @ResponseBody
    public String deleteReplyByRid(int Rid,int Pid){
        //首先先把回复删除掉
        int result = replyService.deleteReplyById(Rid);
        //然后更新帖子的回复数
        Post post = postService.getPostById(Pid);
        post.setPostReplyCount(post.getPostReplyCount()-1); //更新回复数
        int updateP = postService.updatePost(post); //更新帖子的回复
        if(result<0){
            System.out.println("删除回复失败");
            return JSONObject.toJSONString("error");
        }
        if(updateP<0){
            System.out.println("更新帖子回复数失败");
            return JSONObject.toJSONString("error");
        }
        return JSONObject.toJSONString("success");
    }

}