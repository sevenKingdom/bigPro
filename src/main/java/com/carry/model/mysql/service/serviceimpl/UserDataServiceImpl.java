package com.carry.model.mysql.service.serviceimpl;

import com.carry.common.TokenProccessor;
import com.carry.model.mysql.dao.ConfigdataMapper;
import com.carry.model.mysql.dao.UserDataMapper;
import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import com.carry.model.mysql.service.UserDataService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    @Override
    public long updateUserScore (long id, int score) {
        return userDataMapper.updateUserScore(id,score);
    }

    @Transactional
    @Override
    public List<UserCreat>  getAllUser () {
        List<UserData>  userdatas = userDataMapper.findAll();
        List<UserCreat> userCreatseat = Lists.newArrayList();
        for ( UserData userdata : userdatas) {
            UserInfo userInfo = userDataMapper.findUserInfoByid(userdata.getInfoid());
            UserCreat userCreat = new UserCreat();
            userCreat.setUserInfo(userInfo);
            userCreat.setUserData(userdata);
            userCreatseat.add(userCreat);
        }
        return userCreatseat;
    }

    @Transactional
    @Override
    public int deleteUser (Long id) {
        return userDataMapper.delUserInfo(id)+userDataMapper.delUserData(id);
    }


    @Transactional
    @Override
    public int updateUser (Long id,String name,String phone,String password,String mail) {
        int t = 0;
        t += userDataMapper.updateData(id,phone,password);
        t += userDataMapper.updateInfo(id,name,phone,mail);
        return t;
    }


    @Transactional
    @Override
    public int updateUserPassword (Long id,String password) {
        return userDataMapper.updatePassword(id,password);
    }

}
