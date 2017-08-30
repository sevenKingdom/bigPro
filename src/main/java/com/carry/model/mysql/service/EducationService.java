package com.carry.model.mysql.service;

import com.carry.model.mysql.po.Education;

/**
 * Created by Seven on 17/8/13.
 */
public interface EducationService {
    /**
     * 插入工前教育
     *
     * @param education
     * @return
     */
    long save(Education education);
}
