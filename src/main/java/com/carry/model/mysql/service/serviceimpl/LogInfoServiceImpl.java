package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.LogInfoMapper;
import com.carry.model.mysql.dao.NoticeMapper;
import com.carry.model.mysql.po.Loginfo;
import com.carry.model.mysql.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songxianying on 17/8/29.
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public List<Loginfo> getListOneDay(String department) {
        return logInfoMapper.getListOneDay(department);
    }
}
