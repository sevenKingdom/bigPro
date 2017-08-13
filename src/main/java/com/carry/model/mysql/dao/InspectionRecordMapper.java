package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.UserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * Created by songxianying on 17/8/13.
 */
@Mapper
@Repository
public interface InspectionRecordMapper {
    @Insert("insert into  inspection_record (inspectorid, planid,quality,lowquality,style,createdAt) " +
            "values(#{inspectorid}, #{planid},#{quality},#{lowquality},#{style},#{createdAt})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long addInspectionRecord(InspectionRecord inspectionRecord);
}
