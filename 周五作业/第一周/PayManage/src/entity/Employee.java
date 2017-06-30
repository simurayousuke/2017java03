package entity;

/**
 * 员工类
 */
public abstract class Employee {
	private String employeeId;//员工编号
	private String employeeName;//员工姓名 
	private float basicPay;//基本工资
	public abstract float getPay();//计算工资
	
	public Employee(){};
	/**
	 * 为员工的编号、姓名赋初始值
	 * @param employeeId 员工编号
	 * @param employeeName 员工姓名 
	 */
	public Employee(String employeeId,String employeeName){
		this.employeeId=employeeId;
		this.employeeName=employeeName;
	}
	
	/**
	 * 为员工的编号、姓名、基本工资赋初始值
	 * @param employeeId 员工编号
	 * @param employeeName 员工姓名 
	 * @param basicPay 基本工资
	 */
	public Employee(String employeeId,String employeeName,float basicPay){
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.basicPay=basicPay;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public float getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(float basicPay) {
		this.basicPay = basicPay;
	}
}
