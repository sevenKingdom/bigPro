package com.carry.model.mysql.po;


import java.io.Serializable;

public class Department  implements Serializable {

     private Long id;
     private String name;
     private Integer state;
     private Integer level;

     public Long getId(){
     	return id;
     }
     
     public void setId(Long id){
	 	this.id=id;
	 }

     public String getName(){
     	return name;
     }
     
     public void setName(String name){
	 	this.name=name;
	 }

     public Integer getState(){
     	return state;
     }
     
     public void setState(Integer state){
	 	this.state=state;
	 }

     public Integer getLevel(){
     	return level;
     }
     
     public void setLevel(Integer level){
	 	this.level=level;
	 }
	@Override
    public String toString() {
        return "Department{" +
                	"id=" + id +
                	"name=" + name +
                	"state=" + state +
                	"level=" + level +
                '}';
    }
}