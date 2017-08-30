package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.ConstructionPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by jinming on 2017/7/17.
 */
@Mapper
@Repository
public interface ConstructionPlanMapper {
    @Select("select * from construction_plan_t where createdAt >= #{startTime} and createdAt <= #{endTime} and technicianId in (${technicianIds})")
    List<ConstructionPlan> getListByTime(@Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("technicianIds") String technicianIds);

    @Insert("insert into construction_plan_t(bridgeName,pierNum,structure,process,category,isNeedDemonstrate," +
            "constructionPlanFile,isNeedApprove,technicianId,whether,createdAt,classId,point) values (#{bridgeName},#{pierNum},#{structure},#{process}" +
            ",#{category},#{isNeedDemonstrate},#{constructionPlanFile},#{isNeedApprove},#{technicianId},#{whether},#{createdAt},#{classId},#{point})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long saveConstructionPlan(ConstructionPlan constructionPlan);


    @Select(" select department from user_data where id in " +
            "(select technicianId from construction_plan_t where id = #{id} )")
    String getPlanAuthor (@Param("id") Long id) ;

    @Update("update construction_plan_t set inspectorId = #{inspectorid} where id = #{id}")
    long updatePlanInspector (@Param("inspectorid") Long inspectorid,@Param("id") Long id) ;

    @Select(" select id from user_data where department = #{department} and role = 1")
    List<Long> getTechnicianid(@Param("department") String department);

    @Select("select * from construction_plan_t where createdAt >= #{startTime} and createdAt <= #{endTime} and classId = #{classId}")
    List<ConstructionPlan> getOneDayProcessListByClassId(@Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("classId") Long classId);

    @Select("select * from construction_plan_t where inspectorId = #{inspectorid} " +
            "and createdAt >= #{startTime} and createdAt <= #{endTime}")
    List<ConstructionPlan> getListByInspectorid(@Param("inspectorid") Long inspectorid,@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    @Select(" select * from construction_plan_t where id = #{id}")
    ConstructionPlan getByid(@Param("id") Long id);

    @Delete("delete from construction_plan_t where id = #{id}")
    int delPlanData(@Param("id") long id);

    @Select("select * from construction_plan_t where createdAt >= #{startTime} and createdAt <= #{endTime}")
    List<ConstructionPlan> getListOneDay(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    @Select("select * from construction_plan_t where id in " +
            "(select planid from review_plan where createdAt >= #{startTime} and createdAt <= #{endTime})")
    List<ConstructionPlan> getreListOneDay(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
}
