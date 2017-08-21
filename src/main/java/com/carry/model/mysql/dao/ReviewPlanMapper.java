package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.ReviewPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("select * from review_plan where id = #{id} ")
    List<ReviewPlan> findReviewPlanByid(@Param("id") long id  );

    @Select("select * from review_plan where reviewer is null and power like \"%\"#{token}\"%\" ")
    List<ReviewPlan> findReviewPlanByToken (@Param("token") String token  );

    @Update("update review_plan set reviewer = #{reviewer} where id = #{id}")
    long updateReviewPlan(@Param("id") long id,@Param("reviewer") long reviewer );

    @Select("select * from review_plan where reviewer = #{reviewer} ")
    List<ReviewPlan> findReviewPlanByreviewer(@Param("reviewer") long reviewer  );

    @Select("select * from review_plan where id = #{id} ")
    ReviewPlan findReviewPlanById(@Param("id") long id  );
}
