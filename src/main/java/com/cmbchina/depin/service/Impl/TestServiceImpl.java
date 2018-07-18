package com.cmbchina.depin.service.Impl;

import com.cmbchina.depin.dao.LaunchPartyDao;
import com.cmbchina.depin.model.LaunchParty;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wdphu on 2017/7/19.
 */
@Service
public class TestServiceImpl implements ITestService{
    @Resource
    private LaunchPartyDao launchPartyDao;

    @Override
    public void testInsertPartyInPartyDao(int partyId, int userId){
        LaunchParty launchParty = new LaunchParty(partyId,userId);
        launchPartyDao.insertIntoLaunchParty(launchParty);
    }
}
