package com.carry.model.mysql.service;

import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by songxianying on 17/7/18.
 */
public interface UserDataService {

    long updatetoken (long id);

    Map<String,Object> creatUser (UserData userData, UserInfo userInfo) ;

    UserCreat login(String name, String password );

    long logoff(long id);

    UserData verification (String token);

    String vDepentment (String token);

    long updateUserScore (long id, int score);

    List<UserCreat> getAllUser ();

    int deleteUser (Long id);

    int updateUser (Long id,String name,String phone,String password,String mail);

    int updateUserPassword (Long id,String password);
}
