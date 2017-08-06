package com.carry.model.mysql.service;

import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;

import java.util.Map;

/**
 * Created by songxianying on 17/7/18.
 */
public interface UserDataService {

    public long updatetoken (long id);

    public Map<String,Object> creatUser (UserData userData, UserInfo userInfo) ;

    UserCreat login(String name, String password );

    public long logoff(long id);

    UserData verification (String token);

    String vDepentment (String token);
}
