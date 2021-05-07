package org.soft.vo;

public class Student {
	private int ID; // 学号
	
	
	public int getID() {
		return ID;
	}
	
	
	public void setID(int iD) {
		ID = iD;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getBirDate() {
		return birDate;
	}
	
	
	public void setBirDate(String birDate) {
		this.birDate = birDate;
	}
	
	
	public boolean isGender() {
		return gender;
	}
	
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	private String name; // 姓名
	private String birDate; // 出生日期
	private boolean gender; // 性别
}
