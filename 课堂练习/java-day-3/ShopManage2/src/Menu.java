

import java.util.Scanner;
/**
 *Menu.java
 *菜单类 
 */
public class Menu {
 
    /* 商品信息 */
	public Goods goods[] = new Goods[50];
	/* 会员信息 */
	public Customer customers[] = new Customer[100];
	
	  /**
	   * 传递数据
	   */
	public void setData(Goods[] goods,  Customer[] customers){ //如果不使用this，请把形参名改变即可
		this.goods = goods; 
		this.customers = customers;
	}
	
	
	
	
	/**
	 * 客户信息管理菜单
	 */
	
	public void showCustMMenu() {
		System.out.println("购物管理系统 > 客户信息管理\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 显 示 所 有 客 户 信 息\n");
		System.out.println("\t\t\t\t 2. 添 加 客 户 信 息\n");
		System.out.println("\t\t\t\t 3. 修 改 客 户 信 息\n");
		System.out.println("\t\t\t\t 4. 查 询 客 户 信 息\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		Scanner input = new Scanner(System.in);
	    
		boolean con = true;  //处理如果输入菜单号错误
	    do{
	      CustManagement cm = new CustManagement();
		 cm.setData(goods, customers);
		  String num = input.next();
		  if(num.equals("1")){
			  cm.show();
			  break;
		  }else if(num.equals("2")){
			  cm.add();
			  break;
		  }else if(num.equals("3")){
			  cm.modify();
			  break;
		  }else if(num.equals("4")){
			  cm.search();
			  break;			 
		 
		  }else{
			System.out.println("输入错误, 请重新输入数字：");
			con = false;
		  }
	    }while(!con);
	    input.close();
	}
	
	
}
