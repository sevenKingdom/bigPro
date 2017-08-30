package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.Education;
import com.carry.model.mysql.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Seven on 17/8/13.
 */
@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @RequestMapping(value = "save")
    public long save(@RequestBody Education education) {
        long id = educationService.save(education);
        return id;
    }
}
