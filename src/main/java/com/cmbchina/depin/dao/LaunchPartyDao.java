package com.cmbchina.depin.dao;

import com.cmbchina.depin.model.LaunchParty;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Repository
public interface LaunchPartyDao {
    void insertIntoLaunchParty(LaunchParty launchParty);
    List<Integer> getPlaceIdByPartyId(int partyId);
}
