package org.soft.vo;

public class Student {
	//学号
	private int ID;
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
	//姓名
	private String name;
	//出生日期
	private String birDate;
	//性别
	private boolean gender;
}
