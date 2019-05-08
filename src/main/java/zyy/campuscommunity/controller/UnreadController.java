package zyy.campuscommunity.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.ReplyService;
import zyy.campuscommunity.service.UnreadService;
import zyy.campuscommunity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/unread")
public class UnreadController {
    @Autowired
    private UnreadService unreadService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    
    /** 
    * @Description: 根据用户索引id查询用户所有的未读信息
    * @Param: [] 
    * @return: java.util.List<zyy.campuscommunity.entity.Unread> 
    * @Author: zhaoyy
    * @Date: 2019/5/6 9:17
    */
    @RequestMapping(value = "/unreadsByUid/{uid}")
    public String getUnreadsByUid(@PathVariable("uid") int uid, HttpServletRequest request){
        System.out.println("进入成功");
        List<Unread> unreads = unreadService.getUnreadsByUid(uid);
        request.getSession().setAttribute("unreads",unreads);
        request.getSession().setAttribute("unreadCount",unreads.size());
        return "post/unread";
    }

    /** 
    * @Description: 根据id删除对应未读信息和回复列表里的回复
    * @Param: [id] 
    * @return: java.lang.String 
    * @Author: zhaoyy
    * @Date: 2019/5/7 16:33
    */ 
    @RequestMapping(value = "/delete/{unreadId}")
    @ResponseBody
    public String deleteUnReadById(@PathVariable("unreadId") int id,int postId,HttpServletRequest request){
        User currentUser = (User) request.getSession().getAttribute("user");
        currentUser.setUnreadMessage(currentUser.getUnreadMessage()-1);
        int updateU = userService.updateUser(currentUser);  //更新用户未读信息数
        if(updateU<0){
            return JSONArray.toJSONString("error");
        }
        String postIddd = request.getParameter("postId");
        System.out.println("postIddd:"+Integer.parseInt(postIddd));
        Post post = postService.getPostById(postId);
        System.out.println(post.toString());

        Unread unread = unreadService.getUnreadById(id); //获取未读的信息
        int replyId = unread.getReplyId();  //获取索引Id
        System.out.println("要删除回复的索引id是:"+replyId);
        int deleteR =  replyService.deleteReplyById(replyId); //通过索引id删除帖子
        if(deleteR<0){
            return JSONArray.toJSONString("error");
        }

        System.out.println("要删除未读信息的索引id是:"+id);
        int deleteU = unreadService.deleteUnreadById(id);
        if(deleteU<0){
            return JSONArray.toJSONString("error");
        }

        return JSONArray.toJSONString("success");
    }
    
}