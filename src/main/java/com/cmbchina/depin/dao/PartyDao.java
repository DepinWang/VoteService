package com.cmbchina.depin.dao;

import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wdphu on 2017/7/16.
 */
@Repository
public interface PartyDao {
    List<Party> selectPartyByUserId(int userId);
    int getMaxPartyId();
    void insertPartyInfo(Party party);
    Party getPartyInfoByPartyId(int partyId);
    void setPartyPlaceIdByPartyId(int placeId, int partyId);
    Party gePartyInfoByPartyId(int partyId);
    List<Party> getPartyByDate(String tempDate);
}
