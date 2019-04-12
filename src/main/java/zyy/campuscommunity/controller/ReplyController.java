package zyy.campuscommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Reply;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.ReplyService;

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
    ReplyService replyService;
    @Autowired
    PostService postService;

    @RequestMapping("/addReply/{postId}")
    public synchronized String addReply(@PathVariable Integer postId, Reply reply, HttpServletRequest request) throws ParseException {
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
        String replyUserName = request.getParameter("replyUserName");
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