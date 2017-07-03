import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Rule[] rule = { new Rule(50, 2, "百事可乐饮料1瓶"), new Rule(100, 3, "500ml可乐1瓶"), new Rule(100, 10, "5公斤面粉"),
				new Rule(200, 10, "1个苏波尔炒菜锅"), new Rule(200, 20, "欧莱雅爽肤水一瓶")};
		int ruleNum = rule.length;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入消费金额：");
		int iValue = input.nextInt();
		System.out.println("是否参加优惠换购活动：");
		for (int i = 0; i < ruleNum; ++i) {
			System.out.printf("%d：满%d元，加%d元换购%s\n", i + 1, rule[i].getMan(), rule[i].getJia(), rule[i].getHuan());
		}
		System.out.println("0：不换购");
		System.out.print("请选择：");
		int choice = input.nextInt();
		String huan = "";
		switch (choice) {
		default:
			if (choice < 0 || choice > ruleNum) {
				break;
			}
			while (iValue < rule[choice - 1].getMan()) {
				System.out.printf("您的消费金额不满%d，无法换购，请重新选择：", rule[choice - 1].getMan());
				choice = input.nextInt();
				if (choice == 0) {
					break;
				}
			}
			iValue += rule[choice - 1].getJia();
			huan = rule[choice - 1].getHuan();
			break;
		case 0:
			break;
		}
		System.out.printf("本次消费金额：%d\n", iValue);
		if (!huan.isEmpty()) {
			System.out.printf("成功换购：%s\n", huan);
		}
		input.close();
	}

}
