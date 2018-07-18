package com.cmbchina.depin.service;

import com.cmbchina.depin.model.User;

/**
 * Created by wdphu on 2017/7/17.
 */
public interface ILoginService {
    User loginToServer(User user);
}
