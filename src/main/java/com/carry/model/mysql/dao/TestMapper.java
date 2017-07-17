package com.carry.model.mysql.dao;


import com.carry.model.mysql.po.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

/**
 * Created by songxianying on 17/7/12.
 */
@Mapper
public interface TestMapper {
    @Select("select * from test where id = #{id}")
    Test findTest(@Param("id") int id);
}
