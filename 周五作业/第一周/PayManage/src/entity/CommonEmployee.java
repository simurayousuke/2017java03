package entity;
import java.util.Scanner;


/**
 * 普通员工
 *
 */
public class CommonEmployee extends Employee {
	private float workdays;//工作天数
	private float dailyWages;//日工资

	public float getWorkdays() {
		return workdays;
	}

	public void setWorkdays(float workdays) {
		this.workdays = workdays;
	}

	public float getDailyWages() {
		return dailyWages;
	}

	public void setDailyWages(float dailyWages) {
		this.dailyWages = dailyWages;
	}

	public CommonEmployee(){}

	public CommonEmployee(String employeeId, String employeeName) {
		// finish
		super(employeeId, employeeName);
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
			//finish  设置工作天数
			this.setWorkdays(workdays);
			System.out.print("请输入日工资：");
			dailyWages=input.nextFloat();
			//finish  设置日工资
			this.setDailyWages(dailyWages);
		}catch(ArithmeticException e){
			System.out.println("输入格式不正确！");
			return 0;
		}		
		//float day=0.0f;// finish 计算工资：普通员工工资=基本工资+日工资*工作天数
		float salary=basicPay+dailyWages*workdays;
		return salary;
	}

}
