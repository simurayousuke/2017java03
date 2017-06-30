package biz;
import java.util.Scanner;

import entity.Employee;

/**
 * 工资管理系统
 */
public class PayManageSys {
	public static void main(String[] args) {
		PayManage manage=new PayManage();
		Scanner input=new Scanner(System.in);
		System.out.println(">>工资管理系统：");
		System.out.println("1. 普通员工   2.销售人员    3.经理");
		System.out.print("请选择类型：");
		int typeId=input.nextInt();
		String type="";
		//todo判断类型
		
		Employee emp=null;//todo 需要计算工资的员工对象
		float pay=emp.getPay();//员工工资		
		System.out.println(emp.getEmployeeName()+"("+emp.getEmployeeId()+")"+"的工资是："+pay+"元");
	}
}
