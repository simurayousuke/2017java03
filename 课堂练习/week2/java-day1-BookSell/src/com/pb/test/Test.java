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
		User user = new User();// �����û�
		System.out.println("��ӭʹ��ͼ�����");
		test.accreditRole(user);//  ��Ȩ��ɫ
		BookBiz.makeData();//��ʼ��ͼ����Ϣ
		if (user.getRole() instanceof StoreManager)// ����ǿ�����Ա
			test.doStoreMgr(user);// ִ�п�ܲ���
		else if (user.getRole() instanceof Customer)// ����ǹ˿�
			test.doCustomer(user);// ִ�й˿Ͳ���
	}

	/**
	 * ��Ȩ��ɫ���жϵ�¼�û�����Ȩ��Ӧ��ɫ��
	 */
	public void accreditRole(User user) {
		System.out.print("�������û�����");
		String username = input.next();
		System.out.print("���������룺");
		String password = input.next();
		if (user.login(username, password)) {
			if (username.equals("admin")) {
				Role storeManager = new StoreManager();// ������ܽ�ɫ
				StoreMgr dfStoreMgr=new DefaultStoreMgr();//�������Ȩ��
				storeManager.setStoreMgr(dfStoreMgr);// ����Ȩ��
				user.setRole(storeManager);// Ϊ�û���Ȩ��ɫ
			} else {
				Role customer = new Customer();// �����˿ͽ�ɫ
				Normal dfCustomer=new DefaultCustomer();//�������Ȩ��
				customer.setNormal(dfCustomer);// ����Ȩ��
				user.setRole(customer);// Ϊ�û���Ȩ��ɫ
			}
			System.out.println("��¼�ɹ���");
		} else {
			System.out.println("��¼ʧ�ܣ������µ�¼");
			accreditRole(user);
		}
	}

	/**
	 * ������Ա����
	 */
	public void doStoreMgr(User user) {
		System.out.println("*****��ӭ��¼������ϵͳ*****");
		user.query();// ��ѯ���
		System.out.println("��ѡ����еĲ�����1.ͼ�����     2.ͼ�����     3.��ѯȫ��ͼ��     4.����ͼ��     5.�˳�");
		int codeId = input.nextInt();
		try {
			switch (codeId) {
			case 1:
				inBook(user);// ͼ�����
				doStoreMgr(user);// �ٴε��ÿ�ܲ���
				break;
			case 2:
				outBook(user);// ͼ�����
				doStoreMgr(user);// �ٴε��ÿ�ܲ���
				break;
			case 3:
				doStoreMgr(user);// �ٴε��ÿ�ܲ���
				break;
			case 4:
				Book book = inputBookInfo();//¼��ͼ����Ϣ
				user.save(book);// ����ͼ��
				doStoreMgr(user);// �ٴε��ÿ�ܲ���
				break;
			case 5:
				System.out.println("ллʹ�ã�");
				return;
			default:
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("��������ȷ��ʽ������1-5");
			doStoreMgr(user);
		}
	}

	/**
	 * ͼ�����
	 */
	public void inBook(User user) {
		System.out.println("������ͼ����Ϣ");
		try {
			System.out.print("������ͼ��ID��");
			int bookId = input.nextInt();
			System.out.print("����������������");
			int num = input.nextInt();
			user.in(bookId, num);// ���
		} catch (Exception e) {
			System.out.println("��������ȷ��ʽ����Ϣ��ע�⣺ͼ��ID������Ϊ����");
			inBook(user);
		}
	}

	/**
	 * ͼ�����
	 */
	public void outBook(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("������ͼ����Ϣ");
		try {
			System.out.print("������ID��");
			int id = input.nextInt();
			System.out.print("����������������");
			int num = input.nextInt();
			user.out(id, num);// ����
		} catch (Exception e) {
			System.out.println("��������ȷ��ʽ����Ϣ��ע�⣺ͼ��ID������Ϊ����");
			outBook(user);
		}
	}

	/**
	 * ¼��ͼ����Ϣ
	 */
	public Book inputBookInfo() {
		Scanner input = new Scanner(System.in);
		Book book = new Book();
		System.out.print("������ͼ����Ϣ");
		try {
			System.out.print("������������");
			String name = input.next();
			System.out.print("���������ߣ�");
			String author = input.next();
			System.out.print("���������ʱ�䣺");
			String pub_date = input.next();
			System.out.print("������۸�");
			double price = input.nextDouble();
			System.out.print("������������");
			int store = input.nextInt();
			book.setName(name);
			book.setAuthor(author);
			book.setPub_date(pub_date);
			book.setPrice(price);
			book.setStore(store);
		} catch (Exception e) {
			System.out.println("������������ȷ��ʽ����Ϣ��ע�⣺ͼ��ID������Ϊ�������۸�Ϊdouble");
			inputBookInfo();
		}
		return book;
	}

	/**
	 * �˿͵Ĳ���
	 */
	public void doCustomer(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("*****��ӭ����ͼ��ϵͳ*****");
		user.query();// ��ѯͼ��
		System.out.println("��ѡ����еĲ�����1.�鿴ͼ��   2.����   3.�˳�");
		try {
			int code_id = input.nextInt();
			switch (code_id) {
			case 1:
				doCustomer(user);
				break;
			case 2:
				buyBook(user);// �������
				doCustomer(user);
				break;
			case 3:
				System.out.println("лл���٣��ټ���");
				return;
			default:
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("������������ȷ��ʽ������1-3");
			doCustomer(user);
		}
	}

	/**
	 * ����ͼ��
	 * @return ͼ��
	 */
	public void buyBook(User user) {
		Book book = null;
		System.out.println("�������������ͼ����Ϣ:");
		try {
			System.out.print("������ͼ��ID��");
			int id = input.nextInt();
			System.out.print("�����빺��������");
			int num = input.nextInt();
			book = user.buy(id, num);
		} catch (Exception e) {
			System.out.println("������������ȷ��ʽ����Ϣ��ע�⣺ͼ��ID������Ϊ����");
			buyBook(user);
		}
		if (book != null) {
			while (true) {
				try {
					System.out.print("1.CD 27.50Ԫ      2.��װ  2.70Ԫ       3.�ֱ� 10Ԫ     4.����Ҫ\n��������Ҫ����ĸ���Ʒ��");
					int exCode = input.nextInt();
					if (exCode >= 1 && exCode <= 4) {
						EX ex = user.buyEx(exCode);
						book.setEx(ex);
						user.checkout(book);
						return;
					}
					System.out.println("������1-4֮������֣�");
				} catch (Exception e) {
					System.out.println("������������ȷ��ʽ����Ϣ��ע�⣺����ĸ���ƷΪ����");
				}
			}
		}
	}
}
