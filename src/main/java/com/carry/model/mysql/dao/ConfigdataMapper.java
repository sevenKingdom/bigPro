package com.carry.model.mysql.dao;


import com.carry.model.mysql.po.Configdata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by songxianying on 17/7/12.
 */
@Mapper
@Repository
public interface ConfigdataMapper {
    @Select("select * from configdata where id = #{id}")
    Configdata findTest(@Param("id") int id);
}
