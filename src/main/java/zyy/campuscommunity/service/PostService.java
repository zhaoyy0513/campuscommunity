package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.Post;

import java.util.List;

public interface PostService {
    int insert(Post post);
    Post getPostById(int id);
    int updatePost(Post post);
    List<Post> getPostByUid(int Uid);
    List<Post> getPostByTabId(int tabId);
    List<Post> getPostByParentId(int parentId);
    List<Post> selectAllPost();
}
