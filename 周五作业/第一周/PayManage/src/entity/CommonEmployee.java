package entity;
import java.util.Scanner;


/**
 * 普通员工
 *
 */
public class CommonEmployee extends Employee {
	private float workdays;//工作天数
	private float dailyWages;//日工资
	
	public CommonEmployee(){}
	public CommonEmployee(String employeeId,String employeeName){
		//todo
	}
	
	
	
	/**
	 * 重写计算工资
	 */
	public float getPay() {
		Scanner input=new Scanner(System.in);
		float basicPay=0; //基本工资
		float workdays=0; //工作天数
		float dailyWages=0; //日工资
		try{	
			System.out.print("请输入基本工资：");
			basicPay=input.nextFloat();
			this.setBasicPay(basicPay);
			System.out.print("请输入工作天数：");
			workdays=input.nextInt();
			//todo  设置工作天数
			
			System.out.print("请输入日工资：");
			dailyWages=input.nextFloat();
			//todo  设置日工资
		}catch(ArithmeticException e){
			System.out.println("输入格式不正确！");
			return 0;
		}		
		float day=0.0f;// todo 计算工资：普通员工工资=基本工资+日工资*工作天数
		return day;
	}

}
