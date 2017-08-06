package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.ConstructionPlanMapper;
import com.carry.model.mysql.po.ConstructionPlan;
import com.carry.model.mysql.service.ConstructionPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zj on 2017/7/17.
 */
@Service
public class ConstructionPlanServiceImpl implements ConstructionPlanService {
    @Autowired
    private ConstructionPlanMapper constructionPlanMapper;

    /**
     * 获取一天的任务
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<ConstructionPlan> getOneDayList(Long startTime, Long endTime) {
        return constructionPlanMapper.getListByTime(startTime, endTime);
    }

    /**
     * 插入计划
     *
     * @param constructionPlan
     * @return
     */
    @Override
    public long saveConstructionPlan(ConstructionPlan constructionPlan) {
        constructionPlanMapper.saveConstructionPlan(constructionPlan);
        return constructionPlan.getId();
    }
    @Override
    public String getPlanAuthor (Long id) {
        return constructionPlanMapper.getPlanAuthor(id);
    }
    @Override
    public long updatePlanInspector (Long inspectorid, Long id) {
        return constructionPlanMapper.updatePlanInspector(inspectorid, id);
    }
}
