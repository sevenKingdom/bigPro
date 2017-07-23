package com.carry.model.mysql.service;

import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;

import java.util.Map;

/**
 * Created by songxianying on 17/7/18.
 */
public interface UserDataService {
    public long updatetoken (long id);
    public Map<Long,String> creatUser (UserData userData, UserInfo userInfo) ;
    UserData login(String name, String password );
    public long logoff(long id);
}
