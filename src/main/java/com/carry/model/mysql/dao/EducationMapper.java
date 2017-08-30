package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.Education;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * Created by Seven on 17/8/13.
 */
@Mapper
@Repository
public interface EducationMapper {

    @Insert("insert into education_t(imagePath,monitorId,position,createdAt) values (#{imagePath},#{monitorId},#{position},#{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long saveEducation(Education education);
}
