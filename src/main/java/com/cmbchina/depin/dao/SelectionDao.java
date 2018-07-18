package com.cmbchina.depin.dao;

import com.cmbchina.depin.model.Selection;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Repository
public interface SelectionDao {
    Selection getPartyStateByPartyId(int partyId);
    List<Integer> getMostSelectedPlaceIdByPartyId(int partyId);
    void initSelectionWhenLaunchParty(int partyId, int userId);
    void doYourSelection(Selection selection);
    List<Integer> getPartyIdWhoCalledMeUndo(int userId);
    List<Integer> getPartyIdWhoCalledMeDone(int userId);
    int getPlaceIdByPartyIdAndUserId(int partyId, int userId);
    boolean updateSelectionWhenDoChoice(Selection selection);
    List<Selection> getSelectionResultByPartyId(int partyId);
}
