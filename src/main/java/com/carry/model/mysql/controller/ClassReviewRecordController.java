package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.ClassReviewRecord;
import com.carry.model.mysql.po.UserCreat;
import com.carry.model.mysql.service.ClassReviewRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by songxianying on 17/8/13.
 */
@RestController
@RequestMapping("/mysql")
public class ClassReviewRecordController {
    @Autowired
    ClassReviewRecordService classReviewRecordService;

    @RequestMapping(value = "/addClassReviewRecord" ,method = RequestMethod.POST)
    public Long addClassReviewRecord(@RequestBody ClassReviewRecord classReviewRecord) {
        return classReviewRecordService.addClassReviewRecord(classReviewRecord);
    }
}
