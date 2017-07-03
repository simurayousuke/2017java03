package com.pb.test;

import java.util.Scanner;

import com.pb.authority.Normal;
import com.pb.authority.StoreMgr;
import com.pb.authority.impl.DefaultCustomer;
import com.pb.authority.impl.DefaultStoreMgr;
import com.pb.biz.BookBiz;
import com.pb.entity.Book;
import com.pb.entity.EX;
import com.pb.role.Role;
import com.pb.role.User;
import com.pb.role.ext.Customer;
import com.pb.role.ext.StoreManager;



public class Test {
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Test test = new Test();
		User user = new User();// 创建用户
		System.out.println("欢迎使用图书书店");
		test.accreditRole(user);//  授权角色
		BookBiz.makeData();//初始化图书信息
		if (user.getRole() instanceof StoreManager)// 如果是库存管理员
			test.doStoreMgr(user);// 执行库管操作
		else if (user.getRole() instanceof Customer)// 如果是顾客
			test.doCustomer(user);// 执行顾客操作
	}

	/**
	 * 授权角色（判断登录用户，授权相应角色）
	 */
	public void accreditRole(User user) {
		System.out.print("请输入用户名：");
		String username = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		if (user.login(username, password)) {
			if (username.equals("admin")) {
				Role storeManager = new StoreManager();// 创建库管角色
				StoreMgr dfStoreMgr=new DefaultStoreMgr();//创建库管权限
				storeManager.setStoreMgr(dfStoreMgr);// 分配权限
				user.setRole(storeManager);// 为用户授权角色
			} else {
				Role customer = new Customer();// 创建顾客角色
				Normal dfCustomer=new DefaultCustomer();//创建库管权限
				customer.setNormal(dfCustomer);// 分配权限
				user.setRole(customer);// 为用户授权角色
			}
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败，请重新登录");
			accreditRole(user);
		}
	}

	/**
	 * 库存管理员操作
	 */
	public void doStoreMgr(User user) {
		System.out.println("*****欢迎登录库存管理系统*****");
		user.query();// 查询库存
		System.out.println("请选择进行的操作：1.图书入库     2.图书出库     3.查询全部图书     4.新增图书     5.退出");
		int codeId = input.nextInt();
		try {
			switch (codeId) {
			case 1:
				inBook(user);// 图书入库
				doStoreMgr(user);// 再次调用库管操作
				break;
			case 2:
				outBook(user);// 图书出库
				doStoreMgr(user);// 再次调用库管操作
				break;
			case 3:
				doStoreMgr(user);// 再次调用库管操作
				break;
			case 4:
				Book book = inputBookInfo();//录入图书信息
				user.save(book);// 新增图书
				doStoreMgr(user);// 再次调用库管操作
				break;
			case 5:
				System.out.println("谢谢使用！");
				return;
			default:
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("请输入正确格式的数字1-5");
			doStoreMgr(user);
		}
	}

	/**
	 * 图书入库
	 */
	public void inBook(User user) {
		System.out.println("请输入图书信息");
		try {
			System.out.print("请输入图书ID：");
			int bookId = input.nextInt();
			System.out.print("请输入入库的数量：");
			int num = input.nextInt();
			user.in(bookId, num);// 入库
		} catch (Exception e) {
			System.out.println("请输入正确格式的信息！注意：图书ID、数量为整数");
			inBook(user);
		}
	}

	/**
	 * 图书出库
	 */
	public void outBook(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入图书信息");
		try {
			System.out.print("请输入ID：");
			int id = input.nextInt();
			System.out.print("请输入出库的数量：");
			int num = input.nextInt();
			user.out(id, num);// 出库
		} catch (Exception e) {
			System.out.println("请输入正确格式的信息！注意：图书ID、数量为整数");
			outBook(user);
		}
	}

	/**
	 * 录入图书信息
	 */
	public Book inputBookInfo() {
		Scanner input = new Scanner(System.in);
		Book book = new Book();
		System.out.print("请输入图书信息");
		try {
			System.out.print("请输入书名：");
			String name = input.next();
			System.out.print("请输入作者：");
			String author = input.next();
			System.out.print("请输入出版时间：");
			String pub_date = input.next();
			System.out.print("请输入价格：");
			double price = input.nextDouble();
			System.out.print("请输入数量：");
			int store = input.nextInt();
			book.setName(name);
			book.setAuthor(author);
			book.setPub_date(pub_date);
			book.setPrice(price);
			book.setStore(store);
		} catch (Exception e) {
			System.out.println("请重新输入正确格式的信息！注意：图书ID、数量为整数，价格为double");
			inputBookInfo();
		}
		return book;
	}

	/**
	 * 顾客的操作
	 */
	public void doCustomer(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("*****欢迎光临图书系统*****");
		user.query();// 查询图书
		System.out.println("请选择进行的操作：1.查看图书   2.结账   3.退出");
		try {
			int code_id = input.nextInt();
			switch (code_id) {
			case 1:
				doCustomer(user);
				break;
			case 2:
				buyBook(user);// 买书结账
				doCustomer(user);
				break;
			case 3:
				System.out.println("谢谢光临，再见！");
				return;
			default:
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("请重新输入正确格式的数字1-3");
			doCustomer(user);
		}
	}

	/**
	 * 购买图书
	 * @return 图书
	 */
	public void buyBook(User user) {
		Book book = null;
		System.out.println("请输入欲购买的图书信息:");
		try {
			System.out.print("请输入图书ID：");
			int id = input.nextInt();
			System.out.print("请输入购买数量：");
			int num = input.nextInt();
			book = user.buy(id, num);
		} catch (Exception e) {
			System.out.println("请重新输入正确格式的信息！注意：图书ID、数量为整数");
			buyBook(user);
		}
		if (book != null) {
			while (true) {
				try {
					System.out.print("1.CD 27.50元      2.包装  2.70元       3.钢笔 10元     4.不需要\n请输入需要购买的附赠品：");
					int exCode = input.nextInt();
					if (exCode >= 1 && exCode <= 4) {
						EX ex = user.buyEx(exCode);
						book.setEx(ex);
						user.checkout(book);
						return;
					}
					System.out.println("请输入1-4之间的数字！");
				} catch (Exception e) {
					System.out.println("请重新输入正确格式的信息！注意：购买的附赠品为整数");
				}
			}
		}
	}
}
