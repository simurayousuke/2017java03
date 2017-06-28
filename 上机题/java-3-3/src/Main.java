import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	private static int validate(String num,String birth,String bonus){
		String numPattern="^[0-9]{4}$";
		String birthPattern="^[0-9]{2}/[0-9]{2}$";
		String bonusPattern="^[0-9]*$";
		int ret=0;
		if(!Pattern.matches(numPattern, num)){
			System.out.printf("客户号%s是无效会员号！\n", num);
			ret+=1;
		}
		if(!Pattern.matches(birthPattern, birth)){
			System.out.printf("生日%s是无效生日！\n", birth);
			ret+=2;
		}
		if(!Pattern.matches(bonusPattern, bonus)){
			System.out.printf("积分%s是无效积分！\n", bonus);
			ret+=4;
		}
		if(ret>0){
			System.out.println("录入信息失败\n");
		}else{
			System.out.printf("您录入的会员信息是：\n%s %s %s\n\n", num,birth,bonus);
		}
		return ret;
	}

	public static void main(String[] args) {
		final int NUM=3;
		Scanner input=new Scanner(System.in);
		System.out.println("MyShopping管理系统> 客户信息管理> 添加客户信息\n");
		for(int i=0;i<NUM;++i){
			System.out.print("请输入会员号（<4位整数>）：");
			String num=input.nextLine();
			System.out.print("请输入会员生日（月/日<用两位整数表示>）：");
			String birth=input.nextLine();
			System.out.print("请输入会员积分：");
			String bonus=input.nextLine();
			int ret=validate(num,birth,bonus);
			if(ret>0){
				continue;
			}
		}
		System.out.println("程序结束！");
		input.close();
	}

}
