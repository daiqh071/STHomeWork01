package org.soft.vo;

public class Student {
	//ѧ��
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
	//����
	private String name;
	//��������
	private String birDate;
	//�Ա�
	private boolean gender;
}
