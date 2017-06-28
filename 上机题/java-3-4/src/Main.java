import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int CHANCE=3;
		Scanner input=new Scanner(System.in);
		int trying=0;
		for(;trying<CHANCE;++trying){
			System.out.print("请输入用户名：");
			String username=input.nextLine();
			System.out.print("请输入密码：");
			String password=input.nextLine();
			if(username.equals("jim")&&password.equals("123456")){
				System.out.println("欢迎登录MyShopping系统！");
				break;
			}else{
				System.out.printf("输入错误！您还有%d次机会！\n\n", CHANCE-trying-1);
			}
		}
		if(trying==3){
			System.out.println("对不起，您3次均输入错误！");
		}
		input.close();
	}

}
