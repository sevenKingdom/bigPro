package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.ClassReviewRecord;
import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.service.InspectionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songxianying on 17/8/13.
 */
@RestController
@RequestMapping("/mysql")
public class InspectionRecordController {
    @Autowired
    InspectionRecordService inspectionRecordService;

    @RequestMapping(value = "/addInspectionRecord" ,method = RequestMethod.POST)
    public Long addInspectionRecord(@RequestBody InspectionRecord inspectionRecord) {
        return inspectionRecordService.addInspectionRecord(inspectionRecord);
    }
}
