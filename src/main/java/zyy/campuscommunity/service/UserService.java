package zyy.campuscommunity.service;

import zyy.campuscommunity.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    List<User> getUserByName(String name);
}
