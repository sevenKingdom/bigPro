package com.carry.model.mysql.service.serviceimpl;


import com.carry.model.mysql.dao.TestMapper;
import com.carry.model.mysql.po.Test;
import com.carry.model.mysql.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songxianying on 17/7/12.
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Transactional
    @Override
    public Test findAccountList() {
        return testMapper.findTest(1);
    }
}
