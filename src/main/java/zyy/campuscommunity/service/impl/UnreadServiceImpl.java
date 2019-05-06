package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Unread;
import zyy.campuscommunity.entity.UnreadExample;
import zyy.campuscommunity.mapper.UnreadMapper;
import zyy.campuscommunity.service.UnreadService;

import java.util.List;

@Service
public class UnreadServiceImpl implements UnreadService {

    @Autowired
    UnreadMapper unreadMapper;
    @Override
    public int insertUnread(Unread unread) {
       int result = unreadMapper.insert(unread);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    /** 
    * @Description: 通过用户索引id获取该用户所有的未读信息 
    * @Param: [uid] 
    * @return: java.util.List<zyy.campuscommunity.entity.Unread> 
    * @Author: zhaoyy
    * @Date: 2019/5/6 9:21
    */ 
    public List<Unread> getUnreadsByUid(Integer uid) {
        UnreadExample example = new UnreadExample();
        UnreadExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        return unreadMapper.selectByExample(example);
    }

    @Override
    /** 
    * @Description: 获取所有未读信息
    * @Param: [] 
    * @return: java.util.List<zyy.campuscommunity.entity.Unread> 
    * @Author: zhaoyy
    * @Date: 2019/5/6 13:34
    */ 
    public List<Unread> selectAllUnRead() {
        return unreadMapper.selectAllUnRead();
    }
}