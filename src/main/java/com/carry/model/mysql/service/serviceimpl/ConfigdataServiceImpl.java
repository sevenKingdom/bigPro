package com.carry.model.mysql.service.serviceimpl;


import com.carry.model.mysql.dao.ConfigdataMapper;
import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.service.ConfigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songxianying on 17/7/12.
 */
@Service
public class ConfigdataServiceImpl implements ConfigdataService {
    @Autowired
    private ConfigdataMapper testMapper;
    @Transactional
    @Override
    public Configdata findOrganization() {
        return testMapper.findTest(1);
    }
    @Transactional
    @Override
    public Configdata findProcesses(Integer id) {
        return testMapper.findTest(id);
    }
}
