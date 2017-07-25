package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

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

    @Update("update user_data set token = #{token} where id = #{id}")
    long updateToken(@Param("id") long id,@Param("token") String token);

    @Insert("insert into user_data(name, password,department,dutyid,infoid,state,role,post) " +
            "values(#{name}, #{password},#{department},#{dutyid},#{infoid},#{state},#{role},#{post})")
    long addUserData(UserData userdata);

    @Insert("insert into user_info(name, sex,birthdate,phone,mail) " +
            "values(#{name}, #{sex},#{birthdate},#{phone},#{mail})")
    long addUserinfo(UserInfo userInfo);

    @Update("update user_info set phone = #{phone} where mail = #{mail}")
    long updateInfo(@Param("phone") String phone,@Param("mail") String mail);



    //@Update("update account set name = #{name}, money = #{money} where id = #{id}")
    //int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);


    //@Delete("delete from account where id = #{id}")
    //int delete(int id);

    //@Select("select id, name as name, money as money from account where id = #{id}")
    //Account findAccount(@Param("id") int id);

    //@Select("select id, name as name, money as money from account")
    //List<Account> findAccountList();
}
