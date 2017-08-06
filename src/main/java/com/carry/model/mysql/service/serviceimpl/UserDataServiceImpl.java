package com.carry.model.mysql.service.serviceimpl;

import com.carry.common.TokenProccessor;
import com.carry.model.mysql.dao.ConfigdataMapper;
import com.carry.model.mysql.dao.UserDataMapper;
import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import com.carry.model.mysql.service.UserDataService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by songxianying on 17/7/18.
 */
@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    private UserDataMapper userDataMapper;
    @Transactional
    @Override
    public long updatetoken (long id){
        String token = TokenProccessor.getInstance().makeToken();
        return userDataMapper.updateToken(id,token);
    }
    @Transactional
    @Override
    public Map<String,Object> creatUser (UserData userData, UserInfo userInfo) {
        userDataMapper.addUserinfo(userInfo);
        userData.setInfoid(userInfo.getId());
        String token = TokenProccessor.getInstance().makeToken();
        userData.setToken(token);

        Map<String,Object> data = Maps.newHashMap();
        userDataMapper.addUserData(userData);
        data.put("userid",userData.getId());
        data.put("username",userInfo.getName());
        data.put("userphone",userInfo.getPhone());
        data.put("usermail",userInfo.getMail());
        return data;
    }
    @Transactional
    @Override
    public UserCreat login(String name, String password ){
        UserData userData = userDataMapper.findByNameAndPassword(name, password);
        if(userData ==null)
            return null;
        UserInfo userInfo = userDataMapper.findUserInfoByid(userData.getInfoid());
        String token = TokenProccessor.getInstance().makeToken();
        userDataMapper.updateToken(userData.getId(),token);
        userData.setToken(token);
        UserCreat data =  new UserCreat();
        data.setUserData(userData);
        data.setUserInfo(userInfo);
        return data;
    }
    @Transactional
    @Override
    public long logoff(long id) {
        String token = TokenProccessor.getInstance().makeToken();
        return userDataMapper.updateToken(id,token);
    }

    @Transactional
    @Override
    public UserData verification (String token) {
        UserData userData = userDataMapper.findByToken(token);
        return userData;
    }

    @Transactional
    @Override
    public String vDepentment (String token) {
        String userData = userDataMapper.findDepartmentByToken(token);
        return userData;
    }
}
