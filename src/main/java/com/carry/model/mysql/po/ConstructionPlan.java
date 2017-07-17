package com.carry.model.mysql.po;

import java.io.Serializable;

public class ConstructionPlan implements Serializable {
    private static final long serialVersionUID = 5140224039425783832L;
    private Long id;
    private String bridgeName;
    private String pierNum;
    private String structure;
    private String procedure;
    private String category;
    private Short isNeedDemonstrate;
    private Long constuctionPlanFile;
    private Short isNeedApprove;
    private Short isAlreadyDemonstrate;
    private Long classId;
    private Long technicianId;
    private Long inspectorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBridgeName() {
        return bridgeName;
    }

    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    public String getPierNum() {
        return pierNum;
    }

    public void setPierNum(String pierNum) {
        this.pierNum = pierNum;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Short getIsNeedDemonstrate() {
        return isNeedDemonstrate;
    }

    public void setIsNeedDemonstrate(Short isNeedDemonstrate) {
        this.isNeedDemonstrate = isNeedDemonstrate;
    }

    public Long getConstuctionPlanFile() {
        return constuctionPlanFile;
    }

    public void setConstuctionPlanFile(Long constuctionPlanFile) {
        this.constuctionPlanFile = constuctionPlanFile;
    }

    public Short getIsNeedApprove() {
        return isNeedApprove;
    }

    public void setIsNeedApprove(Short isNeedApprove) {
        this.isNeedApprove = isNeedApprove;
    }

    public Short getIsAlreadyDemonstrate() {
        return isAlreadyDemonstrate;
    }

    public void setIsAlreadyDemonstrate(Short isAlreadyDemonstrate) {
        this.isAlreadyDemonstrate = isAlreadyDemonstrate;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Long inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Override
    public String toString() {
        return "ConstructionPlan{" +
                "id=" + id +
                "bridgeName=" + bridgeName +
                "pierNum=" + pierNum +
                "structure=" + structure +
                "procedure=" + procedure +
                "category=" + category +
                "isNeedDemonstrate=" + isNeedDemonstrate +
                "constuctionPlanFile=" + constuctionPlanFile +
                "isNeedApprove=" + isNeedApprove +
                "isAlreadyDemonstrate=" + isAlreadyDemonstrate +
                "classId=" + classId +
                "technicianId=" + technicianId +
                "inspectorId=" + inspectorId +
                '}';
    }
}