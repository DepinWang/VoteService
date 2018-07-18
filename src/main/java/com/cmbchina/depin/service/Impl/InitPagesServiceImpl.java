package com.cmbchina.depin.service.Impl;

import com.cmbchina.depin.dao.PlaceDao;
import com.cmbchina.depin.dao.UserDao;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.User;
import com.cmbchina.depin.service.IinitPagesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Service
public class InitPagesServiceImpl implements IinitPagesService {
    @Resource
    private PlaceDao placeDao;

    @Resource
    private UserDao userDao;

    public List<Place> getAllPlaces(){
        return placeDao.getAllPlaces();
    }

    public  List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
