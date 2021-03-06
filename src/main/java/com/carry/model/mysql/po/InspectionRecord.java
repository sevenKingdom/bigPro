package com.carry.model.mysql.po;


import java.io.Serializable;

public class InspectionRecord implements Serializable {
     private Long id;
     private Long inspectorid;
     private Long planid;
     private String quality;
     private String lowquality;
     private Integer style;
     private Long createdAt;


     public Long getId(){
     	return id;
     }
     
     public void setId(Long id){
	 	this.id=id;
	 }

     public Long getInspectorid(){
     	return inspectorid;
     }
     
     public void setInspectorid(Long inspectorid){
	 	this.inspectorid=inspectorid;
	 }

     public Long getPlanid(){
     	return planid;
     }
     
     public void setPlanid(Long planid){
	 	this.planid=planid;
	 }

     public String getQuality(){
     	return quality;
     }
     
     public void setQuality(String quality){
	 	this.quality=quality;
	 }

     public String getLowquality(){
     	return lowquality;
     }
     
     public void setLowquality(String lowquality){
	 	this.lowquality=lowquality;
	 }

     public Integer getStyle(){
     	return style;
     }
     
     public void setStyle(Integer style){
	 	this.style=style;
	 }


    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {

        return "InspectionRecord{" +
                	"id=" + id +
                	"inspectorid=" + inspectorid +
                	"planid=" + planid +
                	"quality=" + quality +
                	"lowquality=" + lowquality +
                	"style=" + style +
                	"createdat=" + createdAt +
                '}';
    }
}