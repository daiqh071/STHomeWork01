package org.soft.service;

import java.util.Scanner;

import org.soft.vo.Student;

public class StudentManager {
	
	//插入方法
	public void insertStu(Student[] stu,int[] tab){
		//创建学生对象
		Student student=new Student();
		Scanner sc1=new Scanner(System.in);
		System.out.print("学号：");
		//输入学号
		student.setID(sc1.nextInt());
		Scanner sc2=new Scanner(System.in);
		System.out.print("姓名：");
		//输入姓名
		student.setName(sc2.nextLine());
		System.out.print("出生日期（xxxx.xx.xx）：");
		Scanner sc3=new Scanner(System.in);
		//输入出生日期
		student.setBirDate(sc3.nextLine());
		System.out.print("性别（是否是男性：true或false）：");
		Scanner sc4=new Scanner(System.in);
		//输入性别（是否是男性：true\false）
		student.setGender(sc4.nextBoolean());
		//标记数组中有多少个数据
		int x=0;
		//检查学生数组的存储情况
		for(int i=0;i<20;i++){
			//当当前数组元素为1时，表示对应的学生数组元素存有学生对象
			if(tab[i]==1){
				x+=1;
				//当tab数组所有元素均为“1”，表名stu数组已经存满
				if(x==20){
					System.out.println("抱歉，存储空间已满！");
					return;
				}
			}else{
				//将添加的学生对象插入学生数组中
				stu[i]=student;
				//将对应的数组标志置为“1”
				tab[i]=1;
				break;
			}
		}
		//提示插入数据成功
		System.out.println("插入信息成功！");
		//对stu数组中所有学生对象按照学号递增排序（冒泡排序）
		for(int j=0;j<x;j++){
			for(int k=0;k<x-j;k++){
				if(stu[k].getID()>stu[k+1].getID()){
					Student s=new Student();
					s=stu[k];
					stu[k]=stu[k+1];
					stu[k+1]=s;
				}
			}
		}
		return;
	}
	
	
	//查找方法
	public void searchStu(Student[] stu,int[] tab){
		System.out.print("请输入所需查找信息的姓名：");
		//输入姓名
		Scanner sc2=new Scanner(System.in);
		String na=sc2.nextLine();
		for(int i=0;i<20;i++){
			//寻找有效数据
			if(tab[i]==1){
				//有效数据中找输入姓名对应信息
				if(na.equals(stu[i].getName())){
					//输出该信息
					System.out.println(stu[i].getID()+"\t"+stu[i].getName()+"\t"+stu[i].getBirDate()+"\t"+stu[i].isGender());
					return;
				}
			}else{
				System.out.println("抱歉，未找到！");
				return;
			}
		}
		//当找完20条数据后仍未找到对应信息，给出提示
		System.out.println("抱歉，未找到！");
		return;
	}
	
	
	//删除方法
	public void deleteStu(Student[] stu,int[] tab){
		//记录当前学生数组中有效的数据条数
		int x=0;
		System.out.print("请输入所要删除信息的姓名：");
		//输入要查询信息的姓名
		Scanner sc3=new Scanner(System.in);
		String na=sc3.nextLine();
		//计算当前数组中有效数据的条数
		for(int l=0;l<20;l++){
			if(tab[l]==1){
				x+=1;
			}
		}
		//在有效数据中
		for(int i=0;i<x;i++){
			//找到对应的信息
			if(na.equals(stu[i].getName())){
				//将当前数据后的所有数据向前移
				for(int c=i;c<x-1;c++){
					stu[c]=stu[c+1];
				}
				//将原数组中最后一个有效数组元素置为null
				stu[x-1]=null;
				//更改对应的标志,使原tab数组中最后一个1置为0，表示当前学生数组中的有效数据减1
				tab[x-1]=0;
				System.out.println("删除成功！");
				return;
			}
		}
		//如果在有效数据中没有找到相应的元素，未出提示
		System.out.println("抱歉，未找到相应信息！");
		return;
	}
	
	
	//输出方法
	public void outputStu(Student[] stu,int[] tab){
		System.out.println("学号\t姓名\t出生年月\t\t性别是否为男");
		//遍历学生数组
		for(int i=0;i<20;i++){
			//找tab数组中标志为有效的数据对应的学生对象
			if(tab[i]==1){
				System.out.println(stu[i].getID()+"\t"+stu[i].getName()+"\t"+stu[i].getBirDate()+"\t"+stu[i].isGender());
			}else{
				return;
			}
		}
		return;
	}
	
	
	//退出方法
	public void exitSystem(){
		System.out.println("退出程序！");
		//退出程序
		System.exit(0);
	}
	
	
	//修改方法
	public void alterStu(Student[] stu,int[] tab){
		System.out.print("请输入所要修改信息的姓名：");
		//输入所要找信息的姓名
		Scanner sc4=new Scanner(System.in);
		String na=sc4.nextLine();
		//遍历学生数组
		for(int i=0;i<20;i++){
			//找到有效数据
			if(tab[i]==1){
				//找到姓名对应的数据
				if(na.equals(stu[i].getName())){
					Scanner sc5=new Scanner(System.in);
					System.out.print("学号：");
					//修改学号
					stu[i].setID(sc5.nextInt());
					System.out.print("姓名：");
					Scanner sc6=new Scanner(System.in);
					//修改姓名
					stu[i].setName(sc6.nextLine());
					System.out.print("出生日期（xxxx.xx.xx）：");
					Scanner sc7=new Scanner(System.in);
					//修改出生日期
					stu[i].setBirDate(sc7.nextLine());
					System.out.print("性别（是否为男性：true或false）：");
					Scanner sc8=new Scanner(System.in);
					//修改性别（是否是男性：true或false）
					stu[i].setGender(sc8.nextBoolean());
					System.out.println("修改成功！");
					return;
				}
			}else{
				//在有效数据中未找到对应的数据
				System.out.println("抱歉，未找到相应信息！");
				return;
			}
		}
	}
	
	//控制程序流程的方法
	public void StudentManageApp(Student[] stu,int[] tab){
		//记录选择的操作
		int k;
		//循环执行菜单
		do{
			System.out.println("请选择操作：");
			System.out.println("******************************************");
			System.out.println("*                 1 插入                                    *");
			System.out.println("*                 2 查找                                    *");
			System.out.println("*                 3 删除                                    *");
			System.out.println("*                 4 修改                                    *");
			System.out.println("*                 5 输出                                    *");
			System.out.println("*                 6 退出                                    *");
			System.out.println("******************************************");
			Scanner sc=new Scanner(System.in);
			//输入选择的操作序号
			k=sc.nextInt();
			StudentManager sm=new StudentManager();
			switch(k){
				//调用插入方法
				case 1:sm.insertStu(stu,tab);break;
				//调用查找方法
				case 2:sm.searchStu(stu,tab);break;
				//调用删除方法
				case 3:sm.deleteStu(stu,tab);break;
				//调用修改方法
				case 4:sm.alterStu(stu,tab);break;
				//调用输出方法
				case 5:sm.outputStu(stu,tab);break;
				//调用程序退出方法
				case 6:sm.exitSystem();break;
				default:System.out.println("请输入正确的操作编号！");
			}
		}while(true);//当执行完相应操作或者输入错误的操作序号，重复执行“菜单”
	}
}
