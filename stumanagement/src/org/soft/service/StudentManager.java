package org.soft.service;

import java.util.Scanner;

import org.soft.vo.Student;

public class StudentManager {
	
	//���뷽��
	public void insertStu(Student[] stu,int[] tab){
		//����ѧ������
		Student student=new Student();
		Scanner sc1=new Scanner(System.in);
		System.out.print("ѧ�ţ�");
		//����ѧ��
		student.setID(sc1.nextInt());
		Scanner sc2=new Scanner(System.in);
		System.out.print("������");
		//��������
		student.setName(sc2.nextLine());
		System.out.print("�������ڣ�xxxx.xx.xx����");
		Scanner sc3=new Scanner(System.in);
		//�����������
		student.setBirDate(sc3.nextLine());
		System.out.print("�Ա��Ƿ������ԣ�true��false����");
		Scanner sc4=new Scanner(System.in);
		//�����Ա��Ƿ������ԣ�true\false��
		student.setGender(sc4.nextBoolean());
		//����������ж��ٸ�����
		int x=0;
		//���ѧ������Ĵ洢���
		for(int i=0;i<20;i++){
			//����ǰ����Ԫ��Ϊ1ʱ����ʾ��Ӧ��ѧ������Ԫ�ش���ѧ������
			if(tab[i]==1){
				x+=1;
				//��tab��������Ԫ�ؾ�Ϊ��1��������stu�����Ѿ�����
				if(x==20){
					System.out.println("��Ǹ���洢�ռ�������");
					return;
				}
			}else{
				//�����ӵ�ѧ���������ѧ��������
				stu[i]=student;
				//����Ӧ�������־��Ϊ��1��
				tab[i]=1;
				break;
			}
		}
		//��ʾ�������ݳɹ�
		System.out.println("������Ϣ�ɹ���");
		//��stu����������ѧ��������ѧ�ŵ�������ð������
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
	
	
	//���ҷ���
	public void searchStu(Student[] stu,int[] tab){
		System.out.print("���������������Ϣ��������");
		//��������
		Scanner sc2=new Scanner(System.in);
		String na=sc2.nextLine();
		for(int i=0;i<20;i++){
			//Ѱ����Ч����
			if(tab[i]==1){
				//��Ч������������������Ӧ��Ϣ
				if(na.equals(stu[i].getName())){
					//�������Ϣ
					System.out.println(stu[i].getID()+"\t"+stu[i].getName()+"\t"+stu[i].getBirDate()+"\t"+stu[i].isGender());
					return;
				}
			}else{
				System.out.println("��Ǹ��δ�ҵ���");
				return;
			}
		}
		//������20�����ݺ���δ�ҵ���Ӧ��Ϣ��������ʾ
		System.out.println("��Ǹ��δ�ҵ���");
		return;
	}
	
	
	//ɾ������
	public void deleteStu(Student[] stu,int[] tab){
		//��¼��ǰѧ����������Ч����������
		int x=0;
		System.out.print("��������Ҫɾ����Ϣ��������");
		//����Ҫ��ѯ��Ϣ������
		Scanner sc3=new Scanner(System.in);
		String na=sc3.nextLine();
		//���㵱ǰ��������Ч���ݵ�����
		for(int l=0;l<20;l++){
			if(tab[l]==1){
				x+=1;
			}
		}
		//����Ч������
		for(int i=0;i<x;i++){
			//�ҵ���Ӧ����Ϣ
			if(na.equals(stu[i].getName())){
				//����ǰ���ݺ������������ǰ��
				for(int c=i;c<x-1;c++){
					stu[c]=stu[c+1];
				}
				//��ԭ���������һ����Ч����Ԫ����Ϊnull
				stu[x-1]=null;
				//���Ķ�Ӧ�ı�־,ʹԭtab���������һ��1��Ϊ0����ʾ��ǰѧ�������е���Ч���ݼ�1
				tab[x-1]=0;
				System.out.println("ɾ���ɹ���");
				return;
			}
		}
		//�������Ч������û���ҵ���Ӧ��Ԫ�أ�δ����ʾ
		System.out.println("��Ǹ��δ�ҵ���Ӧ��Ϣ��");
		return;
	}
	
	
	//�������
	public void outputStu(Student[] stu,int[] tab){
		System.out.println("ѧ��\t����\t��������\t\t�Ա��Ƿ�Ϊ��");
		//����ѧ������
		for(int i=0;i<20;i++){
			//��tab�����б�־Ϊ��Ч�����ݶ�Ӧ��ѧ������
			if(tab[i]==1){
				System.out.println(stu[i].getID()+"\t"+stu[i].getName()+"\t"+stu[i].getBirDate()+"\t"+stu[i].isGender());
			}else{
				return;
			}
		}
		return;
	}
	
	
	//�˳�����
	public void exitSystem(){
		System.out.println("�˳�����");
		//�˳�����
		System.exit(0);
	}
	
	
	//�޸ķ���
	public void alterStu(Student[] stu,int[] tab){
		System.out.print("��������Ҫ�޸���Ϣ��������");
		//������Ҫ����Ϣ������
		Scanner sc4=new Scanner(System.in);
		String na=sc4.nextLine();
		//����ѧ������
		for(int i=0;i<20;i++){
			//�ҵ���Ч����
			if(tab[i]==1){
				//�ҵ�������Ӧ������
				if(na.equals(stu[i].getName())){
					Scanner sc5=new Scanner(System.in);
					System.out.print("ѧ�ţ�");
					//�޸�ѧ��
					stu[i].setID(sc5.nextInt());
					System.out.print("������");
					Scanner sc6=new Scanner(System.in);
					//�޸�����
					stu[i].setName(sc6.nextLine());
					System.out.print("�������ڣ�xxxx.xx.xx����");
					Scanner sc7=new Scanner(System.in);
					//�޸ĳ�������
					stu[i].setBirDate(sc7.nextLine());
					System.out.print("�Ա��Ƿ�Ϊ���ԣ�true��false����");
					Scanner sc8=new Scanner(System.in);
					//�޸��Ա��Ƿ������ԣ�true��false��
					stu[i].setGender(sc8.nextBoolean());
					System.out.println("�޸ĳɹ���");
					return;
				}
			}else{
				//����Ч������δ�ҵ���Ӧ������
				System.out.println("��Ǹ��δ�ҵ���Ӧ��Ϣ��");
				return;
			}
		}
	}
	
	//���Ƴ������̵ķ���
	public void StudentManageApp(Student[] stu,int[] tab){
		//��¼ѡ��Ĳ���
		int k;
		//ѭ��ִ�в˵�
		do{
			System.out.println("��ѡ�������");
			System.out.println("******************************************");
			System.out.println("*                 1 ����                                    *");
			System.out.println("*                 2 ����                                    *");
			System.out.println("*                 3 ɾ��                                    *");
			System.out.println("*                 4 �޸�                                    *");
			System.out.println("*                 5 ���                                    *");
			System.out.println("*                 6 �˳�                                    *");
			System.out.println("******************************************");
			Scanner sc=new Scanner(System.in);
			//����ѡ��Ĳ������
			k=sc.nextInt();
			StudentManager sm=new StudentManager();
			switch(k){
				//���ò��뷽��
				case 1:sm.insertStu(stu,tab);break;
				//���ò��ҷ���
				case 2:sm.searchStu(stu,tab);break;
				//����ɾ������
				case 3:sm.deleteStu(stu,tab);break;
				//�����޸ķ���
				case 4:sm.alterStu(stu,tab);break;
				//�����������
				case 5:sm.outputStu(stu,tab);break;
				//���ó����˳�����
				case 6:sm.exitSystem();break;
				default:System.out.println("��������ȷ�Ĳ�����ţ�");
			}
		}while(true);//��ִ������Ӧ���������������Ĳ�����ţ��ظ�ִ�С��˵���
	}
}