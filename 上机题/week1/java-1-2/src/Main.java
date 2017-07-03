import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        System.out.println("请输入基本工资：");
        double dSalary=input.nextDouble();
        double wujia=1200;
        double fangzu=750;
        double all=dSalary+wujia+fangzu;
        System.out.println("该员工的工资细目为：");
        System.out.printf("基本工资为：%.1f\n",dSalary);
        System.out.printf("物价津贴为：%.1f\n",wujia);
        System.out.printf("房租津贴为：%.1f\n",fangzu);
        System.out.printf("员工薪水是：%.1f\n",all);
        input.close();
	}

}
