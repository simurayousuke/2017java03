
public class Dish {

	private String name;
	private double value;
	private int num;
	
	public Dish(String name, double value, int num) {
		super();
		this.name = name;
		this.value = value;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
}
