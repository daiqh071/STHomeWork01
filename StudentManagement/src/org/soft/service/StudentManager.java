package org.soft.service;

import java.util.Scanner;
import org.soft.vo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class {@code StudentManager} is about student information operations. 
 * 
 * <p>It provides the functions of {@code insertStu}, {@code searchStu}, 
 * {@code deleteStu}, {@code alterStu} and {@code outputStu} student information. 
 * It also provides a way to {@code exitSystem} 
 * and take charge of the program control process.
 * 
 * @author dai
 * @since 6 May 2021
 * @version 1.0
 *
 */

public class StudentManager {
		
	private static Logger logger = LogManager.getLogger(StudentManager.class.getName());
  //问题编号：27,48
	final int max = 20;

	/**
	 * Insert the information of student.
	 * @param stu the {@code Student[]} stores the input student object
	 * @param tab	the {@code int[]} marks the situation in which the stu stores objects
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	//问题编号：26
	@SuppressWarnings("resource")
	public void insertStu(Student[] stu, int[] tab) {
		Student student = new Student(); // 创建学生对象
		Scanner sc1 = new Scanner(System.in);
		System.out.print("学号：");
		student.setID(sc1.nextInt()); // 输入学号
		Scanner sc2 = new Scanner(System.in);
		System.out.print("姓名：");
		student.setName(sc2.nextLine()); // 输入姓名
		System.out.print("出生日期（xxxx.xx.xx）：");
		Scanner sc3 = new Scanner(System.in);
		student.setBirDate(sc3.nextLine()); // 输入出生日期
		System.out.print("性别（是否是男性：true或false）：");
		Scanner sc4 = new Scanner(System.in);
		student.setGender(sc4.nextBoolean()); // 输入性别（是否是男性：true\false）
		
		int iValue = 0; // 标记数组中有多少个数据
		
		// 检查学生数组的存储情况
		for (int i=0; i<max; i++) {
			
			// 当当前数组元素为1时，表示对应的学生数组元素存有学生对象
			// 问题编号：34
			// if (tab[i] == 1) {
			if (1 == tab[i]) {
				iValue += 1;
				
				// 当tab数组所有元素均为“1”，表名stu数组已经存满
			  // 问题编号：34
				// if (iValue == 20) {
				if (max == iValue) {
					System.out.println("抱歉，存储空间已满！");
					//问题编号：50
					logger.info("插入时，数组空间已满");
					return;
				} else {} // 问题编号：19,36
				
			} else {
				stu[i] = student; // 将添加的学生对象插入学生数组中
				tab[i] = 1; // 将对应的数组标志置为“1”
				break;
			}
			
		}
		
		// 问题编号：29
		student = null; // 局部对象变量使用后被复位为NULL
		System.out.println("插入信息成功！"); // 提示插入数据成功
		
		/*
		 * 问题编号：22
		 * // 对stu数组中所有学生对象按照学号递增排序（冒泡排序）
		for (int j=0; j<iValue; j++) {
			
			for (int k=0; k<iValue-j; k++) {
				
				if (stu[k].getID() > stu[k+1].getID()) {
					Student stud = new Student();
					stud = stu[k];
					stu[k] = stu[k+1];
					stu[k+1] = stud;
				}
				
			}
			
		}*/
		
		// 使用排序方法对学生数组进行排序
		StudentManager sm = new StudentManager();
		sm.sortStu(stu, iValue);
		//问题编号：50
		logger.info("成功插入一条数据");
		return;
	}
	
	
	/**
	 * Sort by student number
	 * @param stu the {@code Student[]} stores the input student object
	 * @param iValue represents the valid data in the stu
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	// 问题编号：52
	private void sortStu(Student[] stu, int iValue){
    for (int j=0; j<iValue; j++) {
			
			for (int k=0; k<iValue-j; k++) {
				
				if (stu[k].getID() > stu[k+1].getID()) {
					Student stud = new Student();
					stud = stu[k];
					stu[k] = stu[k+1];
					stu[k+1] = stud;
				} else {} // 问题编号：19,36
				
			}
			
    }
    //问题编号：50
  	logger.info("数组排序成功");
    return;
	}
	
	/**
	 * Search the information of students.
	 * @param stu the {@code Student[]} stores the input student object
	 * @param tab	the {@code int[]} marks the situation in which the stu stores objects
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	public void searchStu(Student[] stu, int[] tab) {
	  System.out.print("请输入所需查找信息的姓名：");
		// 问题编号：26
	  @SuppressWarnings("resource")
		Scanner sc2 = new Scanner(System.in); // 输入姓名
		String strName = sc2.nextLine();
		
		for (int i=0; i<max; i++) {
			
			// 寻找有效数据
			// 问题编号：34
			// if (tab[i] == 1) {
			if (1 == tab[i]) {
				
				// 有效数据中找输入姓名对应信息
				if (strName.equals(stu[i].getName())) {
					System.out.println(stu[i].getID() + "\t"+stu[i].getName() + "\t" + stu[i].getBirDate() + "\t" + stu[i].isGender()); // 输出该信息
					//问题编号：50
					logger.info("成功查询到一条数据");
					return;
				} else {} // 问题编号：19,36
				
			} else {
				System.out.println("抱歉，未找到！");
			  //问题编号：50
				logger.info("查询时没有查到数据");
				return;
			}
			
		}
		
		System.out.println("抱歉，未找到！"); // 当找完20条数据后仍未找到对应信息，给出提示
	  //问题编号：50
		logger.info("查询时没有查到数据");
		return;
	}
	
	
	/**
	 * Delect the information of students.
	 * @param stu the {@code Student[]} stores the input student object
	 * @param tab	the {@code int[]} marks the situation in which the stu stores objects
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	public void deleteStu(Student[] stu, int[] tab) {
		System.out.print("请输入所要删除信息的姓名：");
		// 问题编号：26
		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(System.in); // 输入要查询信息的姓名
		String strName = sc3.nextLine();
		int iValue = 0; // 记录当前学生数组中有效的数据条数
		
		// 计算当前数组中有效数据的条数
		for (int l=0; l<max; l++) {
			
			// 问题编号：34
			// if (tab[l] == 1) {
			if (1 == tab[l]) {
				iValue += 1;
			} else {} // 问题编号：19,36
			
		}
		
		// 在有效数据中
		for (int i=0; i<iValue; i++) {
			
			// 找到对应的信息
			if (strName.equals(stu[i].getName())) {
				
				// 将当前数据后的所有数据向前移
				for (int c=i; c<iValue-1; c++) {
					stu[c] = stu[c+1];
				}
				
				stu[iValue-1] = null; // 将原数组中最后一个有效数组元素置为null
				tab[iValue-1] = 0; // 更改对应的标志,使原tab数组中最后一个1置为0，表示当前学生数组中的有效数据减1
				System.out.println("删除成功！");
			  //问题编号：50
				logger.info("成功删除一条数据");
				return;
			} else {} // 问题编号：19,36
			
		}
		
		// 如果在有效数据中没有找到相应的元素，未出提示
		System.out.println("抱歉，未找到相应信息！");
	  //问题编号：50
		logger.info("删除时没有查到数据");
		return;
	}
	
	
	/**
	 * Alter the information of students.
	 * @param stu the {@code Student[]} stores the input student object
	 * @param tab	the {@code int[]} marks the situation in which the stu stores objects
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	// 问题编号:26
	@SuppressWarnings("resource")
	public void alterStu(Student[] stu, int[] tab) {
		System.out.print("请输入所要修改信息的姓名：");
		Scanner sc4 = new Scanner(System.in); // 输入所要找信息的姓名
		String strName = sc4.nextLine();
		
		// 遍历学生数组
		for (int i=0; i<max; i++) {
			
			// 找到有效数据
			// 问题编号：34
			// if (tab[i] == 1) {
			if (1 == tab[i]) {
				
				// 找到姓名对应的数据
				if (strName.equals(stu[i].getName())) {
					Scanner sc5 = new Scanner(System.in);
					System.out.print("学号：");
					stu[i].setID(sc5.nextInt()); // 修改学号
					System.out.print("姓名：");
					Scanner sc6 = new Scanner(System.in);
					stu[i].setName(sc6.nextLine()); // 修改姓名
					System.out.print("出生日期（xxxx.xx.xx）：");
					Scanner sc7 = new Scanner(System.in);
					stu[i].setBirDate(sc7.nextLine()); // 修改出生日期
					System.out.print("性别（是否为男性：true或false）：");
					Scanner sc8 = new Scanner(System.in);
					stu[i].setGender(sc8.nextBoolean()); // 修改性别（是否是男性：true或false）
					System.out.println("修改成功！");
				  //问题编号：50
					logger.info("成功修改一条数据");
					return;
				} else {} // 问题编号：19,36
				
			} else {
				System.out.println("抱歉，未找到相应信息！"); // 在有效数据中未找到对应的数据
			  //问题编号：50
				logger.info("修改时没有查到数据");
				return;
			}
			
		}
		
	}
	
	
	/**
	 * Output the information of students.
	 * @param stu the {@code Student[]} stores the input student object
	 * @param tab	the {@code int[]} marks the situation in which the stu stores objects
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	public void outputStu(Student[] stu, int[] tab) {
		System.out.println("学号\t姓名\t出生年月\t\t性别是否为男");
		
		// 遍历学生数组
		for (int i=0; i<max; i++) {
			
			// 找tab数组中标志为有效的数据对应的学生对象
			// 问题编号：34
			// if (tab[i] == 1) {
			if (1 == tab[i]) {
				System.out.println(stu[i].getID() + "\t" + stu[i].getName() + "\t" + stu[i].getBirDate()+"\t" + stu[i].isGender());
			} else {
				//问题编号：50
				logger.info("当数组标志显示没有有效数据，停止查询");
				return;
			}
			
		}
		
	  //问题编号：50
		logger.info("遍历整个数组并输出");
		return;
	}
	
	
	/**
	 * Exit the system.
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 */
	public void exitSystem() {
		System.out.println("退出程序！");
		System.exit(0); // 退出程序
	  //问题编号：50
		logger.info("退出程序");
		return;
	}
	
	
	/**
	 * Take charge of the program control process.
	 * @param stu the {@code Student[]} stores the input student object
	 * @param tab	the {@code int[]} marks the situation in which the stu stores objects
	 * @return {@code void} if {@code Student[]} is successfully inserted
	 * @see org.soft.vo.Student
	 */
	public void StudentManageApp(Student[] stu, int[] tab) {
		int iOperate; // 记录选择的操作
		
		// 循环执行菜单
		do {
			System.out.println("请选择操作：");
			System.out.println("******************************************");
			System.out.println("*                 1 插入                                    *");
			System.out.println("*                 2 查找                                    *");
			System.out.println("*                 3 删除                                    *");
			System.out.println("*                 4 修改                                    *");
			System.out.println("*                 5 输出                                    *");
			System.out.println("*                 6 退出                                    *");
			System.out.println("******************************************");
			//问题编号：26
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			iOperate = sc.nextInt(); // 输入选择的操作序号
			StudentManager sm = new StudentManager();
			
			switch (iOperate) {
				case 1:sm.insertStu(stu,tab);break; // 调用插入方法
				case 2:sm.searchStu(stu,tab);break; // 调用查找方法				
				case 3:sm.deleteStu(stu,tab);break; // 调用删除方法			
				case 4:sm.alterStu(stu,tab);break; // 调用修改方法				
				case 5:sm.outputStu(stu,tab);break; // 调用输出方法				
				case 6:sm.exitSystem();break; // 调用程序退出方法
				default:System.out.println("请输入正确的操作编号！");
			}
			
		} while(true); // 当执行完相应操作或者输入错误的操作序号，重复执行“菜单”
		
	}
}
