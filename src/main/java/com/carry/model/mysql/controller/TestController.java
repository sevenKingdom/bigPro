package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Test;
import com.carry.model.mysql.service.TestService;
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
    TestService testServic;
    //@ResponseBody
    @RequestMapping(value = "/test")
    public Test getTest() {
        return testServic.findAccountList();
    }
}
