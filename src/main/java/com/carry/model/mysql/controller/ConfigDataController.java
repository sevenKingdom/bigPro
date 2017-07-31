package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.service.ConfigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songxianying on 17/7/30.
 */
@RestController
@RequestMapping("/mysql")
public class ConfigDataController {
    @Autowired
    ConfigdataService testServic;
    @RequestMapping(value = "/getOrganize",method = RequestMethod.POST)
    public Configdata getTest(){
        return testServic.findOrganization();
    }
}
