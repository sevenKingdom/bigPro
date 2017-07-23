package com.carry.model.mysql.service.serviceimpl;

import com.carry.common.TokenProccessor;
import com.carry.model.mysql.dao.ConfigdataMapper;
import com.carry.model.mysql.dao.UserDataMapper;
import com.carry.model.mysql.po.Configdata;
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
    public Map<Long,String> creatUser (UserData userData, UserInfo userInfo) {
        long infoid = userDataMapper.addUserinfo(userInfo);
        userData.setInfoid(infoid);
        String token = TokenProccessor.getInstance().makeToken();
        userData.setToken(token);

        Map<Long,String> data = Maps.newHashMap();
        data.put(userDataMapper.addUserData(userData),token);
        return data;
    }
    @Transactional
    @Override
    public UserData login(String name, String password ){
        UserData userData = userDataMapper.findByNameAndPassword(name, password);
        String token = TokenProccessor.getInstance().makeToken();
        userDataMapper.updateToken(userData.getId(),token);
        userData.setToken(token);
        return userData;
    }
    @Transactional
    @Override
    public long logoff(long id) {
        String token = TokenProccessor.getInstance().makeToken();
        return userDataMapper.updateToken(id,token);
    }
}
