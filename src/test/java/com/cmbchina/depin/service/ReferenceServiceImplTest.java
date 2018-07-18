package com.cmbchina.depin.service;

import com.cmbchina.depin.dao.LaunchPartyDao;
import com.cmbchina.depin.dao.PartyDao;
import com.cmbchina.depin.dao.PlaceDao;
import com.cmbchina.depin.dao.SelectionDao;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.service.Impl.ReferenceService;
import com.cmbchina.depin.vo.PartyLaunchVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.cmbchina.depin.model.Place;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by wdphu on 2017/7/21.
 */
@RunWith(MockitoJUnitRunner.class)
public class ReferenceServiceImplTest {
    @Mock
    private PartyDao partyDao;

    @Mock
    private SelectionDao selectionDao;

    @Mock
    private LaunchPartyDao launchPartyDao;

    @Mock
    private PlaceDao placeDao;

    @InjectMocks
    private ReferenceService referenceService;

    @Test
    public void testGetPartyInfoCalledMeDone(){
        //make data
        List<Integer> partyIdList = new ArrayList<>();
        partyIdList.add(1);

        Timestamp time = Timestamp.valueOf("2017-1-1 12:00:00");
        Party partyInfo = new Party(1, "123", time, time, "456", 1);

        List<Integer> placeIdList = new ArrayList<>();
        placeIdList.add(1);

        Place placeInfo = new Place(1, "11", "22", "33");

        int resultPlaceInfo = 1;

        //mock
        Mockito.doReturn(partyIdList).when(selectionDao).getPartyIdWhoCalledMeDone(Mockito.anyInt());
        Mockito.doReturn(partyInfo).when(partyDao).getPartyInfoByPartyId(Mockito.anyInt());
        Mockito.doReturn(placeIdList).when(launchPartyDao).getPlaceIdByPartyId(Mockito.anyInt());
        Mockito.doReturn(placeInfo).when(placeDao).getPlaceInfoByPlaceId(Mockito.anyInt());
        Mockito.doReturn(resultPlaceInfo).when(selectionDao).getPlaceIdByPartyIdAndUserId(Mockito.anyInt(),Mockito.anyInt());

        //do reference
        List<PartyLaunchVo>partyLaunchVos = referenceService.getPartyInfoCalledMeDone(1);
        //confirm
        List<Place> places = new ArrayList<>();
        places.add(placeInfo);
        List<PartyLaunchVo>partyLaunchVoList = new ArrayList<>();
        PartyLaunchVo partyLaunchVo = new PartyLaunchVo(partyInfo, false, places, "1");
        partyLaunchVoList.add(partyLaunchVo);

//        assertEquals(partyLaunchVoList.toString(), partyLaunchVos.toString());
        assertEquals(partyLaunchVoList.toString(), partyLaunchVos.toString());
    }
}
