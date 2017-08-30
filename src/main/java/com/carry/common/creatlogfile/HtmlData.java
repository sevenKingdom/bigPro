package com.carry.common.creatlogfile;

import com.carry.model.mysql.po.ConstructionPlan;

import java.util.List;
import java.util.Map;

/**
 * Created by songxianying on 17/8/29.
 */
public class HtmlData {
    public String department;
    public String whether;
    public List<ConstructionPlan> plans;
    public Record record = new Record();
    class Record {
        String planinfo;
        String inspectorname;
        String classname;
        String classer;
        List<Map<String,String>> okitem;
        List<Map<String,String>> noitem;
    }
}
