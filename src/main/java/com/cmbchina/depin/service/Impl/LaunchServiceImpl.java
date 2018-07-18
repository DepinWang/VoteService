package com.cmbchina.depin.service.Impl;

import com.cmbchina.depin.dao.LaunchPartyDao;
import com.cmbchina.depin.dao.PartyDao;
import com.cmbchina.depin.dao.PlaceDao;
import com.cmbchina.depin.dao.SelectionDao;
import com.cmbchina.depin.model.LaunchParty;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.service.ILaunchService;
import com.cmbchina.depin.vo.PartyLaunchVo;
import com.cmbchina.depin.vo.RegisterPartyInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Service
public class LaunchServiceImpl implements ILaunchService{
    @Resource
    private PartyDao partyDao;
    @Resource
    private PlaceDao placeDao;
    @Resource
    private SelectionDao selectionDao;
    @Resource
    private LaunchPartyDao launchPartyDao;

    @Override
    @Transactional
    public List<PartyLaunchVo> getAllPartyLaunchedByMe(int userId){
        List<PartyLaunchVo> partyLaunchVos = new ArrayList<>();
        List<Party> parties = partyDao.selectPartyByUserId(userId);

        for (Party tempParty:parties) {
            PartyLaunchVo tempPartyLaunchVo = new PartyLaunchVo();
            tempPartyLaunchVo.setParty(tempParty);

            if(tempParty.getPartyPlaceId() == 0){
                List<Integer> placeIds = selectionDao.getMostSelectedPlaceIdByPartyId(tempParty.getPartyId());
                if(placeIds.size() == 0){
                    placeIds = launchPartyDao.getPlaceIdByPartyId(tempParty.getPartyId());
                    System.out.println("temp:");
                }
                System.out.println(placeIds.size());
                for(int i = 0; i < placeIds.size(); ++i){
                    System.out.println("placeId:" + placeIds.get(i));
                }
                List<Place> places = new ArrayList<>();
                for (int tempPlaceId:placeIds) {
                    places.add(placeDao.getPlaceInfoByPlaceId(tempPlaceId));
                }
                tempPartyLaunchVo.setResultPlace(places);

                Selection tempSelection = selectionDao.getPartyStateByPartyId(tempParty.getPartyId());
                if(tempSelection.getUserId() == tempSelection.getPartyId()){
                    tempPartyLaunchVo.setCompleted(true);
                }
                else {
                    tempPartyLaunchVo.setCompleted(false);
                }
            }
            else{
                List<Place> places = new ArrayList<>();
                Place tempPlace = placeDao.getPlaceInfoByPlaceId(tempParty.getPartyPlaceId());
                places.add(tempPlace);

                tempPartyLaunchVo.setResultPlace(places);

                tempPartyLaunchVo.setCompleted(true);
            }

            partyLaunchVos.add(tempPartyLaunchVo);
        }
        return partyLaunchVos;
    }

    @Override
    @Transactional
    public boolean registerPartyToServer(RegisterPartyInfoVo rvo){
        int curPartyId = partyDao.getMaxPartyId() + 1;
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Timestamp activityTime = Timestamp.valueOf(rvo.getPartyActivityTime());
        Party party = new Party(curPartyId, rvo.getPartyTheme(), currentTime, activityTime, rvo.getPartyDescription(), rvo.getUserId());

        //
        partyDao.insertPartyInfo(party);

        //2
        for(int tempPlaceId: rvo.getPartyPlaceId()){
            LaunchParty launchParty = new LaunchParty(curPartyId, tempPlaceId);
            launchPartyDao.insertIntoLaunchParty(launchParty);
        }

        //3
        for(int tempUserId: rvo.getPartyParticipantId()){
            selectionDao.initSelectionWhenLaunchParty(curPartyId, tempUserId);
        }

        return true;
    }
}
