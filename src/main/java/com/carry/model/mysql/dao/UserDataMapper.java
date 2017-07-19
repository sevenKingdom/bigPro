package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by songxianying on 17/7/18.
 */
@Mapper
@Repository
public interface UserDataMapper {
    @Select("select * from user_data where name = #{name} and password = #{password} ")
    UserData findByNameAndPassword(@Param("name") String name, @Param("password") String password );
}
