package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.service.ConfigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songxianying on 17/7/15.
 */
@RestController
@RequestMapping("/mysql")
public class TestController {
    @Autowired
    ConfigdataService testServic;
    //@ResponseBody
    @RequestMapping(value = "/test")
    public Configdata getTest() {
        return testServic.findAccountList();
    }
}
