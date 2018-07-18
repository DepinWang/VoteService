package com.cmbchina.depin.vo;

import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;

import java.util.Date;
import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
public class PartyLaunchVo {
    private Party party;
    private boolean isCompleted;
    private List<Place> resultPlace;
    private String partyOwnerName;

    public PartyLaunchVo(){}

    public PartyLaunchVo(Party party, boolean isCompleted, List<Place> resultPlace, String partyOwnerName) {
        this.party = party;
        this.isCompleted = isCompleted;
        this.resultPlace = resultPlace;
        this.partyOwnerName = partyOwnerName;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<Place> getResultPlace() {
        return resultPlace;
    }

    public void setResultPlace(List<Place> resultPlace) {
        this.resultPlace = resultPlace;
    }

    public String toString(){
        return party.toString()+isCompleted+resultPlace.toString();
    }

    public void setPartyOwnerName(String partyOwnerName){
        this.partyOwnerName = partyOwnerName;
    }

    public String getPartyOwnerName(){return partyOwnerName;}
}
