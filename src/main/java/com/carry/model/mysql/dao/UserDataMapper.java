package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by songxianying on 17/7/18.
 */
@Mapper
@Repository
public interface UserDataMapper {
    @Select("select * from user_data where name = #{name} and password = #{password} ")
    UserData findByNameAndPassword(@Param("name") String name, @Param("password") String password );

    @Select("select * from user_data where id = #{id} ")
    UserData findByid(@Param("id") long id  );

    @Select("select token from user_data where id = #{id} ")
    String findTokenByid(@Param("id") long id  );

    @Select("select department from user_data where token = #{token} ")
    String findDepartmentByToken (@Param("token") String token );

    @Select("select * from user_data where token = #{token} ")
    UserData findByToken (@Param("token") String token );

    @Update("update user_data set token = #{token} where id = #{id}")
    long updateToken(@Param("id") long id,@Param("token") String token);

    @Insert("insert into user_data(name, password,department,dutyid,infoid,state,role,post,token) " +
            "values(#{name}, #{password},#{department},#{dutyid},#{infoid},#{state},#{role},#{post},#{token})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long addUserData(UserData userdata);

    @Insert("insert into user_info(name, sex,birthdate,phone,mail) " +
            "values(#{name}, #{sex},#{birthdate},#{phone},#{mail})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long addUserinfo(UserInfo userInfo);

    @Select("select * from user_info where id = #{id} ")
    UserInfo findUserInfoByid(@Param("id") long id  );


    @Update("update user_data set score = score + #{score} where id = #{id}")
    long updateUserScore(@Param("id") long  id,@Param("score") int  score);

    @Select("select * from user_data ")
    List<UserData> findAll ();

    @Delete("delete from user_data where id = #{id}")
    int delUserData(long id);

    @Delete("delete from user_info where id = (select infoid from user_data where id = #{id})")
    int delUserInfo(long id);

    @Update("update user_data set name = #{name}  where id = #{id}")
    int updateData(@Param("id") long id,@Param("name") String name,@Param("password") String password);

    @Update("update user_info set name = #{name} ,phone = #{phone},mail = #{mail} " +
            "where id = (select infoid from user_data where id = #{id})")
    int updateInfo(@Param("id") long id,@Param("name") String name,@Param("phone") String phone,@Param("mail") String mail);

    @Update("update user_data set password = #{password} where id = #{id}")
    int updatePassword(@Param("id") long id,@Param("password") String password);

    @Select("select * from user_data where department like \"%\"#{department}\"%\" and department != #{department} ")
    List<UserData> findBydepartment (@Param("department") String department);

    //@Select("select id, name as name, money as money from account where id = #{id}")
    //Account findAccount(@Param("id") int id);

    //@Select("select id, name as name, money as money from account")
    //List<Account> findAccountList();
}
