package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.EducationContentMapper;
import com.carry.model.mysql.po.EducationContent;
import com.carry.model.mysql.service.EducationContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
@Service
public class EducationContentServiceImpl implements EducationContentService {
    @Autowired
    private EducationContentMapper educationContentMapper;

    @Override
    public List<EducationContent> getListByIds(String dataIds) {
        return educationContentMapper.getListByIds(dataIds);
    }
}
