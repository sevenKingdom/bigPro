package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.ConstructionPlan;
import com.carry.model.mysql.service.ConstructionPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zj on 2017/7/17.
 */
@RestController
@RequestMapping("/construction-plan")
public class ConstructionPlanController {
    @Autowired
    private ConstructionPlanService constructionPlanService;

    @RequestMapping(value = "/getOneDayList")
    public List<ConstructionPlan> getOneDayList(Long startTime, Long endTime, String technicianIds) {
        List<ConstructionPlan> result = new ArrayList<>();
        try {
            result = constructionPlanService.getOneDayList(startTime, endTime, technicianIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/save")
    public long saveConstructionPlan(@RequestBody ConstructionPlan constructionPlan) {
        long planId = 0;
        try {
            planId = constructionPlanService.saveConstructionPlan(constructionPlan);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return planId;
    }

    @RequestMapping(value = "/updatePlanInspector")
    public long updatePlanInspector (@RequestParam("inspectorid") Long inspectorid, @RequestParam("id") Long id) {
        return constructionPlanService.updatePlanInspector(inspectorid, id);
    }

    @RequestMapping(value = "/getTechnicianid")
    public List<Long> getTechnicianid(@RequestParam("department") String department) {
        return constructionPlanService.getTechnicianid(department);
    }

    @RequestMapping(value = "/getOneDayProcessListByClassId")
    public List<ConstructionPlan> getOneDayProcessListByClassId(@RequestParam("startTime") Long startTime, @RequestParam("endTime") Long endTime, @RequestParam("classId") Long classId) {
        return constructionPlanService.getOneDayProcessListByClassId(startTime, endTime, classId);
    }

    @RequestMapping(value = "/getListByInspectorid")
    public List<ConstructionPlan> getListByInspectorid(@RequestParam("inspectorid") Long inspectorid,
                                                @RequestParam("startTime") Long startTime,
                                                @RequestParam("endTime") Long endTime) {
        return constructionPlanService.getListByInspectorid(inspectorid, startTime, endTime) ;
    }

    @RequestMapping(value = "/getPLanById")
    public ConstructionPlan getByid(@RequestParam("id") Long id) {
        return constructionPlanService.getByid(id);
    }

    @RequestMapping(value = "/delPlanData")
    public int delPlanData(@RequestParam("id") long id) {
        return constructionPlanService.delPlanData(id);
    }
}
