package zyy.campuscommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.entity.UserExample;
import zyy.campuscommunity.entity.UserExample.Criteria;
import zyy.campuscommunity.mapper.UserMapper;
import zyy.campuscommunity.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUserById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public int updateUser(User user) {
        int result = userMapper.updateByPrimaryKey(user);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
	}

	@Override
	public List<User> getUserByName(String name) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserNameEqualTo(name);
		List<User> user = userMapper.selectByExample(example);  //获取列表第一个用户
		return user;
	}

	@Override
	/** 
	* @Description: 获取所有用户，用来在后台管理系统用
	* @Param: [] 
	* @return: java.util.List<zyy.campuscommunity.entity.User> 
	* @Author: zhaoyy
	* @Date: 2019/5/6 13:33
	*/ 
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}
}
