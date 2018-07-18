package com.cmbchina.depin.dao;

import com.cmbchina.depin.model.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wdphu on 2017/7/16.
 */
@Repository
public interface PlaceDao {
    Place getPlaceInfoByPlaceId(int placeId);
    void insertIntoPlace(Place place);
    List<Place> getAllPlaces();
}
