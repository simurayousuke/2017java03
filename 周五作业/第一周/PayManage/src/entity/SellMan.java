package entity;
import java.util.Scanner;

/**
 * 销售人员
 */
public class SellMan extends Employee{
	private float sale;//销售额
	public SellMan(){}
	public SellMan(String employeeId,String employeeName){
		super(employeeId, employeeName);
	}

	public SellMan(String employeeId, String employeeName, float basicPay, float sale) {
		// finish 初始化数据
		super(employeeId, employeeName, basicPay);
		this.sale = sale;
	}

	public float getSale() {
		return sale;
	}
	public void setSale(float sale) {
		this.sale = sale;
	}
	
	/**
	 * 重写计算工资
	 */
	public float getPay() {
		Scanner input=new Scanner(System.in);
		float basicPay=0;//基本工资
		float sale=0; //销售额
		try{
			System.out.print("请输入基本工资：");
			basicPay=input.nextFloat();
			this.setBasicPay(basicPay);
			System.out.print("请输入销售额：");
			sale=input.nextFloat();
			this.setSale(sale);
		}catch(ArithmeticException e){
			System.out.println("输入格式不正确！");
			return 0;
		}
		float salary=(float)(basicPay+sale*0.15);
		return salary;// finish 计算工资：销售人员工资=基本工资+销售额*0.15
	}
}
