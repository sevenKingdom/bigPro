package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.ReviewPlanMapper;
import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.ReviewPlan;
import com.carry.model.mysql.service.ReviewPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songxianying on 17/8/13.
 */
@Service
public class ReviewPlanServiceImpl implements ReviewPlanService {
    @Autowired
    private ReviewPlanMapper reviewPlanMapper;

    @Transactional
    @Override
    public long addReviewPlan(ReviewPlan reviewPlan) {
        return reviewPlanMapper.addReviewPlan(reviewPlan);
    }
}
