package com.cmbchina.depin.model;

/**
 * Created by wdphu on 2017/7/16.
 */
public class Place {
    private int placeId;
    private String placeName;
    private String placeAddress;
    private String placeDescription;

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName(){return placeName;}

    public void setPlaceName(String placeName){
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public Place(int placeId, String placeName, String placeAddress, String placeDescription) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.placeDescription = placeDescription;
    }

    public Place(){}

    public String toString(){
        return placeId+placeName+placeAddress+placeDescription;
    }
}
