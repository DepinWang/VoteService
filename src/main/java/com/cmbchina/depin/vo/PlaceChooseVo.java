package com.cmbchina.depin.vo;

import com.cmbchina.depin.model.Place;

/**
 * Created by wdphu on 2017/7/23.
 */
public class PlaceChooseVo {
    Place place;
    int placeTime;

    public PlaceChooseVo(){}

    public PlaceChooseVo(Place place, int placeTime) {
        this.place = place;
        this.placeTime = placeTime;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(int placeTime) {
        this.placeTime = placeTime;
    }

    public String toString(){
        return place.toString() + placeTime;
    }
}
