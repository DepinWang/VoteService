package com.cmbchina.depin.vo;

import java.util.List;

/**
 * Created by wdphu on 2017/7/18.
 */
public class RegisterPartyInfoVo {
    private int userId;
    private String partyTheme;
    private String partyActivityTime;
    private String partyDescription;
    private List<Integer> partyPlaceId;
    private List<Integer> partyParticipantId;


    public RegisterPartyInfoVo(){}

    public RegisterPartyInfoVo(int userId, String partyTheme, String partyActivityTime, String partyDescription, List<Integer> partyPlaceId, List<Integer> partyParticipantId) {
        this.userId = userId;
        this.partyTheme = partyTheme;
        this.partyActivityTime = partyActivityTime;
        this.partyDescription = partyDescription;
        this.partyPlaceId = partyPlaceId;
        this.partyParticipantId = partyParticipantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPartyTheme() {
        return partyTheme;
    }

    public void setPartyTheme(String partyTheme) {
        this.partyTheme = partyTheme;
    }

    public String getPartyActivityTime() {
        return partyActivityTime;
    }

    public void setPartyActivityTime(String partyActivityTime) {
        this.partyActivityTime = partyActivityTime;
    }

    public String getPartyDescription() {
        return partyDescription;
    }

    public void setPartyDescription(String partyDescription) {
        this.partyDescription = partyDescription;
    }

    public List<Integer> getPartyPlaceId() {
        return partyPlaceId;
    }

    public void setPartyPlaceId(List<Integer> partyPlaceId) {
        this.partyPlaceId = partyPlaceId;
    }

    public List<Integer> getPartyParticipantId() {
        return partyParticipantId;
    }

    public void setPartyParticipantId(List<Integer> partyParticipantId) {
        this.partyParticipantId = partyParticipantId;
    }

    public String toString(){
        return userId+partyTheme+partyActivityTime+partyDescription+partyPlaceId.toString()+getPartyParticipantId().toString();
    }
}
