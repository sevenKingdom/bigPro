package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.ConstructionPlan;
import com.carry.model.mysql.service.ConstructionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<ConstructionPlan> getOneDayList(Long startTime, Long endTime) {
        List<ConstructionPlan> result = new ArrayList<>();
        try {
            result = constructionPlanService.getOneDayList(startTime, endTime);
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

}
