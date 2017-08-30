package com.carry.model.mysql.service;

import com.carry.model.mysql.po.Loginfo;

import java.util.List;

/**
 * Created by songxianying on 17/8/29.
 */
public interface LogInfoService {
    List<Loginfo> getListOneDay(String department);
}
