package com.cmbchina.depin.service.Impl;

import com.cmbchina.depin.dao.*;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.model.User;
import com.cmbchina.depin.service.IAboutService;
import com.cmbchina.depin.vo.PartyLaunchVo;
import com.cmbchina.depin.vo.PlaceChooseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Service
public class AboutServiceImpl implements IAboutService{
    @Resource
    private UserDao userDao;
    @Resource
    private PartyDao partyDao;
    @Resource
    private SelectionDao selectionDao;
    @Resource
    private PlaceDao placeDao;
    @Resource
    private LaunchPartyDao launchPartyDao;

    @Override
    public void updateUserInfoByUserId(User user){
        userDao.updateUserInfoByUserId(user);
    }

    @Override
    public void doFinalChoice(int placeId, int partyId){
        partyDao.setPartyPlaceIdByPartyId(placeId, partyId);
    }

    @Override
    public List<PlaceChooseVo> getPartyVoteResult(int partyId){
        List<PlaceChooseVo> placeChooseVoList = new ArrayList<>();

        List<Selection> selectionResult =  selectionDao.getSelectionResultByPartyId(partyId);
        for(Selection tempSelection:selectionResult){
            if(tempSelection.getPlaceId() == 0){
                continue;
            }
            System.out.println("temp:"+partyId+" "+tempSelection.getPlaceId());
            Place tempPlace = placeDao.getPlaceInfoByPlaceId(tempSelection.getPlaceId());
            //getUserId()，userId作为count(place_id)的别名保存到了userId中
            PlaceChooseVo tempPlaceChooseVo = new PlaceChooseVo(tempPlace, tempSelection.getUserId());
            placeChooseVoList.add(tempPlaceChooseVo);
        }
        return placeChooseVoList;
    }

    @Override
    public List<PlaceChooseVo> getAllPlaceByPartyId(int partyId){
        List<PlaceChooseVo> placeChooseVoList = new ArrayList<>();
        List<Integer>placeIds = launchPartyDao.getPlaceIdByPartyId(partyId);

        for(int tempPlaceId:placeIds){
            Place tempPlace = placeDao.getPlaceInfoByPlaceId(tempPlaceId);
            PlaceChooseVo tempPlaceChooseVo = new PlaceChooseVo(tempPlace, 0);
            placeChooseVoList.add(tempPlaceChooseVo);
        }
        return placeChooseVoList;
    }

    @Override
    public void addNewUser(String name, String nickname, String password){
        int userId = userDao.getMaxUserId() + 1;
        User user = new User(userId, password, name, nickname);
        userDao.insertUserInfo(user);
    }

}
