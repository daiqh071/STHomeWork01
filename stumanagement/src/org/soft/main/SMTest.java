package org.soft.main;

import java.util.Scanner;

import org.soft.service.StudentManager;
import org.soft.vo.Student;

public class SMTest {
	public static void main(String[] args){	
		//创建学生类型数组
		Student stu[]=new Student[20];
		//建立一个数组用于标记学生数组中的存储情况
		int tab[]=new int[20];
		StudentManager sm=new StudentManager();
		//调用app方法控制程序流程
		sm.StudentManageApp(stu,tab);
	}
}
