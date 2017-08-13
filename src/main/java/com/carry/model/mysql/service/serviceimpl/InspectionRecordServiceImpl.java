package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.InspectionRecordMapper;
import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.service.InspectionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songxianying on 17/8/13.
 */
@Service
public class InspectionRecordServiceImpl implements InspectionRecordService {
    @Autowired
    private InspectionRecordMapper inspectionRecordMapper;

    @Transactional
    @Override
    public long addInspectionRecord(InspectionRecord inspectionRecord) {
        return inspectionRecordMapper.addInspectionRecord(inspectionRecord);
    }
}
