
import java.util.Scanner;

public class CustManagement {
	/* 商品信息 */
	public Goods goods[] = new Goods[50];
	/* 会员信息 */
	public Customer customers[] = new Customer[100];

	/**
	 * 传递数据
	 */
	public void setData(Goods[] goods, Customer[] customers) { // 如果不使用this，请把形参名改变即可
		this.goods = goods;
		this.customers = customers;
	}

	/**
	 * 返回上一级菜单
	 */
	public void returnLastMenu() {
		System.out.print("\n\n请按'n'返回上一级菜单:");
		Scanner input = new Scanner(System.in);
		boolean con = true;
		do {
			CustManagement cm = new CustManagement();
			cm.setData(goods, customers);
			String num = input.next();
			if (num.equals("1")) {
				cm.show();
				break;
			} else if (num.equals("2")) {
				cm.add();
				break;
			} else if (num.equals("3")) {
				cm.modify();
				break;
			} else if (num.equals("4")) {
				cm.search();
				break;
			} else if (num.equals("n")) {
				Menu menu = new Menu();
				menu.setData(goods, customers);
				menu.showCustMMenu();
			} else {
				System.out.print("输入错误, 请重新'n'返回上一级菜单：");
				con = false;
			}
		} while (!con);
		input.close();
	}
	
	private int size(){
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].custNo == 0) {
				return i;
			}
		}
		return customers.length;
	}

	/**
	 * 循环增加会员：MY
	 */
	public void add() {
		System.out.println("购物管理系统 > 客户信息管理 > 添加客户信息\n\n");
		String con = "n";
		// 确定插入会员位置
		int index = this.size();
		Scanner input = new Scanner(System.in);
		do { // 循环录入会员信息
			System.out.print("请输入会员号(<4位整数>)：");
			int no = input.nextInt();
			System.out.print("请输入会员生日（月/日<用两位数表示>）：");
			String birth = input.next();
			System.out.print("请输入积分：");
			int score = input.nextInt();

			// 会员号无效则跳出
			if (no < 1000 || no > 9999) {
				System.out.println("客户号" + no + "是无效会员号！");
				System.out.println("录入信息失败\n");
				System.out.println("继续添加会员吗？（y/n）");
				con = input.next();
				continue;
			}
			// 添加会员

			customers[index].custNo = no;
			customers[index].custBirth = birth;
			customers[index++].custScore = score;
			System.out.println("新会员添加成功！");
			System.out.println("继续添加会员吗？（y/n）");
			con = input.next();
		} while ("y".equals(con) || "Y".equals(con));
		returnLastMenu();
		input.close();
	}

	/**
	 * 更改客户信息
	 */
	public void modify() {
		System.out.println("购物管理系统 > 客户信息管理 > 修改客户信息\n\n");
		System.out.print("请输入会员号：");
		Scanner input = new Scanner(System.in);
		int no = input.nextInt();
		System.out.println("  会员号        \t   生日   \t          积分      ");
		System.out.println("------------|------------|---------------");
		int index = -1;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].custNo == no) {
				System.out.println(
						customers[i].custNo + "\t\t" + customers[i].custBirth + "\t\t" + customers[i].custScore);
				index = i;
				break;
			}
		}

		if (index != -1) {
			while (true) {
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.println("\t\t\t\t1.修 改 会 员 生 日.\n");
				System.out.println("\t\t\t\t2.修 改 会 员 积 分.\n");
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.print("请选择，输入数字：");
				switch (input.nextInt()) {
				case 1:
					System.out.print("请输入修改后的生日：");
					customers[index].custBirth = input.next();
					System.out.println("生日信息已更改！");
					break;
				case 2:
					System.out.print("请输入修改后的会员积分：");
					customers[index].custScore = input.nextInt();
					System.out.println("会员积分已更改！");
					break;
				}

				System.out.println("是否修改其他属性(y/n):");
				String flag = input.next();
				;
				if ("n".equalsIgnoreCase(flag))
					break;
			}
		} else {
			System.out.println("抱歉，没有你查询的会员。");
		}
		
		// 返回上一级菜单
		returnLastMenu();
		input.close();
	}

	/**
	 * 查询客户的信息
	 */
	public void search() {
		System.out.println("购物管理系统 > 客户信息管理 > 查询客户信息\n");
		String con = "y";
		Scanner input = new Scanner(System.in);
		while (con.equals("y")) {
			System.out.print("请输入会员号：");
			int no = input.nextInt();
			System.out.println("  会员号  \t   生日  \t   积分      ");
			System.out.println("------------|------------|---------------");
			boolean isAvailable = false;
			int size=this.size();
			// 实现查询会员信息
			for (int i = 0; i < size; ++i) {
				if (customers[i].custNo == no) {
					isAvailable = true;
					System.out.printf("  %d\t\t  %s\t\t  %d\n", customers[i].custNo, customers[i].custBirth,
							customers[i].custScore);
				}
			}

			if (!isAvailable) {
				System.out.println("抱歉，没有你查询的会员信息。");
			}
			System.out.print("\n要继续查询吗（y/n）:");
			con = input.next();
		}
		
		// 返回上一级菜单
		returnLastMenu();
		input.close();
	}

	/**
	 * 显示所有的会员信息
	 */
	public void show() {
		System.out.println("购物管理系统 > 客户信息管理 > 显示客户信息\n\n");
		System.out.println("  会员号  \t   生日  \t   积分      ");
		System.out.println("------------|------------|---------------");
		int length = this.size();
		// 显示所有会员信息
		for (int i = 0; i < length; ++i) {
			System.out.printf("  %d\t\t  %s\t\t  %d\n", customers[i].custNo, customers[i].custBirth, customers[i].custScore);
		}

		// 返回上一级菜单
		returnLastMenu();
	}

	/**
	 * 
	 * @param ageline
	 */
	public void AgeRate(int ageline) {
		int young = 0; // 记录年龄分界线以下顾客的人数
		int old = 0; // 记录年龄分界线以上顾客的人数
		int age = 0; // 保存顾客的年龄
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.print("请输入第" + (i + 1) + "位顾客的年龄：");
			age = input.nextInt();
			if (age > 0 && age <= 30) {
				young++;
			} else if (age > 30) {
				old++;
			}
		}
		System.out.println("30岁以下的比例是：" + young / 10.0 * 100 + "%");
		System.out.println("30岁以上的比例是：" + old / 10.0 * 100 + "%");
		input.close();
	}
}
