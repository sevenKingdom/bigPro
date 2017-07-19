package com.carry.model.mongo.po;

import java.util.List;

/**
 * 结构
 *
 * Created by jinming on 2017/7/19.
 */
public class Structures {
    private String structureName;   //结构名称

    private List<Process> process;  //工序

    private int structureNum;   //数量

    private String constructionPlanFile;    //施工文档

    private int isNeedDemonstrate;  //是否需要论证

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public String getStructureName() {
        return this.structureName;
    }

    public void setProcess(List<Process> process) {
        this.process = process;
    }

    public List<Process> getProcess() {
        return this.process;
    }

    public void setStructureNum(int structureNum) {
        this.structureNum = structureNum;
    }

    public int getStructureNum() {
        return this.structureNum;
    }

    public void setConstructionPlanFile(String constructionPlanFile) {
        this.constructionPlanFile = constructionPlanFile;
    }

    public String getConstructionPlanFile() {
        return this.constructionPlanFile;
    }

    public void setIsNeedDemonstrate(int isNeedDemonstrate) {
        this.isNeedDemonstrate = isNeedDemonstrate;
    }

    public int getIsNeedDemonstrate() {
        return this.isNeedDemonstrate;
    }
}
