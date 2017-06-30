package entity;
import java.util.Scanner;

/**
 * 经理
 */
public class DeptManager extends Employee {
    private float bonus;//奖金
    
	public DeptManager(){}
	public DeptManager(String employeeId,String employeeName){
		super(employeeId, employeeName);
	}
    public DeptManager(String employeeId,String employeeName,float basicPay,float bonus){
    	//todo  初始化数据
    }  
    public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * 重写计算工资
	 */
	public float getPay() {
		Scanner input=new Scanner(System.in);
		float bonus=0; //奖金
		float basicPay=0; //基本工资
		try{
			System.out.print("请输入基本工资：");
			basicPay=input.nextFloat();
			this.setBasicPay(basicPay);
			System.out.print("请输入奖金：");
			bonus=input.nextFloat();
			this.setBonus(bonus);
		}catch(ArithmeticException e){
			System.out.println("输入格式不正确！");
			return 0;
		}
		// todo 计算工资：部门经理工资=基本工资+奖金
		return 0.0f;
	}
}
