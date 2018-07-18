package com.cmbchina.depin.model;

/**
 * Created by wdphu on 2017/7/17.
 */
public class LaunchParty {
    private int partyId;
    private int placeId;

    public LaunchParty(int partyId, int placeId) {
        this.partyId = partyId;
        this.placeId = placeId;
    }

    public LaunchParty(){}

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String toString(){
        String str = new String();
        str += partyId;
        str += placeId;
        return str;
    }
}

