package com.cmbchina.depin.service.Impl;

import com.cmbchina.depin.dao.UserDao;
import com.cmbchina.depin.model.User;
import com.cmbchina.depin.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wdphu on 2017/7/17.
 */
@Service
public class LoginServiceImpl implements ILoginService{
    @Resource
    private UserDao userDao;

    @Override
    public User loginToServer(User user){
        User temp = userDao.selectUserById(user.getId());
        return temp;
    }
}
