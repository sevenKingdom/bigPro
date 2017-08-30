package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.Loginfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songxianying on 17/8/29.
 */
@Mapper
@Repository
public interface LogInfoMapper {
    @Insert("insert into  log_info (department, filepath,time) " +
            "values(#{department}, #{filepath},now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long addLoginfo (@Param("department") String department ,@Param("filepath") String filepath);

    @Select("select * from log_info where department like \"%\"#{department}\"%\"" +
            "  order by department desc ")
    List<Loginfo> getListOneDay(@Param("department") String department);
}
