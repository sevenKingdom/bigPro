package com.carry.model.mysql.controller;

import com.carry.model.mysql.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by songxianying on 17/7/25.
 */
@RestController
@RequestMapping("/mysql")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @RequestMapping(value = "/getnoticedata" ,method = RequestMethod.GET)
    public String creatUser(@RequestParam("level") int level,
                                      @RequestParam("department") String department) {
        return noticeService.getNoticeData(level, department);
    }
    @RequestMapping(value = "/updateNotice" ,method = RequestMethod.POST)
    public Long updateNotice(@RequestParam("id") long id,
                            @RequestParam("data") String data) {
        return noticeService.updateNotice(id, data);
    }
}
