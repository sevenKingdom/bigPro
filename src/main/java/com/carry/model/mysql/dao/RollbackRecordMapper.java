package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.RollbackRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songxianying on 17/8/27.
 */
@Mapper
@Repository
public interface RollbackRecordMapper {
    @Insert("insert into  rollback_record (inspectorId, planid,about,time,departmen) " +
            "values( #{inspectorId},#{planid},#{about},#{time},#{departmen})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int addRollbackRecord(RollbackRecord rollbackRecord);

    @Select("select * from rollback_record where department = #{department} order by time desc")
    List<RollbackRecord> findByDepartment(@Param("department") String department );
}
