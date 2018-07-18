package com.cmbchina.depin.controller;

import com.cmbchina.depin.dao.LaunchPartyDao;
import com.cmbchina.depin.dao.SelectionDao;
import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.model.Place;
import com.cmbchina.depin.model.Selection;
import com.cmbchina.depin.model.User;
import com.cmbchina.depin.service.*;
import com.cmbchina.depin.vo.PartyLaunchVo;
import com.cmbchina.depin.vo.PlaceChooseVo;
import com.cmbchina.depin.vo.RegisterPartyInfoVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
@Controller
public class WholeController {
    private User myself;
    private List<PartyLaunchVo> todayLaunchedByMe;
    private List<PartyLaunchVo> todayLaunchedByOther;


    @Resource
    private ILoginService iUserService;

    @Resource
    private ILaunchService iLaunchService;

    @Resource
    private SelectionDao selectionDao;

    @Resource
    private IinitPagesService iinitPagesService;

    @Resource
    private IReferenceService iReferenceService;

    @Resource
    private IAboutService iAboutService;

    @RequestMapping("/admin")
    public String testInsert(ModelMap modelMap){
//        User user = new User(1010, "123", "abc", "bcd");
//        iUserService.loginToServer(user);
        System.out.println("i am here");
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String testLogin(@RequestParam(value = "id") String id,
                            @RequestParam(value = "password") String password,
                            HttpServletRequest request, ModelMap modelMap){
        if((id.equals(""))||(password.equals(""))){
            modelMap.addAttribute("errorInfo", "用户名或密码为空");
            return "login";
        }
        int userId = Integer.parseInt(id);
        User user = new User();
        user.setId(userId);
        user.setPassword(password);

        User tempUser = iUserService.loginToServer(user);
        if(tempUser == null){
            modelMap.addAttribute("errorInfo", "用户名不存在");
            return "login";
        }
        if(tempUser.getPassword().equals(user.getPassword())){
            if(todayLaunchedByMe == null){
                todayLaunchedByMe = new ArrayList<>();
            }
            if(todayLaunchedByOther == null){
                todayLaunchedByOther = new ArrayList<>();
            }
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
            myself = tempUser;
            initPage();
//            System.out.println("login:"+myself.getName()+myself.getNickname());
//            System.out.println("login:"+user.getName()+user.getNickname());
            modelMap.addAttribute("user", tempUser);
            List<PartyLaunchVo> listPartyLaunchVo = iLaunchService.getAllPartyLaunchedByMe(tempUser.getId());
            modelMap.addAttribute("listPartyLaunchVo", listPartyLaunchVo);
//            modelMap.addAttribute("errorInfo", "");
            return "redirect:myLauch";
        }

        modelMap.addAttribute("errorInfo", "用户名或密码错误");
        return "login";
    }

    @RequestMapping(value = "/aboutMe")
    public String callAboutMe(ModelMap modelMap){


        if(todayLaunchedByMe.size() == 0){
            modelMap.addAttribute("noLaunchedByMe", "今天没有要参加的由我发起的聚会");
        }
        if(todayLaunchedByOther.size() == 0){
            modelMap.addAttribute("noLaunchedByOther", "今天没有要参加的被好友邀请的聚会");
        }

        modelMap.addAttribute("user", myself);
        modelMap.addAttribute("todayLaunchedByMe", todayLaunchedByMe);
        modelMap.addAttribute("todayLaunchedByOther", todayLaunchedByOther);
//        todayLaunchedByMe.clear();
//        todayLaunchedByOther.clear();
        return "aboutMe";
    }

    @RequestMapping(value = "/referenceMe")
    public String callReferenceMe(ModelMap modelMap){
        todayLaunchedByMe.clear();
        todayLaunchedByOther.clear();

        List<PartyLaunchVo> partyLaunchVoListUndo = iReferenceService.getPartyInfoCalledMeUndo(myself.getId());
        List<PartyLaunchVo> partyLaunchVoListDone = iReferenceService.getPartyInfoCalledMeDone(myself.getId());

        List<PartyLaunchVo> listPartyLaunchVo = iLaunchService.getAllPartyLaunchedByMe(myself.getId());
        sortVoListOutOfTime(listPartyLaunchVo, 0);

        List<PartyLaunchVo> partyLaunchVoListOutOfWork;

        partyLaunchVoListOutOfWork = sortVoListOutOfTime(partyLaunchVoListUndo, 1);
        partyLaunchVoListOutOfWork.addAll(sortVoListOutOfTime(partyLaunchVoListDone, 1));


        System.out.println(partyLaunchVoListDone.size()+" " + partyLaunchVoListUndo.size());
        if(partyLaunchVoListUndo.size() == 0){
            modelMap.addAttribute("undoList", "没有未处理的邀请");
        }
        else {
            modelMap.addAttribute("undoList", "");
        }
        if(partyLaunchVoListDone.size() == 0){
            modelMap.addAttribute("doneList", "没有已处理的邀请");
        }
        else {
            modelMap.addAttribute("doneList", "");
        }
        if(partyLaunchVoListOutOfWork.size() == 0){
            modelMap.addAttribute("outOfWorkList", "没有失效的邀请");
        }
        else {
            modelMap.addAttribute("outOfWorkList", "");
        }
//        System.out.println("test start");
//        for(PartyLaunchVo temp : partyLaunchVoListDone){
//            System.out.print(temp.getParty().getPartyId()+" ");
//        }
//        System.out.println();
//        for(PartyLaunchVo temp : partyLaunchVoListUndo){
//            System.out.print(temp.getParty().getPartyId()+" ");
//        }
//        System.out.println();
//        for(PartyLaunchVo temp : partyLaunchVoListOutOfWork){
//            System.out.print(temp.getParty().getPartyId()+" ");
//        }
//        System.out.println("test end");
//        return "hello";
        modelMap.addAttribute("partyLaunchVoListUndo", partyLaunchVoListUndo);
        modelMap.addAttribute("partyLaunchVoListDone", partyLaunchVoListDone);
        modelMap.addAttribute("partyLaunchVoListOutOfWork", partyLaunchVoListOutOfWork);
        modelMap.addAttribute("userId", myself.getId());

        return "referenceMe";
    }

    @RequestMapping(value = "/myLauch")
    public String callMyLounch(ModelMap modelMap){
        System.out.println("this is mylauch");
        User tempUser = myself;
        modelMap.addAttribute("user", tempUser);

        todayLaunchedByOther.clear();
        todayLaunchedByMe.clear();

        List<PartyLaunchVo> listPartyLaunchVo = iLaunchService.getAllPartyLaunchedByMe(tempUser.getId());
        List<PartyLaunchVo> listPartyLaunchVoOutOfWork = sortVoListOutOfTime(listPartyLaunchVo, 0);

        if(listPartyLaunchVo.size() == 0){
            modelMap.addAttribute("noPartyLaunched", "当前没有发起的邀请");
        }
        else {
            modelMap.addAttribute("noPartyLaunched", "");
        }
        if(listPartyLaunchVoOutOfWork.size() == 0){
            modelMap.addAttribute("noPartyLaunchOutOfWork", "当前没有已经失效的邀请");
        }
        else {
            modelMap.addAttribute("noPartyLaunchOutOfWork", "");
        }

        modelMap.addAttribute("listPartyLaunchVo", listPartyLaunchVo);
        modelMap.addAttribute("listPartyVoOutOfWork", listPartyLaunchVoOutOfWork);
        return "myLauch";
    }
//
//    @RequestMapping(value = "/htmlTest")
//    public String callHtmlTest(){
//        return "htmlTest.html";
//    }


    @RequestMapping(value = "/editNewParty")
    public String callEditNewParty(ModelMap modelMap){
        List<Place> placeList = iinitPagesService.getAllPlaces();
        List<User> userList = iinitPagesService.getAllUsers();
        modelMap.addAttribute("placeList", placeList);
        modelMap.addAttribute("userList", userList);
        return "editNewParty";
    }


    @RequestMapping(value = "/doPlaceChoice")
    public String callDoPlaceChoice(@RequestParam(value = "placeId") int placeId,
                                    @RequestParam(value = "partyId") int partyId){
//        System.out.println("doPlaceChoice；"+placeId +" "+ partyId);
        Selection selection = new Selection(partyId, myself.getId(), placeId);
        iReferenceService.recondTheSelectionOnServer(selection);
        return "redirect:/referenceMe";
    }


    @RequestMapping(value = "/submitNewParty")
    public String submitNewParty(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "partyTheme") String partyTheme,
                                 @RequestParam(value = "partyTimeYear") String partyTimeYear,
                                 @RequestParam(value = "partyTimeMonth") String partyTimeMonth,
                                 @RequestParam(value = "partyTimeDay") String partyTimeDay,
                                 @RequestParam(value = "partyTimeHour") String partyTimeHour,
                                 @RequestParam(value = "partyTimeMinute") String partyTimeMinute,
                                 @RequestParam(value = "partyDescription") String partyDescription,
                                 @RequestParam(value = "placeList") String placeList,
                                 @RequestParam(value = "userList") String userList,
                                 ModelMap modelMap){
//        System.out.println(partyDescription);
//        return "hello";
        if(partyTheme == ""){
            modelMap.addAttribute("errorInfo", "主题不能为空");
            return "errorNewParty";
        }
        if(partyTimeYear.equals("")||partyTimeMonth.equals("")||partyTimeDay.equals("")||partyTimeHour.equals("")||partyTimeMinute.equals("")){
            modelMap.addAttribute("errorInfo", "时间不能为空");
            return "errorNewParty";
        }
        if(partyDescription == ""){
            modelMap.addAttribute("errorInfo", "聚会描述不能为空");
            return "errorNewParty";
        }
        if(placeList == ""){
            modelMap.addAttribute("errorInfo", "聚会地点不能为空");
            return "errorNewParty";
        }
        if(userList == ""){
            modelMap.addAttribute("errorInfo", "邀请人员不能为空");
            return "errorNewParty";
        }
        String partyActivityTime = partyTimeYear+"-"+partyTimeMonth+"-"+partyTimeDay+" "+partyTimeHour+":"+partyTimeMinute+":00";
        List<Integer> placeIdList = parseIntListFromString(placeList);
        List<Integer> userIdList = parseIntListFromString(userList);

        RegisterPartyInfoVo registerPartyInfoVo = new RegisterPartyInfoVo(myself.getId(), partyTheme, partyActivityTime, partyDescription, placeIdList, userIdList);
        iLaunchService.registerPartyToServer(registerPartyInfoVo);

        return "redirect:myLauch";
    }

    public List<Integer> parseIntListFromString(String strList){
        List<Integer> resultList = new ArrayList<Integer>();
        int index = 0;
        while(index < strList.length()){
            int tempIndex = strList.indexOf(',', index);
            String subIntString = strList.substring(index, tempIndex);
            int tempInt = Integer.parseInt(subIntString);
//            System.out.println(tempIndex+" " + index +" " + subIntString + " " + tempInt);
            resultList.add(tempInt);
            index = tempIndex + 1;
        }
        return resultList;
    }

    @RequestMapping(value = "/place/{partyId}")
    public String callPlaceById(@PathVariable int partyId, ModelMap modelMap){
        List<Place> place = iReferenceService.getPlacesByPartyId(partyId);
        modelMap.addAttribute("placeList", place);
        modelMap.addAttribute("partyId", partyId);
        return "placeInfo";
    }

    @RequestMapping(value = "modifyUserInfo")
    public String callModifyUserInfo(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "nickname") String nickname,
                                     ModelMap modelMap){
        User user = new User(myself.getId(), myself.getPassword(), name, nickname);
        iAboutService.updateUserInfoByUserId(user);
        myself = user;
        modelMap.addAttribute("user", user);
        return "aboutMe";
    }

    @RequestMapping(value = "errorNewParty")
    public String callErrorNewParty(){
        return "errorNewParty";
    }

    @RequestMapping(value = "hello")
    public String callHello(@RequestParam(value = "test")String test){
        System.out.println(test);
        return "hello";
    }

    @RequestMapping(value = "doFinalChoice")
    public String callDoFinalChoice(@RequestParam(value = "partyId") int partyId,
                                    ModelMap modelMap){
        List<PlaceChooseVo> placeChooseVoList = iAboutService.getPartyVoteResult(partyId);
        if(placeChooseVoList.size() == 0){
            placeChooseVoList = iAboutService.getAllPlaceByPartyId(partyId);
        }
        Selection selection = selectionDao.getPartyStateByPartyId(partyId);
        modelMap.addAttribute("allUser", selection.getUserId());

        modelMap.addAttribute("partyId", partyId);
        modelMap.addAttribute("placeChooseVoList", placeChooseVoList);
//        System.out.println("depinstart "+placeChooseVoList.toString()+" depinend");
        return "doFinalChoice";
    }

    @RequestMapping(value = "submitPartyPlaceId")
    public String submitPartyPlace(@RequestParam(value = "placeId") int placeId,
                                   @RequestParam(value = "partyId") int partyId){
        iAboutService.doFinalChoice(placeId, partyId);
        return "redirect: myLauch";
//        System.out.println("hello" + partyId+" "+placeId);
//        return "hello";
    }

    public List<PartyLaunchVo> sortVoListOutOfTime(List<PartyLaunchVo> partyLaunchVoList, int tag){
        List<PartyLaunchVo> partyLaunchVoListOutOfWork = new ArrayList<>();
//        todayLaunchedByMe.clear();
//        todayLaunchedByOther.clear();

        Timestamp timestamp = Timestamp.valueOf("2017-07-20 00:00:00");
        int i = 0;
        while (i < partyLaunchVoList.size()){
            //add to today
            if(isPartyActivityToday(timestamp, partyLaunchVoList.get(i))){
                if(tag == 0){
                    //by me
                    todayLaunchedByMe.add(partyLaunchVoList.get(i));
                }
                else{
                    //by others
                    todayLaunchedByOther.add(partyLaunchVoList.get(i));
                }
            }

            //add to refrence me
            if(partyLaunchVoList.get(i).getParty().getPartyActivityTime().getTime() < timestamp.getTime()){
                partyLaunchVoListOutOfWork.add(partyLaunchVoList.get(i));
                partyLaunchVoList.remove(i);
            }
            else{
                i++;
            }
        }
        return partyLaunchVoListOutOfWork;
    }

    public boolean isPartyActivityToday(Timestamp tempTime, PartyLaunchVo tempVo){
        if(tempVo.getParty().getPartyActivityTime().after(tempTime)){
            return true;
        }
        else{
            return false;
        }
    }

    public void initPage(){
        todayLaunchedByMe = new ArrayList<>();
        todayLaunchedByOther = new ArrayList<>();

        List<PartyLaunchVo> partyLaunchVoListUndo = iReferenceService.getPartyInfoCalledMeUndo(myself.getId());
        List<PartyLaunchVo> partyLaunchVoListDone = iReferenceService.getPartyInfoCalledMeDone(myself.getId());

        sortVoListOutOfTime(partyLaunchVoListUndo, 1);
        sortVoListOutOfTime(partyLaunchVoListDone, 1);
    }


    @RequestMapping(value = "addNewUser")
    public String callAddNewUser(){
        return "addNewUser";
    }

    @RequestMapping(value = "submitNewUser")
    public String callSubmitNewUser(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "nickname") String nickname,
                                    @RequestParam(value = "password") String password){
        iAboutService.addNewUser(name, nickname, password);
//        System.out.println(name + " " + nickname + " " + password);
        return "redirect:aboutMe";
    }
}
