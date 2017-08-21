package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.ReviewPlanMapper;
import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.ReviewPlan;
import com.carry.model.mysql.service.ReviewPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    @Override
    public List<ReviewPlan> findReviewPlanByid(long id) {
        return reviewPlanMapper.findReviewPlanByid(id);
    }

    @Transactional
    @Override
    public List<ReviewPlan> findReviewPlanByToken (String token){
        return reviewPlanMapper.findReviewPlanByToken(token);
    }

    @Transactional
    @Override
    public long updateReviewPlan(long id,long reviewer ) {
        return reviewPlanMapper.updateReviewPlan(id, reviewer);
    }

    @Transactional
    @Override
    public  List<ReviewPlan> findReviewPlanByreviewer(long reviewer) {
        return reviewPlanMapper.findReviewPlanByreviewer(reviewer);
    }

    @Override
    public ReviewPlan findReviewPlanById(long id) {
        return reviewPlanMapper.findReviewPlanById(id);
    }
}
