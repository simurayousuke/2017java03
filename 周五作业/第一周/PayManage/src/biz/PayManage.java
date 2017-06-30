package biz;
import java.util.Scanner;
import entity.DeptManager;
import entity.CommonEmployee;
import entity.Employee;
import entity.SellMan;

/**
 *工资管理类
 */
public class PayManage {
		
	/**
	 * 根据类型实例化员工对象
	 * @param type 员工类型
	 * @return 员工对象
	 */
	public Employee getEmployee(String type){
		Employee emp=null;
		Scanner input=new Scanner(System.in);
		System.out.print("请输入员工号：");
		String employeeId=input.next();
		System.out.print("请输入员姓名：");
		String employeeName=input.next();
		/*
		 * todo 根据类型的判断实例化各类型的对象
		 */
		
		return emp;
	}
}
