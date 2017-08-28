package com.carry.model.mysql.service;

import com.carry.model.mysql.po.RollbackRecord;

import java.util.List;

/**
 * Created by songxianying on 17/8/27.
 */
public interface RollbackRecordService {

    int addRollbackRecord(RollbackRecord rollbackRecord);
    List<RollbackRecord> findByDepartment(String department );
}
