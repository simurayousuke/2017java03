import java.util.ArrayList;
import java.util.Scanner;

public class OrderingMsg {

	private static void init(ArrayList<Order> orders, ArrayList<Dish> dishes) {
		// 初始化2个订单信息
		orders.add(new Order("张晴", "红烧带鱼", 2, 12, "No207", true, 76.0));
		orders.add(new Order("张晴", "鱼香肉丝", 2, 18, "No207", false, 20.0));

		// 供选择的菜品信息
		dishes.add(new Dish("红烧带鱼", 38.0, 0));
		dishes.add(new Dish("鱼香肉丝", 20.0, 0));
		dishes.add(new Dish("时令鲜蔬", 10.0, 0));
		dishes.add(new Dish("杨森", 0.0, 0));
	}

	private static void printMenu() {
		// 显示菜单
		System.out.println("****************************");
		System.out.println("1、我要订餐");
		System.out.println("2、查看餐袋");
		System.out.println("3、签收订单");
		System.out.println("4、删除订单");
		System.out.println("5、我要点赞");
		System.out.println("6、退出系统");
		System.out.println("****************************");
		System.out.print("请选择：");
	}

	private static boolean hasOrder(ArrayList<Order> orders) {
		if (orders.isEmpty()) {
			System.out.println("无订单！");
			System.out.println("输入0返回上层");
			return false;
		}
		return true;
	}

	private static boolean hasDish(ArrayList<Dish> dishes) {
		if (dishes.isEmpty()) {
			System.out.println("无菜品！");
			System.out.println("输入0返回上层");
			return false;
		}
		return true;
	}

	private static void handleCase1(ArrayList<Order> orders, ArrayList<Dish> dishes, Scanner input) {
		int selected = -1;
		System.out.println("序号\t菜名\t单价");
		for (int i = 0; i < dishes.size(); ++i) {
			Dish d = dishes.get(i);
			System.out.printf("%d\t%s\t%.1f元\t", i + 1, d.getName(), d.getValue());
			if (d.getNum() > 0) {
				System.out.printf("%d赞", d.getNum());
			}
			System.out.println();
		}
		do {
			System.out.print("请选择序号：");
			selected = input.nextInt();
			if (selected < 0 || selected >= dishes.size() + 1) {
				System.out.printf("请输入1到%d之间的数!", dishes.size());
				continue;
			}
			if (selected == 0) {
				break;
			}
			Dish d = dishes.get(selected - 1);
			String dish = d.getName();
			System.out.print("请输入份数：");
			int num = input.nextInt();
			System.out.print("请输入姓名：");
			String name = input.next();
			System.out.print("请输入地址：");
			String addr = input.next();
			System.out.print("请输入送餐时间(10-20)：");
			int time = input.nextInt();
			while (time < 10 || time > 20) {
				System.out.print("请重新选择送餐时间(10-20)：");
				time = input.nextInt();
			}
			double value = d.getValue() * num > 50 ? d.getValue() * num : d.getValue() * num + 6;
			orders.add(new Order(name, dish, num, time, addr, false, value));
			System.out.printf("订餐成功：%d份%s,共%.1f元\n", num, d.getName(), value);
			break;
		} while (selected != 0);
		System.out.println("输入0返回上层");
		input.next();
	}

	private static void handleCase2(ArrayList<Order> orders, Scanner input) {
		if (!hasOrder(orders)) {
			input.next();
			return;
		}
		System.out.println("序号\t菜名\t份数\t金额\t收件人\t地址\t时间\t订单状态");
		for (int i = 0; i < orders.size(); ++i) {
			System.out.printf("%d\t%s\n", i + 1, orders.get(i).toString());
		}
		System.out.println("输入0返回上层");
		input.next();
	}

	private static void handleCase3(ArrayList<Order> orders, Scanner input) {
		if (!hasOrder(orders)) {
			input.next();
			return;
		}
		int choice = -1;
		do {
			System.out.printf("请输入1-%d的订单序号：", orders.size());
			choice = input.nextInt();
			if (choice > 0 && choice < orders.size() + 1) {
				orders.get(choice - 1).setFinish(true);
				choice = 0;
				System.out.println("签收成功");
			}
		} while (choice != 0);
		System.out.println("输入0返回上层");
		input.next();
	}

	private static void handleCase4(ArrayList<Order> orders, Scanner input) {
		if (!hasOrder(orders)) {
			input.next();
			return;
		}
		int choice = -1;
		do {
			System.out.printf("请输入1-%d的订单序号：", orders.size());
			choice = input.nextInt();
			if (choice > 0 && choice < orders.size() + 1) {
				orders.remove(choice - 1);
				choice = 0;
				System.out.println("删除成功");
			}
		} while (choice != 0);
		System.out.println("输入0返回上层");
		input.next();
	}

	private static void handleCase5(ArrayList<Dish> dishes, Scanner input) {
		if (!hasDish(dishes)) {
			input.next();
			return;
		}
		int selected = -1;
		do {
			System.out.println("序号\t菜名\t单价\t点赞数");
			for (int i = 0; i < dishes.size(); ++i) {
				Dish d = dishes.get(i);
				System.out.printf("%d\t%s\t%.1f元\t%d赞\n", i + 1, d.getName(), d.getValue(), d.getNum());
			}
			System.out.print("请选择序号：");
			selected = input.nextInt();
			if (selected < 0 || selected >= dishes.size() + 1) {
				System.out.printf("请输入1到%d之间的数!", dishes.size());
				continue;
			}
			if (selected == 0) {
				break;
			}
			Dish d = dishes.get(selected - 1);
			d.setNum(d.getNum() + 1);
			System.out.println("点赞成功！");

		} while (selected != 0);
	}

	public static void main(String[] args) {

		ArrayList<Order> orders = new ArrayList<Order>();
		ArrayList<Dish> dishes = new ArrayList<Dish>();

		init(orders, dishes);

		Scanner input = new Scanner(System.in);
		int choice;
		boolean isExit = false;
		while (!isExit) {
			printMenu();
			choice = input.nextInt();
			switch (choice) {
			case 1:
				handleCase1(orders, dishes, input);
				break;
			case 2:
				handleCase2(orders, input);
				break;
			case 3:
				handleCase3(orders, input);
				break;
			case 4:
				handleCase4(orders, input);
				break;
			case 5:
				handleCase5(dishes, input);
				break;
			default:
				System.out.println("再见");
				isExit = true;
				break;
			}
		}
		input.close();
	}
}
