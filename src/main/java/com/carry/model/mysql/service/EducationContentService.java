package com.carry.model.mysql.service;

import com.carry.model.mysql.po.EducationContent;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
public interface EducationContentService {
    List<EducationContent> getListByIds(String dataIds);
}
