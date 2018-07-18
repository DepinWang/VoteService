package com.cmbchina.depin.service;

import com.cmbchina.depin.model.Party;
import com.cmbchina.depin.vo.PartyLaunchVo;
import com.cmbchina.depin.vo.RegisterPartyInfoVo;

import java.util.List;

/**
 * Created by wdphu on 2017/7/17.
 */
public interface ILaunchService {
    /**获取我发起的party的所有信息
     *包括：party的所有信息，可供选择的地点信息，以及当前选择的结果
     */
    List<PartyLaunchVo> getAllPartyLaunchedByMe(int userId);

    /**发布一个聚会
     * 返回是否发布成功
     */

    boolean registerPartyToServer(RegisterPartyInfoVo registerPartyInfoVo);
}
