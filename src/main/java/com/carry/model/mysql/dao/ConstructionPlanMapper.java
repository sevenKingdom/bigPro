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


    @Select(" select department from user_data where id in " +
            "(select technician_id from construction_plan_t where id = #{id} )")
    String getPlanAuthor (@Param("id") Long id) ;

    @Update("update construction_plan_t set inspector_id = #{inspectorid} where id = #{id}")
    long updatePlanInspector (@Param("inspectorid") Long inspectorid,@Param("id") Long id) ;

    @Select(" select id from user_data where department = #{department} and role = 1")
    List<Long> getTechnicianid(@Param("department") String department);

    @Select("select * from construction_plan_t where inspector_id = #{inspectorid} " +
            "and created_at >= #{startTime} and created_at <= #{endTime}")
    List<ConstructionPlan> getListByInspectorid(@Param("inspectorid") Long inspectorid,@Param("startTime") Long startTime, @Param("endTime") Long endTime);
}
