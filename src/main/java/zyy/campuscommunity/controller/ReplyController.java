package zyy.campuscommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Reply;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.ReplyService;
import zyy.campuscommunity.service.UnreadService;
import zyy.campuscommunity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @RequestMapping("/addReply/{postId}")
    public synchronized String addReply(@PathVariable Integer postId, Reply reply, HttpServletRequest request) throws ParseException {
        String infoToStr = request.getParameter("infoTo");
        if (!"".equals(infoToStr)) {//如果sendToId不为空
            String replyContent = reply.getReplyContent();
            int pos = replyContent.indexOf(" ");
            String subReplyStr = replyContent.substring(pos); //将第一空格后的内容拼出来
            String resultReply = subReplyStr.trim(); //去掉用户可能产生的 前后空格
            //想去两个关键ID
            int userId = Integer.valueOf(infoToStr); //转成id类型，对应数据库实体的类型
            User user = (User)request.getSession().getAttribute("user"); //获取当前登录的用户
            int infocomeId = Integer.valueOf(user.getId()); //获取用户id
            System.out.println("infoToStr:"+userId);
            System.out.println("sendFrom:"+infocomeId);
            //下面进行添加未读信息的逻辑操作
            //创建的实体参数分别为，接受消息的用户，消息，发送消息的用户
            Unread unread = new Unread(userId,resultReply,infocomeId);
            int result = unreadService.insertUnread(unread);
            if(result>=0){
                User msgRecUser = userService.getUserById(userId);
                msgRecUser.setUnreadMessage(msgRecUser.getUnreadMessage()+1);
                userService.updateUser(msgRecUser);
            }else{
                return "../Error";
            }
        }
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String replyTime = sdf.format(date);
            reply.setReplyTime(replyTime); //设置回复时间
            Post post = postService.getPostById(postId); //得到要回复的帖子
            int count = post.getPostReplyCount();  //获取原本帖子的回复总数
            reply.setReplyFloor(count + 1); //在帖子的回复总数上加1就是自己所在的楼层
            //这里可能有高并发的嫌疑
            post.setPostReplyCount(count + 1);
            //获取回复的用户名，可以用来做最后显示回复者是谁
            String replyUserName = reply.getReplyUserName();
            post.setPostLastReply(replyUserName);  //设置最后回复者
            post.setPostLastReplyTime(replyTime);  //设置最后回复时间
            postService.updatePost(post);  //更新帖子
            try {
                replyService.insertReply(reply);
            } catch (Exception e) {
                System.out.println(e.getCause().getMessage());
            }
            return "redirect:/post/postDetail/" + postId;

    }
}