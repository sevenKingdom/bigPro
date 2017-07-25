package com.carry.model.mysql.service.serviceimpl;

import com.carry.model.mysql.dao.NoticeMapper;
import com.carry.model.mysql.po.Notice;
import com.carry.model.mysql.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songxianying on 17/7/24.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Transactional
    @Override
    public String getNoticeData (int level,String department) {
        Notice data =  noticeMapper.findByLevelAndDepartment(level, department);
        if(data!=null && data.getData()!=null)
            return data.getData();
        else
            return null;
    }
}
