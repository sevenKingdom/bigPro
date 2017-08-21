package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.ReviewPlan;
import com.carry.model.mysql.service.ReviewPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/findReviewPlanByToken" ,method = RequestMethod.POST)
    public List<ReviewPlan> findReviewPlanByToken (@RequestParam("token") String token) {
        return reviewPlanService.findReviewPlanByToken(token);
    }

    @RequestMapping(value = "/updateReviewPlan" ,method = RequestMethod.POST)
    public long updateReviewPlan(@RequestParam("id") long id,@RequestParam("reviewer") long reviewer ) {
        return reviewPlanService.updateReviewPlan(id, reviewer);
    }

    @RequestMapping(value = "/findReviewPlanByreviewer" ,method = RequestMethod.POST)
    public List<ReviewPlan> findReviewPlanByreviewer(@RequestParam("reviewer") long reviewer) {
        return reviewPlanService.findReviewPlanByreviewer(reviewer);
    }

    @RequestMapping(value = "/findReviewPlanById" ,method = RequestMethod.POST)
    public ReviewPlan findReviewPlanById(@RequestParam("id") long id){
        return reviewPlanService.findReviewPlanById(id);
    }
}
