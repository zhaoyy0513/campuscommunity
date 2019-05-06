package zyy.campuscommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.service.UnreadService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/unread")
public class UnreadController {
    @Autowired
    private UnreadService unreadService;
    
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
    
}