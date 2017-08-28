package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.RollbackRecordMapper;
import com.carry.model.mysql.po.RollbackRecord;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.service.RollbackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by songxianying on 17/8/27.
 */
@Service
public class RollbackRecordServiceImpl implements RollbackRecordService {

    @Autowired
    private RollbackRecordMapper rollbackRecordMapper;

    @Transactional
    @Override
    public int addRollbackRecord(RollbackRecord rollbackRecord) {
        return rollbackRecordMapper.addRollbackRecord(rollbackRecord);
    }
    @Override
    public List<RollbackRecord> findByDepartment(String department ) {
        return rollbackRecordMapper.findByDepartment(department);
    }

}
