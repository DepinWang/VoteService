package com.cmbchina.depin.model;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by wdphu on 2017/7/16.
 */
public class Party {
    private int partyId;
    private String partyTheme;
    private Timestamp partyCreateTime;
    private Timestamp partyActivityTime;
    private String partyDescription;
    private int partyOwnerId;
    private int partyPlaceId;

    public Party(int partyId, String partyTheme, Timestamp partyCreateTime, Timestamp partyActivityTime, String partyDescription, int partyOwnerId) {
        this.partyId = partyId;
        this.partyTheme = partyTheme;
        this.partyCreateTime = partyCreateTime;
        this.partyActivityTime = partyActivityTime;
        this.partyDescription = partyDescription;
        this.partyOwnerId = partyOwnerId;
    }

    public Party(){}

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getPartyTheme() {
        return partyTheme;
    }

    public void setPartyTheme(String partyTheme) {
        this.partyTheme = partyTheme;
    }

    public Date getPartyCreateTime() {
        return partyCreateTime;
    }

    public void setPartyCreateTime(Timestamp partyCreateTime) {
        this.partyCreateTime = partyCreateTime;
    }

    public Date getPartyActivityTime() {
        return partyActivityTime;
    }

    public void setPartyActivityTime(Timestamp partyActivityTime) {
        this.partyActivityTime = partyActivityTime;
    }

    public String getPartyDescription() {
        return partyDescription;
    }

    public void setPartyDescription(String partyDescription) {
        this.partyDescription = partyDescription;
    }

    public int getPartyOwnerId() {
        return partyOwnerId;
    }

    public void setPartyOwnerId(int partyOwnerId) {
        this.partyOwnerId = partyOwnerId;
    }

    public int getPartyPlaceId(){return partyPlaceId;}

    public void setPartyPlaceId(int partyPlaceId){this.partyPlaceId = partyPlaceId;}

    public String toString(){
        return partyId+partyTheme+partyCreateTime+partyActivityTime+partyDescription+partyPlaceId;
    }
}
