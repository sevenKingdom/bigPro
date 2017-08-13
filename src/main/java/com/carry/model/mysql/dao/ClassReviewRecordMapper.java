package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.ClassReviewRecord;
import com.carry.model.mysql.po.InspectionRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * Created by songxianying on 17/8/13.
 */
@Mapper
@Repository
public interface ClassReviewRecordMapper {
    @Insert("insert into  class_review_record (classid, planid,lowquality,style,createdAt) " +
            "values(#{classid}, #{planid},#{lowquality},#{style},#{createdAt})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long addClassReviewRecord(ClassReviewRecord classReviewRecord);
}
