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
    public int insertUser(User user) {
        int result = userMapper.insert(user);
        if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
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
	/**
	 * @Description: 通过姓名查找用户，用于登录验证
	 * @Param: [String name]
	 * @return: java.util.List<zyy.campuscommunity.entity.User>
	 * @Author: zhaoyy
	 * @Date: 2019/5/14 17:55
	 */
	public List<User> getUserByName(String name) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserNameEqualTo(name);
		return userMapper.selectByExample(example);//获
	}

	@Override
	/** 
	* @Description: 获取所有用户，用来在后台管理系统用
	* @Param: [] 
	* @return: java.util.List<zyy.campuscommunity.entity.User> 
	* @Author: zhaoyy
	* @Date: 2019/5/6 13:33
	*/ 
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

	@Override
	//模糊查询用户
	public List<User> getUsersByLike(String likeStr) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		likeStr = "%"+likeStr+"%";
		criteria.andUserNameLike(likeStr);
		return userMapper.selectByExample(example);
	}
}
