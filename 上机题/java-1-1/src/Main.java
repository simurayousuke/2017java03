import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入会员卡号：");
        String numver=input.nextLine();
        char[] number=numver.toCharArray();
        int n=0;
        for(char c : number){
        	n+=Integer.parseInt(c+"");
        }
        System.out.printf("会员卡号%s各位之和：%d",numver,n);
        input.close();
	}

}
