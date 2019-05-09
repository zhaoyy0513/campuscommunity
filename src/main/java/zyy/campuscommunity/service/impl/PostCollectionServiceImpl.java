package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.PostCollection;
import zyy.campuscommunity.entity.PostCollectionExample;
import zyy.campuscommunity.mapper.PostCollectionMapper;
import zyy.campuscommunity.service.PostCollectionService;
import java.util.List;

@Service
public class PostCollectionServiceImpl implements PostCollectionService {
    @Autowired
    PostCollectionMapper postCollectionMapper;

    @Override
    /**
     * @Description: 添加收藏
     * @Param: [postCollection]
     * @return: int
     * @Author: zhaoyy
     * @Date: 2019/5/8 16:53
     */
    public int insertPostCollection(PostCollection postCollection) {
        int result = postCollectionMapper.insert(postCollection);
        if(result>=0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    /**
     * @Description: 更新收藏
     * @Param: [postCollection]
     * @return: int
     * @Author: zhaoyy
     * @Date: 2019/5/8 17:08
     */
    public int updataPostCollection(PostCollection postCollection) {
        int result = postCollectionMapper.updateByPrimaryKey(postCollection);
        if(result>=0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    /**
     * @Description: 删除数据库对应的行(如果收藏为空的话)
     * @Param: [postCollection]
     * @return: int
     * @Author: zhaoyy
     * @Date: 2019/5/8 17:06
     */
    public int deletePostCollection(int Uid) {
        PostCollectionExample example = new PostCollectionExample();
        PostCollectionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Uid);
        int result = postCollectionMapper.deleteByExample(example);
        if(result>=0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    /** 
    * @Description: 根据用户Id,获取该用户的收藏
    * @Param: [Uid] 
    * @return: zyy.campuscommunity.entity.PostCollection 
    * @Author: zhaoyy
    * @Date: 2019/5/8 17:54
    */ 
    public PostCollection getPostCollectionByUid(int Uid) {
        PostCollectionExample example = new PostCollectionExample();
        PostCollectionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Uid);
        return postCollectionMapper.selectByExample(example).get(0);
    }

    @Override
    /**
     * @Description: 根据用户id获取其关注的所有帖子
     * @Param: [userId]
     * @return: java.util.List<zyy.campuscommunity.entity.PostCollection>
     * @Author: zhaoyy
     * @Date: 2019/5/8 17:05
     */
    public List<PostCollection> selectPostCollectionsByUid(int userId) {
        PostCollectionExample example = new PostCollectionExample();
        PostCollectionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return postCollectionMapper.selectByExample(example);
    }
}