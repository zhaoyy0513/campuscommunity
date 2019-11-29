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
    /** 
    * @Description: 通过id获取未读信息
    * @Param: [id] 
    * @return: zyy.campuscommunity.entity.Unread 
    * @Author: zhaoyy
    * @Date: 2019/5/7 17:01
    */ 
    public Unread getUnreadById(int id) {
        return unreadMapper.selectByPrimaryKey(id);
    }

    @Override
    /** 
    * @Description: 添加未读信息
    * @Param: [unread] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/5/7 16:42
    */ 
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
    * @Description: 根据id删除未读信息
    * @Param: [id] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/5/7 16:43
    */ 
    public int deleteUnreadById(int id) {
        int result =  unreadMapper.deleteByPrimaryKey(id);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    //根据帖子Id删除收藏
    public int deleteUnreadByPid(int Pid) {
        UnreadExample example = new UnreadExample();
        UnreadExample.Criteria criteria = example.createCriteria();
        criteria.andPostIdEqualTo(Pid);
        int result = unreadMapper.deleteByExample(example);
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