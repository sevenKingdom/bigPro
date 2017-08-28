package com.carry.model.mysql.controller;

import com.carry.model.mysql.po.ReviewPlan;
import com.carry.model.mysql.po.RollbackRecord;
import com.carry.model.mysql.service.RollbackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by songxianying on 17/8/27.
 */
@RestController
@RequestMapping("/mysql")
public class RollbackRecordController {
    @Autowired
    RollbackRecordService rollbackRecordService;

    @RequestMapping(value = "/addRollbackRecord" ,method = RequestMethod.POST)
    public int addRollbackRecord(@RequestBody RollbackRecord rollbackRecord) {
        return rollbackRecordService.addRollbackRecord(rollbackRecord);
    }

    @RequestMapping(value = "/findByDepartment" ,method = RequestMethod.POST)
    public List<RollbackRecord> findByDepartment (@RequestParam("department") String department) {
        return rollbackRecordService.findByDepartment(department);
    }
}
