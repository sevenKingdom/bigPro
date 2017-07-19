package com.carry.model.mongo.service.serviceimpl;

import com.carry.model.mongo.dao.BridgeInfoRepository;
import com.carry.model.mongo.po.BridgeInfo;
import com.carry.model.mongo.service.BridgeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zj on 2017/7/19.
 */
@Service
public class BridgeInfoServiceImpl implements BridgeInfoService {
    @Autowired
    private BridgeInfoRepository bridgeInfoRepository;

    @Override
    public long saveBridgeInfo(BridgeInfo bridgeInfo) throws Exception {
        Long successFlg = -1L;
        try {
            if (null == bridgeInfo) {
                throw new Exception();
            }

            bridgeInfoRepository.save(bridgeInfo);
            if (null != bridgeInfo.getId()) {
                //bridgeId = Long.valueOf(bridgeInfo.getId());
                successFlg = 1L;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return successFlg;
    }

    @Override
    public List<BridgeInfo> getBridgeInfoList() throws Exception {
        return bridgeInfoRepository.findAll();
    }
}
