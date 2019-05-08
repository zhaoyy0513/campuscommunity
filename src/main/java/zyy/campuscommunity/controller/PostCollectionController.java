package zyy.campuscommunity.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.PostCollection;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostCollectionService;
import zyy.campuscommunity.service.UserService;

@Controller
@RequestMapping(value = "/postCollection")
public class PostCollectionController {
    @Autowired
    PostCollectionService postCollectionService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/addCollect/{postId}")
    @ResponseBody
    /**
     * @Description: 添加收藏
     * @Param: [postId, userId]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/8 17:09
     */
    public String addCollectionById(@PathVariable("postId") int postId, int userId) {
        User user = userService.getUserById(userId); //获取要操作的用户
        int postCollectionNum = user.getPostCollectionNum();//获取帖子关注数
        if (postCollectionNum == 0) {
            //如果收藏数为0，则直接添加收藏，并修改用户的收藏数
            String postsId = String.valueOf(postId) + ';';
            PostCollection postCollection = new PostCollection(userId, postsId);
            int result = postCollectionService.insertPostCollection(postCollection); //添加一条新数据
            if (result >= 0) {
                //如果添加收藏成功
                user.setPostCollectionNum(1);
                int updateU = userService.updateUser(user);  //更新用户的收藏数
                if (updateU < 0) {
                    return JSONArray.toJSONString("error");
                }
            } else {
                return JSONArray.toJSONString("error");
            } //result>=0
        } else {
            //如果收藏数不为0
            PostCollection postCollection = postCollectionService.getPostCollectionByUid(userId);//获取该用户的收藏
            String postCollectStr = postCollection.getPostId(); //获取该用户收藏的帖子字符串
            postCollectStr += String.valueOf(postId) + ';'; //将新加的添加进去
            postCollection.setPostId(postCollectStr);  //修改为新的字符串数据
            int result = postCollectionService.updataPostCollection(postCollection);//更新收藏
            if (result >= 0) {
                //如果修改成功
                user.setPostCollectionNum(postCollectionNum + 1);
                int updateU = userService.updateUser(user);  //更新用户的收藏数
                if (updateU < 0) {
                    return JSONArray.toJSONString("error");
                }
            }else{
                return JSONArray.toJSONString("error");
            } //result
        }
        return JSONArray.toJSONString("success");
    }
    //明天继续写取消收藏的逻辑！加油！

}