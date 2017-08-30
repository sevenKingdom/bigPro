package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Loginfo;
import com.carry.model.mysql.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by songxianying on 17/8/29.
 */
@RestController
@RequestMapping("/mysql")
public class LogoInfoController {

    @Autowired
    LogInfoService logInfoService;

    @RequestMapping(value = "/getListOneDay" ,method = RequestMethod.POST)
    public List<Loginfo> getListOneDay(@RequestParam("department") String department) {
        return logInfoService.getListOneDay(department);
    }
}
