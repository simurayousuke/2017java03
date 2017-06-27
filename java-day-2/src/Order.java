
public class Order {
	
	private String name;
	private String dish;
	private int num;
	private int time;
	private String addr;
	private boolean finish;
	private double value;
	
	public Order(String name, String dish, int num, int time, String addr, boolean finish, double value) {
		this.name = name;
		this.dish = dish;
		this.num = num;
		this.time = time;
		this.addr = addr;
		this.finish = finish;
		this.value = value;
	}
	
	

	@Override
	public String toString() {
		//"序号\t菜名\t份数\t金额\t收件人\t地址\t时间"
		return  dish + "\t" + num + "\t" + value + "\t" + name + "\t" + addr
				+ "\t" + time + "\t" + (finish?"已完成":"已下单");
	}



	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDish() {
		return dish;
	}
	
	public void setDish(String dish) {
		this.dish = dish;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public boolean isFinish() {
		return finish;
	}
	
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
}
