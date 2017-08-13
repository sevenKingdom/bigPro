package com.carry.model.mysql.service;

/**
 * Created by songxianying on 17/7/24.
 */
public interface NoticeService {
    String getNoticeData (int level,String department);
    long updateNotice(long id, String data );
}
