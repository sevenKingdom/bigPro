package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import com.carry.model.mysql.service.ConstructionPlanService;
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

    @Autowired
    private ConstructionPlanService constructionPlanService;

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

    @RequestMapping(value = "/verification" ,method = RequestMethod.GET)
    public UserData verification(@RequestParam("token") String token) {
        return userDataService.verification(token);
    }

    @RequestMapping(value = "/shortVerification" ,method = RequestMethod.GET)
    public String shortVerification(@RequestParam("token") String token) {
        return userDataService.vDepentment(token);
    }

    @RequestMapping(value = "/getPlanAuthor" ,method = RequestMethod.GET)
    public String getPlanAuthor(@RequestParam("id") Long id) {
        return constructionPlanService.getPlanAuthor(id);
    }

    @RequestMapping(value = "/updateUserScore",method = RequestMethod.GET)
    public Long updateUserScore(@RequestParam("id") Long id, @RequestParam("score") Integer score) {
        return userDataService.updateUserScore(id,score);
    }
}
