package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import com.carry.model.mysql.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by songxianying on 17/7/23.
 */
@RestController
@RequestMapping("/mysql")
public class UserController {
    @Autowired
    UserDataService userDataService;
    @RequestMapping(value = "/createuser" ,method = RequestMethod.POST)
    public Map<String,Object> creatUser(@RequestBody UserCreat userCreat) {
        return userDataService.creatUser(userCreat.getUserData(),userCreat.getUserInfo());
    }
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public UserCreat login(@RequestParam("name") String name, @RequestParam("password") String password ){
        return userDataService.login(name, password);
    }
    @RequestMapping(value = "/logoff" ,method = RequestMethod.GET)
    public long logoff(@RequestParam("id") long id) {
        return userDataService.logoff(id);
    }
}
