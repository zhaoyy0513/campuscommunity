package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    int updateUser(User user);
    List<User> getUserByName(String name);
}
