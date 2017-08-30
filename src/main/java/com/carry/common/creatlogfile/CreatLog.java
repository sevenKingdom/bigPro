package com.carry.common.creatlogfile;

import com.carry.common.util.DateUtil;
import com.carry.model.mysql.dao.*;
import com.carry.model.mysql.po.ConstructionPlan;
import com.carry.model.mysql.po.InspectionRecord;
import com.carry.model.mysql.po.UserData;
import com.carry.model.mysql.po.UserInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by songxianying on 17/8/29.
 */
@Component
public class CreatLog {
    private static final String FILE_PATH = "/Users/songxianying/imge/";
    private static final String SHOW_URL = "http://192.168.10.163:8763/file/";

    @Autowired
    private ConstructionPlanMapper constructionPlanMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private InspectionRecordMapper inspectionRecordMapper;

    @Autowired
    private ConfigdataMapper configdataMapper;

    @Autowired
    private LogInfoMapper logInfoMapper;

    public List<ConstructionPlan> getOneDayList() {
        return constructionPlanMapper.getListOneDay(DateUtil.getStartTime().getTimeInMillis(), DateUtil.getEndTime().getTimeInMillis());
    }
    public List<ConstructionPlan> getOneDayreList() {
        return constructionPlanMapper.getreListOneDay(DateUtil.getStartTime().getTimeInMillis(), DateUtil.getEndTime().getTimeInMillis());
    }

    @Scheduled(cron="0 0/5 * * * ?")
    public void test() {
        try {
            List<Map<String, Object>> htmldata = makeHtmlData();
            MakeHtml makeHtml = new MakeHtml();
            for ( Map<String, Object> data  : htmldata) {
                String filename  = makeHtml.test(data,FILE_PATH);
                logInfoMapper.addLoginfo(data.get("depart").toString(),SHOW_URL+filename);
            }
        }catch (Exception e) {

        }
    }

    public List<Map<String, Object>> makeHtmlData() {
        List<HtmlData> data1 = makeModel(getPlan(getOneDayList()),0);
        List<HtmlData> data2 =  makeModel(getPlan(getOneDayreList()),1);
        Map<String, HtmlData> redata = Maps.newHashMap();
        for ( HtmlData data : data2) {
            redata.put(data.department,data);
        }
        List<Map<String, Object>> html = Lists.newArrayList();
        for (HtmlData data : data1) {
            Map<String, Object> returndata = Maps.newHashMap();
            returndata.put("department", findBydepartment(data.department));
            returndata.put("depart", data.department);
            returndata.put("plan", data);
            returndata.put("replan", redata.get(data.department));
            html.add(returndata);
        }
        return html;
    }

    public Map<String,List<ConstructionPlan>> getPlan(List<ConstructionPlan> planlist) {
        List<ConstructionPlan> plans = planlist;
        Map<String,List<ConstructionPlan>> mapplans = Maps.newHashMap();
        for (ConstructionPlan plan : plans) {
            UserData technician = userDataMapper.findByid(plan.getTechnicianId());
            String department = technician.getDepartment();
            if (mapplans.get(department) != null) {
                mapplans.get(department).add(plan);
            } else {
                List<ConstructionPlan> list = Lists.newArrayList();
                list.add(plan);
                mapplans.put(department,list);
            }

        }
        return mapplans;
    }
    public List<HtmlData> makeModel (Map<String,List<ConstructionPlan>> paln,int style) {
        Map<String,List<ConstructionPlan>> map =  paln;
        List<HtmlData> datas = Lists.newArrayList();
        for (String key : map.keySet()) {
            HtmlData data = new HtmlData();
            data.department = key;
            data.plans = map.get(key);
            data.whether = data.plans.get(0).getWhether();
            datas.add(data);
            makenokData(data.plans, data,style);
        }
        return datas;
    }
    public void makenokData(List<ConstructionPlan> datas, HtmlData data,int style) {
        for (ConstructionPlan plan : datas) {
            InspectionRecord inspectionRecord = inspectionRecordMapper.findByplanid(plan.getId(),style);
            if (inspectionRecord != null) {
                UserData classdata = userDataMapper.findByid(plan.getClassId());
                UserInfo classinfo = userDataMapper.findUserInfoByid(classdata.getInfoid());
                data.whether = plan.getWhether();
                data.record.classname = classinfo.getName();
                UserData inspectordata = userDataMapper.findByid(plan.getInspectorId());
                UserInfo inspectorinfo = userDataMapper.findUserInfoByid(inspectordata.getInfoid());
                data.record.planinfo = plan.getBridgeName() +" "+  plan.getPierNum() +
                        " "+  plan.getStructure()+" "+ plan.getProcess();
                data.record.inspectorname = inspectorinfo.getName();
                data.record.okitem = makeItem (inspectionRecord.getQuality());
                data.record.noitem = makeItem (inspectionRecord.getLowquality());
            }

        }
    }
    public List<Map<String,String>> makeItem (String quality) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type type = new TypeToken<Map<Object, Object>>() {}.getType();
        Map<Object, Object> map = gson.fromJson(quality, type);
        if (map == null) {
            return null;
        }
        Map<Object, Object> mapp = ((Map<Object, Object>)map.get("item"));
        Map<Object, Object> imapp = ((Map<Object, Object>)map.get("img"));
        List<Map<String,String>> okitem = Lists.newArrayList();
        for (Object key : mapp.keySet()) {
            Map<String,String> item = Maps.newHashMap();
            item.put("item",key.toString());
            item.put("level",mapp.get(key).toString());
            String img = "";
            try {
                img = ((List<String>)imapp.get(key)).get(0) ;
            } catch (Exception e) {

            }

            item.put("img",img);
            okitem.add(item);
        }
        return okitem;
    }

    public String findBydepartment (String department) {
        StringBuffer sb = new StringBuffer();
        String[] departments = department.split("\\.");
        String data = configdataMapper.findTest(1).getData();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Type type = new TypeToken<Map<Object, Object>>() {}.getType();
        Map<Object, Object> map = gson.fromJson(data, type);
        Map<Object, Object> mapll = map;
        for (String key : departments) {
            mapll = (Map<Object, Object>)mapll.get(key);
            sb.append(mapll.get("name")+" ");
            mapll = (Map<Object, Object>)mapll.get("lowerlevel");

        }

        return sb.toString();
    }

}
