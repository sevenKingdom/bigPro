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
    List<ConstructionPlan> getOneDayList(Long startTime, Long endTime, String technicianIds);

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

    List<Long> getTechnicianid( String department);

    /**
     * 根据工班长id获取当天任务列表
     *
     * @param startTime
     * @param endTime
     * @param calssId
     * @return
     */
    List<ConstructionPlan> getOneDayProcessListByClassId(Long startTime, Long endTime, Long calssId);

    List<ConstructionPlan> getListByInspectorid( Long inspectorid,Long startTime,  Long endTime);

    ConstructionPlan getByid( Long id);

}
