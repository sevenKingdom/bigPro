package com.carry.model.mysql.service;

import com.carry.model.mysql.po.ConstructionPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zj on 2017/7/17.
 */
public interface ConstructionPlanService {
    /**
     * 获取一天的任务
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<ConstructionPlan> getOneDayList(Long startTime, Long endTime);

    /**
     * 插入计划
     *
     * @param constructionPlan
     * @return
     */
    long saveConstructionPlan(ConstructionPlan constructionPlan);

    /**
     * 拿到权限
     *
     * @param
     * @return
     */
    String getPlanAuthor (Long id) ;

    long updatePlanInspector (Long inspectorid, Long id) ;
}
