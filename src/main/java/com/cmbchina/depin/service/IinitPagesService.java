package com.cmbchina.depin.service;

import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Repository
public interface IinitPagesService {
    List<Place> getAllPlaces();
    List<User> getAllUsers();
}
