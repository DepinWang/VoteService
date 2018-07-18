package com.cmbchina.depin.service.Impl;

import com.cmbchina.depin.dao.*;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.model.User;
import com.cmbchina.depin.service.IReferenceService;
import com.cmbchina.depin.vo.PartyLaunchVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Service
public class ReferenceService implements IReferenceService{
    @Resource
    private LaunchPartyDao launchPartyDao;
    @Resource
    private PartyDao partyDao;
    @Resource
    private PlaceDao placeDao;
    @Resource
    private SelectionDao selectionDao;
    @Resource
    private UserDao userDao;

    @Override
    public List<PartyLaunchVo> getPartyInfoCalledMeDone(int userId){
        List<Integer> partyIdList = selectionDao.getPartyIdWhoCalledMeDone(userId);
        List<PartyLaunchVo> partyLaunchVoList = getPartyInfoByPartyIdList(partyIdList, 1, userId);
        return partyLaunchVoList;
    }

    @Override
    public List<PartyLaunchVo> getPartyInfoCalledMeUndo(int userId){
        List<Integer> partyIdList = selectionDao.getPartyIdWhoCalledMeUndo(userId);
        List<PartyLaunchVo> partyLaunchVoList = getPartyInfoByPartyIdList(partyIdList, 0, userId);
        return partyLaunchVoList;
    }

    List<PartyLaunchVo> getPartyInfoByPartyIdList(List<Integer> partyIdList, int tag, int userId){
        List<PartyLaunchVo> partyLaunchVoList = new ArrayList<PartyLaunchVo>();

        for(int tempPartyId: partyIdList){
            PartyLaunchVo tempPartyLaunchVo = new PartyLaunchVo();
            Party tempParty = partyDao.getPartyInfoByPartyId(tempPartyId);
//            System.out.println(tempParty.getPartyId());

            List<Place> tempPlaceList = new ArrayList<Place>();

            if(partyDao.getPartyInfoByPartyId(tempParty.getPartyId()).getPartyPlaceId() != 0){
                tempPartyLaunchVo.setCompleted(true);

                Place tempPlace = placeDao.getPlaceInfoByPlaceId(tempParty.getPartyPlaceId());
                tempPlaceList.add(tempPlace);
            }
            else{
                tempPartyLaunchVo.setCompleted(false);

                if(tag == 0){
                    List<Integer> tempPlaceIdList = launchPartyDao.getPlaceIdByPartyId(tempPartyId);
                    for(int tempPlaceId:tempPlaceIdList){
                        Place tempPlace = placeDao.getPlaceInfoByPlaceId(tempPlaceId);
                        tempPlaceList.add(tempPlace);
//                System.out.println(tempPlace.getPlaceId());
                    }
                }
                else{
                    System.out.print(tempPartyId);
                    int tempPlaceId = selectionDao.getPlaceIdByPartyIdAndUserId(tempPartyId, userId);
                    System.out.print(tempPartyId);
                    Place tempPlace = placeDao.getPlaceInfoByPlaceId(tempPlaceId);
                    tempPlaceList.add(tempPlace);
                }
            }


            User tempUser = userDao.selectUserById(tempParty.getPartyOwnerId());

            tempPartyLaunchVo.setParty(tempParty);
            tempPartyLaunchVo.setPartyOwnerName(tempUser.getName());
            tempPartyLaunchVo.setResultPlace(tempPlaceList);

            partyLaunchVoList.add(tempPartyLaunchVo);
        }
        return partyLaunchVoList;
    }

    @Override
    public void recondTheSelectionOnServer(Selection selection){
        selectionDao.updateSelectionWhenDoChoice(selection);
        return;
    }

    @Override
    public Place getPlaceInfoByPlaceId(int placeId){
        return placeDao.getPlaceInfoByPlaceId(placeId);
    }

    @Override
    @Transactional
    public  List<Place> getPlacesByPartyId(int partyId){
        List<Place> placeList = new ArrayList<>();
        List<Integer> placeIdList = launchPartyDao.getPlaceIdByPartyId(partyId);
        for(int placeId: placeIdList){
            placeList.add(getPlaceInfoByPlaceId(placeId));
        }
        return placeList;
    }
}
