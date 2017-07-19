package com.carry.model.mongo.dao;

import com.carry.model.mongo.po.BridgeInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by zj on 2017/7/19.
 */
@Component
public interface BridgeInfoRepository extends MongoRepository<BridgeInfo,String> {
}
