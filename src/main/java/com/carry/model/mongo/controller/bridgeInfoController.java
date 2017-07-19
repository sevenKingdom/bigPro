package com.carry.model.mongo.controller;

import com.carry.model.mongo.po.BridgeInfo;
import com.carry.model.mongo.service.BridgeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zj on 2017/7/19.
 */
@RestController
@RequestMapping("/bridgeInfo/")
public class bridgeInfoController {
    @Autowired
    private BridgeInfoService bridgeInfoService;

    @RequestMapping(value = "/save")
    public long saveBridgeInfo(@RequestBody BridgeInfo bridgeInfo) {
        long bridgeId = 0;
        try {
            bridgeId = bridgeInfoService.saveBridgeInfo(bridgeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bridgeId;
    }

    @RequestMapping(value = "/getBridgeInfoList")
    public List<BridgeInfo> getBridgeInfoList() {
        try {
            return bridgeInfoService.getBridgeInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
