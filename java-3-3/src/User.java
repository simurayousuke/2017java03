
public class User {

	String birth,num,bonus;
	
	public User(String num,String birth,String bonus){
		this.num=num;
		this.bonus=bonus;
		this.birth=birth;
	}
	
	public int getNum(){
		return Integer.parseInt(num);
	}
	
	public int getBonus(){
		return Integer.parseInt(bonus);
	}
	
	public String getBirth(){
		return birth;
	}
	
}
