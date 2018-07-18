package com.cmbchina.depin.service;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wdphu on 2017/7/19.
 */
@Repository
public interface ITestService {
    void testInsertPartyInPartyDao(int partyId, int userId);
}
