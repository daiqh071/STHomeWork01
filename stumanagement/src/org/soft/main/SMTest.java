package org.soft.main;

import java.util.Scanner;

import org.soft.service.StudentManager;
import org.soft.vo.Student;

public class SMTest {
	public static void main(String[] args){	
		//����ѧ����������
		Student stu[]=new Student[20];
		//����һ���������ڱ��ѧ�������еĴ洢���
		int tab[]=new int[20];
		StudentManager sm=new StudentManager();
		//����app�������Ƴ�������
		sm.StudentManageApp(stu,tab);
	}
}