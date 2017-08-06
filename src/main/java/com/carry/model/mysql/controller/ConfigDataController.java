package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Configdata;
import com.carry.model.mysql.service.ConfigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getConfig",method = RequestMethod.POST)
    public Configdata findProcesses(@RequestParam("id") Integer id) {
        return testServic.findProcesses(id);
    }

}
