package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    User getUserById(int id);
    int updateUser(User user);
    List<User> getUserByName(String name);
    List<User> getAllUser();
    List<User> getUsersByLike(String likeStr);
}
