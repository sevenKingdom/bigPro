package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.service.ConfigdataService;
import com.carry.model.mysql.service.UserDataService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songxianying on 17/7/15.
 */
@RestController
@RequestMapping("/mysql")
public class TestController {
    @Autowired
    ConfigdataService testServic;
    @Autowired
    UserDataService userDataService;
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Configdata getTest(@RequestBody Configdata configdata ){
        //return testServic.findAccountList();
        return configdata;
    }
    @RequestMapping(value = "/test3")
    public long getTest3() {
        return userDataService.updatetoken(1);
    }

}
