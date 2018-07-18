package com.cmbchina.depin.service;

import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.vo.PartyLaunchVo;

import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
public interface IReferenceService {
    List<PartyLaunchVo> getPartyInfoCalledMeDone(int userId);
    List<PartyLaunchVo> getPartyInfoCalledMeUndo(int userId);
    void recondTheSelectionOnServer(Selection selection);
    Place getPlaceInfoByPlaceId(int placeId);
    List<Place> getPlacesByPartyId(int partyId);
}
