package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import com.carry.model.mysql.service.ConstructionPlanService;
import com.carry.model.mysql.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @RequestMapping(value = "/getAllUser" ,method = RequestMethod.POST)
    public List<UserCreat> getAllUser(){
        return userDataService.getAllUser();
    }

    @RequestMapping(value = "/deleteUser" ,method = RequestMethod.GET)
    public int deleteUser (@RequestParam("id") Long id) {
        return userDataService.deleteUser(id);
    }

    @RequestMapping(value = "/updateUser" ,method = RequestMethod.GET)
    public int updateUser (@RequestParam("id") Long id,@RequestParam("name") String name,
                           @RequestParam("phone") String phone,@RequestParam("password") String password,
                           @RequestParam("mail") String mail) {
        return userDataService.updateUser(id, name, phone, password, mail);
    }

    @RequestMapping(value = "/updateUserPassword" ,method = RequestMethod.GET)
    public int updateUserPassword (@RequestParam("id") Long id,@RequestParam("password") String password){
        return userDataService.updateUserPassword(id, password);
    }

    @RequestMapping(value = "/findBydepartment" ,method = RequestMethod.GET)
    public List<UserCreat> findBydepartment (@RequestParam("department") String department) {
        return userDataService.findBydepartment(department);
    }
}
