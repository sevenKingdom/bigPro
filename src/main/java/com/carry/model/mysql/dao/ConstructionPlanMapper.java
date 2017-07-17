package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.ConstructionPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jinming on 2017/7/17.
 */
@Mapper
@Repository
public interface ConstructionPlanMapper {
    @Select("select * from construction_plan_t where created_at >= #{startTime} and created_at <= #{endTime}")
    List<ConstructionPlan> getListByTime(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    @Insert("insert into construction_plan_t(bridge_name,pier_num,structure,process,category,is_need_demonstrate," +
            "construction_plan_file,is_need_approve,technician_id,created_at) values (#{bridgeName},#{pierNum},#{structure},#{process}" +
            ",#{category},#{isNeedDemonstrate},#{constructionPlanFile},#{isNeedApprove},#{technicianId},#{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long saveConstructionPlan(ConstructionPlan constructionPlan);
}
