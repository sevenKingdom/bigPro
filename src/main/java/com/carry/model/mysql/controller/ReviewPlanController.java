package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.ReviewPlan;
import com.carry.model.mysql.service.ReviewPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songxianying on 17/8/13.
 */
@RestController
@RequestMapping("/mysql")
public class ReviewPlanController {
    @Autowired
    ReviewPlanService reviewPlanService;

    @RequestMapping(value = "/addReviewPlan" ,method = RequestMethod.POST)
    public Long addReviewPlan(@RequestBody ReviewPlan reviewPlan) {
        return reviewPlanService.addReviewPlan(reviewPlan);
    }
}
