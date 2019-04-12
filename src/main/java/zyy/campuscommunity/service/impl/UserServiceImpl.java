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
	public List<User> getUserByName(String name) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserNameEqualTo(name);
		List<User> user = userMapper.selectByExample(example);  //获取列表第一个用户
		return user;
	}
}
