package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.EducationContent;
import com.carry.model.mysql.service.EducationContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
@RestController
@RequestMapping("/education-content")
public class EducationContentController {

    @Autowired
    private EducationContentService educationContentService;

    @RequestMapping(value = "/getListByIds")
    public List<EducationContent> getListByIds(@RequestParam("dataIds") String dataIds){
        List<EducationContent> result = new ArrayList<>();
        try {
            result = educationContentService.getListByIds(dataIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
