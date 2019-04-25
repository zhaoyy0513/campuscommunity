package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.campuscommunity.entity.Focus;
import zyy.campuscommunity.entity.FocusExample;
import zyy.campuscommunity.mapper.FocusMapper;
import zyy.campuscommunity.service.FocusService;

import java.util.List;

@Service
public class FocusServiceImpl implements FocusService {
    @Autowired
    FocusMapper focusMapper;

    @Override
    /** 
    * @Description: 添加focus
    * @Param: [focus] 
    * @return: int 
    * @Author: zhaoyy
    * @Date: 2019/4/25 14:31
    */ 
    public int addFocus(Focus focus) {
        int result = focusMapper.insert(focus);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    /**
    * @Description:  删除相应的关注实体
    * @Param: [focus]
    * @return: int
    * @Author: zhaoyy
    * @Date: 2019/4/25 14:48
    */
    public int deleteFocusByUid(int uid) {
        FocusExample example = new FocusExample();
        FocusExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        int result = focusMapper.deleteByExample(example);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    /**
     * @Description: 通过前台传递来的用户id, 查询该用户关注的所有用户的id
     * @Param: [user_id]
     * @return: java.lang.String  是一个拼接出来的字符串
     * @Author: zhaoyy
     * @Date: 2019/4/23 15:40
     */
    public String getFocusUserIdByUid(int user_id) {
        FocusExample example = new FocusExample();
        FocusExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user_id);
        Focus focus = focusMapper.selectByExample(example).get(0);
        return focus.getFocusedId();  //返回所需的被关注者id
    }

    @Override
    /** 
    * @Description: 通过id获取关注的实体 
    * @Param: [user_id] 
    * @return: zyy.campuscommunity.entity.Focus
    * @Author: zhaoyy
    * @Date: 2019/4/25 9:49
    */ 
    public Focus getFocusByUid(int user_id) {
        FocusExample example = new FocusExample();
        FocusExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user_id);
        Focus focus = focusMapper.selectByExample(example).get(0);
        return focus;
    }

    @Override
    /**
     * @Description: 更新关注的人
     * @Param: [focus]
     * @return: int
     * @Author: zhaoyy
     * @Date: 2019/4/25 9:42
     */
    public int updateFocus(Focus focus) {
        int result = focusMapper.updateByPrimaryKey(focus);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}