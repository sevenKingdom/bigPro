package com.carry.common.creatlogfile;

import com.carry.model.mysql.po.ConstructionPlan;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by songxianying on 17/8/30.
 */
public class MakeHtml {

    public String test(Map<String, Object> htmldata , String path) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);

        StringBuffer sb = new StringBuffer();
        String start =  HtmlModel.start;
        HtmlData data = (HtmlData)htmldata.get("plan");
        String head = makeHtmlhead(htmldata.get("department").toString(),data.whether,dateString);
        String planname1 =  HtmlModel.planname1;
        String plan = makeHtmlplan(data.plans);
        String itemname1 =  HtmlModel.itemname1;
        String item = makeHtmlItem(data.record);
        sb.append(start);
        sb.append(head);
        sb.append(planname1);
        sb.append(plan);
        sb.append(itemname1);
        sb.append(item);
        if (htmldata.get("replan") != null ) {
            String fenge =  HtmlModel.fenge;
            HtmlData redata = (HtmlData)htmldata.get("replan");
            String planname2 =  HtmlModel.planname2;
            String replan = makeHtmlplan(redata.plans);
            String itemname2 =  HtmlModel.itemname2;
            String reitem = makeHtmlItem(redata.record);
            sb.append(fenge);
            sb.append(planname2);
            sb.append(replan);
            sb.append(itemname2);
            sb.append(reitem);

        }
        String end =  HtmlModel.end;
        sb.append(end);
        try {
            FileWriter fw1 = new FileWriter(path+dateString+".html");
            fw1.write(sb.toString());
            fw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateString+".html";
    }

    public String makeHtmlhead(String department, String whether , String dateString) {

        return MessageFormat.format(HtmlModel.head, department , whether , dateString);
    }

    public String makeHtmlplan(List<ConstructionPlan> plans) {
        if (plans == null || plans.size() == 0 ) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for ( ConstructionPlan plan : plans) {
            String isno = "是";
            String isno2 = "是";
            if (plan.getIsNeedDemonstrate() == 0) {
                isno = "否";
            }
            if (plan.getIsNeedApprove() == 0) {
                isno2 = "否";
            }
            sb.append(MessageFormat.format(HtmlModel.plantd, plan.getBridgeName() , plan.getPierNum(),
                    plan.getStructure(),plan.getProcess(),isno,isno2));
        }
        return MessageFormat.format(HtmlModel.plan, sb.toString());
    }
    public String makeHtmlItem(HtmlData.Record record) {
        if (record == null) {
            return "";
        }
        String planinfo = record.planinfo;
        String inspectorname = record.inspectorname;
        String classname = record.classname;
        String okitem = itemtb(record.okitem);
        String noitem = itemtb(record.noitem);
        return MessageFormat.format(HtmlModel.item,planinfo,inspectorname,classname,okitem,noitem);
    }
    public String itemtb (List<Map<String,String>> item) {
        if (item != null && item.size() != 0) {
            StringBuffer sb = new StringBuffer();
            for ( Map<String,String> po : item) {
                sb.append(MessageFormat.format(HtmlModel.itemtd, po.get("item") , po.get("level") ,po.get("img")));
            }
            return sb.toString();
        }
        return "";
    }
}
