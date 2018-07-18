package com.cmbchina.depin.service;

import com.cmbchina.depin.dao.LaunchPartyDao;
import com.cmbchina.depin.dao.PartyDao;
import com.cmbchina.depin.dao.PlaceDao;
import com.cmbchina.depin.dao.SelectionDao;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.service.Impl.LaunchServiceImpl;
import com.cmbchina.depin.vo.PartyLaunchVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by wdphu on 2017/7/21.
 */
@RunWith(MockitoJUnitRunner.class)
public class LaunchServiceImplTest {
    @Mock
    private PartyDao partyDao;

    @Mock
    private SelectionDao selectionDao;

    @Mock
    private LaunchPartyDao launchPartyDao;

    @Mock
    private PlaceDao placeDao;

    @InjectMocks
    private LaunchServiceImpl launchService;

//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testGetAllPartyLaunchedByMeSuccess(){
        //造数据
        List<Integer> placeIds = new ArrayList<>();

        List<Party> partys = new ArrayList<>();

        Timestamp timestamp = Timestamp.valueOf("2017-1-2 0:0:0");
        Party party1 = new Party(1, "party1", timestamp, timestamp, "description1", 1);
        partys.add(party1);

        Place place = new Place(1, "name1", "address1", "description1");

        List<Place> places = new ArrayList<>();
        places.add(place);

        placeIds.add(1);
        Selection selection = new Selection(1, 1, 1);

        List<PartyLaunchVo> partyLaunchVos = new ArrayList<>();
        partyLaunchVos.add(new PartyLaunchVo(party1, true, places, "1"));
        //Mock
        Mockito.doReturn(partys).when(partyDao).selectPartyByUserId(Mockito.anyInt());
        Mockito.doReturn(place).when(placeDao).getPlaceInfoByPlaceId(Mockito.anyInt());
        Mockito.doReturn(placeIds).when(selectionDao).getMostSelectedPlaceIdByPartyId(Mockito.anyInt());
        Mockito.doReturn(selection).when(selectionDao).getPartyStateByPartyId(Mockito.anyInt());


        //调用
        List<PartyLaunchVo> partyLaunchVoList = launchService.getAllPartyLaunchedByMe(1);

        //验证
//        verify(selectionDao, Mockito.times(2)).getPartyStateByPartyId(Mockito.anyInt());
        assertEquals(partyLaunchVos, partyLaunchVoList);
    }
//
//    @Test
//    public void testGetAllPartyLaunchedByMeFailed(){
//        //造数据
//        List<Party> partys = new ArrayList<>();
//        Timestamp timestamp = Timestamp.valueOf("2017-1-2 0:0:0");
//        Party party1 = new Party(1, "party1", timestamp, timestamp, "description1", 1);
//        Party party2 = new Party(2, "party1", timestamp, timestamp, "description1", 1);
//        partys.add(party1);
////        partys.add(party2);
//
//        Place place = new Place(1, "name1", "address1", "description1");
//        List<Place> places = new ArrayList<>();
//        places.add(place);
//
//        List<Integer> placeIds = new ArrayList<>();
//        placeIds.add(1);
//
//        Selection selection = new Selection(2, 1, 1);
//
//        //mock
//        Mockito.doReturn(partys).when(partyDao).selectPartyByUserId(Mockito.anyInt());
//        Mockito.doReturn(place).when(placeDao).getPlaceInfoByPlaceId(Mockito.anyInt());
//        Mockito.doReturn(placeIds).when(selectionDao).getMostSelectedPlaceIdByPartyId(Mockito.anyInt());
//        Mockito.doReturn(selection).when(selectionDao).getPartyStateByPartyId(Mockito.anyInt());
//        //调用
//        List<PartyLaunchVo> partyLaunchVoList = launchService.getAllPartyLaunchedByMe(1);
//        //验证
//        List<PartyLaunchVo> partyLaunchVos = new ArrayList<>();
//        partyLaunchVos.add(new PartyLaunchVo(party1, false, places));
//
//        assertEquals(partyLaunchVos.toString(), partyLaunchVoList.toString());
//    }
}
