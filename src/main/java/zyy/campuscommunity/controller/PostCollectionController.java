package zyy.campuscommunity.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.PostCollection;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.PostCollectionService;
import zyy.campuscommunity.service.PostService;
import zyy.campuscommunity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/postCollection")
public class PostCollectionController {
    @Autowired
    PostCollectionService postCollectionService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @RequestMapping(value = "/addCollect/{postId}")
    @ResponseBody
    /**
     * @Description: 根据用户索引id和帖子索引id添加收藏
     * @Param: [postId, userId]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/8 17:09
     */
    public String addCollectionById(@PathVariable("postId") int postId, int userId, HttpServletRequest request) {
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
                if (updateU >= 0) {
                    request.getSession().setAttribute("user", user);
                } else {
                    return JSONObject.toJSONString("error");
                }
            } else {
                return JSONObject.toJSONString("error");
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
                    return JSONObject.toJSONString("error");
                } else {
                    request.getSession().setAttribute("user", user);
                }
            } else {
                return JSONObject.toJSONString("error");
            } //result
        }
        return JSONObject.toJSONString("success");
    }

    @RequestMapping(value = "/cancelCollect/{postId}")
    @ResponseBody
    /**
     * @Description: 根据用户索引id和帖子索引id取消收藏
     * @Param: [postId, userId]
     * @return: java.lang.String
     * @Author: zhaoyy
     * @Date: 2019/5/9 9:13
     */
    public String cancelCollectionById(@PathVariable("postId") int postId, int userId, HttpServletRequest request) {
        PostCollection postCollection = postCollectionService.getPostCollectionByUid(userId);//根据用户id获取该用户的收藏表
        String postIdStr = postCollection.getPostId(); //获取该用户的收藏拼接字符串格式为(3;4;5)
        StringBuilder sb = new StringBuilder(postIdStr);
        //单线程StringBuilder更快
        int index = postIdStr.indexOf(String.valueOf(postId));
        if (index >= 0) {
            //如果存在该postId
            sb.deleteCharAt(index); //第一次删除数字
            sb.deleteCharAt(index); //第二次删除;因为上面删除数字之后;代替了数字的位置
            postCollection.setPostId(sb.toString());
            User user = userService.getUserById(userId);
            int count = user.getPostCollectionNum() - 1; //收藏数-1
            user.setPostCollectionNum(count); //设置用户的收藏数
            if (user.getPostCollectionNum() == 0) {
                //如果收藏数等于0则直接删除该用户对应的收藏表
                int resultD = postCollectionService.deletePostCollection(userId);
                if (resultD < 0) {
                    //如果删除失败
                    return JSONObject.toJSONString("error");
                } else {
                    int updateU = userService.updateUser(user); //更新用户信息
                    if (updateU < 0) {
                        //如果更新用户失败
                        return JSONObject.toJSONString("error");
                    } else {
                        request.getSession().setAttribute("user", user);
                        return JSONObject.toJSONString("success");

                    }
                }
            } else {
                int updateP = postCollectionService.updataPostCollection(postCollection); //更新收藏表
                if (updateP < 0) {
                    //更新帖子失败
                    return JSONObject.toJSONString("error");
                } else {
                    int updateU = userService.updateUser(user); //更新用户信息
                    if (updateU >= 0) {
                        request.getSession().setAttribute("user", user);
                        return JSONObject.toJSONString("success");
                    } else {
                        return JSONObject.toJSONString("error");
                    }
                }
            }
        } else {
            //未找到该帖子Id
            return JSONObject.toJSONString("error");
        }
    }

    @RequestMapping(value = "/getCollections/{uid}")
    public String getCollectionsByUid(@PathVariable("uid") int uid, HttpServletRequest request) {
        PostCollection postCollection = postCollectionService.getPostCollectionByUid(uid);//获取该用户的关注列表
        String postIdStr = postCollection.getPostId();
        String[] strArr = postIdStr.split(";");
        List<Post> posts = new ArrayList<>();
        int postCount=0;
        for (String s : strArr) {
            try {
                Post post = postService.getPostById(Integer.valueOf(s));
                posts.add(post);
                postCount++;
            } catch (Exception e) {
                //没有找到指定的帖子之后更新收藏表
                int index = postIdStr.indexOf(s);
                StringBuilder sb = new StringBuilder(postIdStr);
                sb.delete(index, index + 2);
                postCollection.setPostId(sb.toString());
                int result = postCollectionService.updataPostCollection(postCollection);
                //更新用户信息表
                User user = userService.getUserById(uid);
                user.setPostCollectionNum(user.getPostCollectionNum() - 1);
                int updateU = userService.updateUser(user);
                request.getSession().setAttribute("user",user);
                if(updateU<0){
                    System.out.println("更新用户信息失败");
                }
                if (result < 0||updateU<0) {
                    break;
                } else {
                    System.out.println("帖子被删除之后，重新设置帖子收藏" + sb.toString());
                    //这里为空代表收藏的帖子不存在
                    break;
                }
            }
        }
        request.getSession().setAttribute("postCount", postCount);
        request.getSession().setAttribute("Posts", posts);
        return "post/collection";
    }

}