package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Post;

import java.util.List;

public interface PostService {
    int insert(Post post);
    int deletePostById(int Pid);
    int updatePost(Post post);
    int getLastPostNum();
    Post getPostById(int id);
    List<Post> getPostByUid(int Uid);
    List<Post> getPostByLike(String likeStr);
    List<Post> getPostByTabId(int tabId);
    List<Post> getPostByParentId(int parentId);
    List<Post> getAllPost();
}
