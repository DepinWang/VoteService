package com.cmbchina.depin.model;

/**
 * Created by wdphu on 2017/7/17.
 */
public class Selection {
    private int partyId;
    private int userId;
    private int placeId;

    public Selection(){}

    public Selection(int partyId, int userId, int placeId) {
        this.partyId = partyId;
        this.userId = userId;
        this.placeId = placeId;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        str += userId;
        str += placeId;
        return str;
    }
}
