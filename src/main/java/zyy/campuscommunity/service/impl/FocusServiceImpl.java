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
    * @Description: 通过前台传递来的用户id,查询该用户关注的所有用户的id 
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
}