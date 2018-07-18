package com.cmbchina.depin.dao;

import com.cmbchina.depin.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wdphu on 2017/7/14.
 */
@Repository
public interface UserDao {
    void insertUserInfo(User user);
    User selectUserById(int id);
    List<User> getAllUsers();
    void updateUserInfoByUserId(User user);
    int getMaxUserId();
}
