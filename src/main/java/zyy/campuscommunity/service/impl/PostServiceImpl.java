package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Post;
import zyy.campuscommunity.entity.PostExample;
import zyy.campuscommunity.mapper.PostMapper;
import zyy.campuscommunity.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;

    /** 
    * @Description:  发布帖子
    * @Param: [post] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/3/29 10:14
    */ 
    public int insert(Post post) {
        return postMapper.insert(post);
    }

    @Override
    /** 
    * @Description: 通过帖子id进行查找，用来进行帖子的查看和删除等
    * @Param: [id] 
    * @return: zyy.campuscommunity.entity.Post 
    * @Author: zhaoyy
    * @Date: 2019/4/1 13:57
    */ 
    public Post getPostById(int id) {
        Post post = postMapper.selectByPrimaryKey(id);
        System.out.println(post.toString());
        return post;
    }

    @Override
    /** 
    * @Description: 更新帖子信息，比如点击次数等
    * @Param: [post] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/4/2 11:13
    */ 
    public int updatePost(Post post) {
        int i = postMapper.updateByPrimaryKey(post);
        if(i<0){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
   /** 
   * @Description: 通过点击相应的TabId(二级标题)获取相应的有关所有帖子
   * @Param: [tabId] 
   * @return: java.util.List<zyy.campuscommunity.entity.Post> 
   * @Author: zhaoyy
   * @Date: 2019/4/1 13:55
   */ 
    public List<Post> getPostByTabId(int tabId) {
        PostExample example = new PostExample();
        PostExample.Criteria criteria = example.createCriteria();
        criteria.andPostTabIdEqualTo(tabId);
        List<Post> posts = postMapper.selectByExample(example);
        return posts;
    }

    @Override
   /** 
   * @Description: 通过父标签的Id(一级标题)找到所有的帖子,既点击相应的父标题后，输出所有对应的子帖子 
   * @Param: [parentId] 
   * @return: java.util.List<zyy.campuscommunity.entity.Post> 
   * @Author: zhaoyy
   * @Date: 2019/4/1 13:55
   */ 
    public List<Post> getPostByParentId(int parentId) {
        PostExample example = new PostExample();
        PostExample.Criteria criteria = example.createCriteria();
        criteria.andTabParentidEqualTo(parentId);
        List<Post> posts = postMapper.selectByExample(example);
        return posts;
    }
}
