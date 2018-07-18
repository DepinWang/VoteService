package com.cmbchina.depin.service;

import com.cmbchina.depin.dao.*;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.service.Impl.AboutServiceImpl;
import com.cmbchina.depin.vo.PlaceChooseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

/**
 * Created by wdphu on 2017/7/23.
 */
@RunWith(MockitoJUnitRunner.class)
public class AboutServiceImplTest {
    @Mock
    private UserDao userDao;
    @Mock
    private PartyDao partyDao;
    @Mock
    private SelectionDao selectionDao;
    @Mock
    private PlaceDao placeDao;
    @Mock
    private LaunchPartyDao launchPartyDao;

    @InjectMocks
    private AboutServiceImpl aboutService;

    @Test
    public void testGetPartyVoteResult(){
        //造数据
        Selection selection1 = new Selection(0, 2, 1);
        Selection selection2 = new Selection(0, 1, 2);
        List<Selection> selections = new ArrayList<>();
        selections.add(selection1);
        selections.add(selection2);

        Place place1 = new Place(1, "123", "123", "123");
        Place place2 = new Place(2, "123", "123", "123");

        List<PlaceChooseVo> placeChooseVoList = new ArrayList<>();
        PlaceChooseVo placeChooseVo1 = new PlaceChooseVo(place1, 2);
        PlaceChooseVo placeChooseVo2 = new PlaceChooseVo(place2, 1);
        placeChooseVoList.add(placeChooseVo1);
        placeChooseVoList.add(placeChooseVo2);
        //mock
        doReturn(selections).when(selectionDao).getSelectionResultByPartyId(0);
        doReturn(place1).when(placeDao).getPlaceInfoByPlaceId(1);
        doReturn(place2).when(placeDao).getPlaceInfoByPlaceId(2);
        //调用
        List<PlaceChooseVo> placeChooseVos = aboutService.getPartyVoteResult(0);
        //验证
        assertEquals(placeChooseVoList.toString(), placeChooseVos.toString());
    }
}
