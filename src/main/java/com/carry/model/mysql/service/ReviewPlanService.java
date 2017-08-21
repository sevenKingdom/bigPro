package com.carry.model.mysql.service;

import com.carry.model.mysql.po.ReviewPlan;

import java.util.List;

/**
 * Created by songxianying on 17/8/13.
 */
public interface ReviewPlanService {
    long addReviewPlan(ReviewPlan reviewPlan);
    List<ReviewPlan> findReviewPlanByid(long id);
    List<ReviewPlan> findReviewPlanByToken (String token  );
    long updateReviewPlan(long id,long reviewer );
    List<ReviewPlan> findReviewPlanByreviewer(long reviewer);
    ReviewPlan findReviewPlanById(long id);
}
