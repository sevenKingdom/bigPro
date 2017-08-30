package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.EducationMapper;
import com.carry.model.mysql.po.Education;
import com.carry.model.mysql.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Seven on 17/8/13.
 */
@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationMapper educationMapper;

    @Override
    public long save(Education education) {
        return educationMapper.saveEducation(education);
    }
}
