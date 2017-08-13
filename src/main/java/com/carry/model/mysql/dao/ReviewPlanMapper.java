package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.ReviewPlan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * Created by songxianying on 17/8/13.
 */
@Mapper
@Repository
public interface ReviewPlanMapper {
    @Insert("insert into  review_plan (planid, lowquality,reviewer,power,firstman,createdAt) " +
            "values( #{planid},#{lowquality},#{reviewer},#{power},#{firstman},#{createdAt})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long addReviewPlan(ReviewPlan reviewPlan);
}
