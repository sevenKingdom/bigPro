package com.carry.model.mysql.po;


import java.io.Serializable;

public class ReviewPlan implements Serializable {
     private Long id;
     private Long planid;
     private String lowquality;
     private Long reviewer;
     private String power;
     private Long firstman;
     private Long createdAt;


     public Long getId(){
     	return id;
     }
     
     public void setId(Long id){
	 	this.id=id;
	 }

	public Long getPlanid() {
		return planid;
	}

	public void setPlanid(Long planid) {
		this.planid = planid;
	}

	public String getLowquality(){
     	return lowquality;
     }
     
     public void setLowquality(String lowquality){
	 	this.lowquality=lowquality;
	 }

     public Long getReviewer(){
     	return reviewer;
     }
     
     public void setReviewer(Long reviewer){
	 	this.reviewer=reviewer;
	 }

     public String getPower(){
     	return power;
     }
     
     public void setPower(String power){
	 	this.power=power;
	 }

     public Long getFirstman(){
     	return firstman;
     }
     
     public void setFirstman(Long firstman){
	 	this.firstman=firstman;
	 }


	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	@Override
    public String toString() {

        return "ReviewPlan{" +
                	"id=" + id +
                	"planId=" + planid +
                	"lowquality=" + lowquality +
                	"reviewer=" + reviewer +
                	"power=" + power +
                	"firstman=" + firstman +
                	"createdat=" + createdAt +
                '}';
    }
}