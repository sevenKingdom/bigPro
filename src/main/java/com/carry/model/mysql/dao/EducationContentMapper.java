package com.carry.model.mysql.dao;

import com.carry.model.mysql.po.EducationContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
@Mapper
@Repository
public interface EducationContentMapper {

    @Select("select * from education_content_t where id in (${dataIds})")
    List<EducationContent> getListByIds(@RequestParam("dataIds") String dataIds);
}
