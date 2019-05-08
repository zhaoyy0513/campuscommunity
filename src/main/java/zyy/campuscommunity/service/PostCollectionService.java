package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.PostCollection;

import java.util.List;

/**
 * @program: campuscommunity
 * @description: 帖子收藏业务接口
 * @author: zhaoyy
 * @create: 2019-05-08 16:45
 */
public interface PostCollectionService {
    int insertPostCollection(PostCollection postCollection);
    int updataPostCollection(PostCollection postCollection);
    int deletePostCollection(int Pid);
    PostCollection getPostCollectionByUid(int Uid);
    List<PostCollection> selectPostCollectionsByUid(int userId);
}
