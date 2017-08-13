package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.ClassReviewRecordMapper;
import com.carry.model.mysql.po.ClassReviewRecord;
import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.service.ClassReviewRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songxianying on 17/8/13.
 */
@Service
public class ClassReviewRecordServiceImpl implements ClassReviewRecordService {
    @Autowired
    private ClassReviewRecordMapper classReviewRecordMapper;

    @Transactional
    @Override
    public long addClassReviewRecord(ClassReviewRecord classReviewRecord) {
        return classReviewRecordMapper.addClassReviewRecord(classReviewRecord);
    }
}
