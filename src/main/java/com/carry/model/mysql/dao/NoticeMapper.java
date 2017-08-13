package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.Notice;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by songxianying on 17/7/24.
 */
@Mapper
@Repository
public interface NoticeMapper {
    @Select("select * from notice where level = #{level} and department = #{department} ")
    Notice findByLevelAndDepartment(@Param("level") int level, @Param("department") String department );

    @Update("update notice set data = #{data} where id = #{id}")
    long updateNotice(@Param("id") long id,@Param("data") String data );
}
