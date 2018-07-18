package com.cmbchina.depin.service;

import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.User;
import com.cmbchina.depin.vo.PartyLaunchVo;
import com.cmbchina.depin.vo.PlaceChooseVo;

import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
public interface IAboutService {
    void updateUserInfoByUserId(User user);
    void doFinalChoice(int placeId, int partyId);
    List<PlaceChooseVo> getPartyVoteResult(int partyId);
    List<PlaceChooseVo> getAllPlaceByPartyId(int partyId);
    void addNewUser(String name, String nickname, String password);
//    List<PartyLaunchVo> getPartyByDate(String tempDate);
}
