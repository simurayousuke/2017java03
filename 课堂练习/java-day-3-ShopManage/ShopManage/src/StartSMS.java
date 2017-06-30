

import java.util.*;

public class StartSMS {
      /**
       * 购物管理系统的入口
       *
       */
	  public static void main(String[] args){
    	  Manager manager=new Manager();
    	  Menu menu=new Menu();
    	  menu.showLoginMenu();
           /*菜单选择*/
           boolean con = true;
           Scanner input = new Scanner(System.in);
           while(con){
             int choice = input.nextInt();
             VerifyEqual pv = new VerifyEqual();
             switch(choice){
               case 1: 
            	  /*密码验证*/
            	  //完成登陆，如果成功，提示登录成功，不成功则提示登陆失败
            	   System.out.println("请输入用户名、密码");
            	   if(pv.verify(input.next(), input.next())){
            		   System.out.println("登录成功");
            	   }else{
            		   System.out.println("登录失败");
            	   }
            	  break;
               case 2: 
            	  if(pv.verify(manager.username, manager.password)){
            		  System.out.print("请输入新的用户名：");
            		  String name = input.next();
            		  System.out.print("请输入新的密码：");
            		  String pwd = input.next();
            		
            		  System.out.print("请再次输入新的密码：");
            		  String repwd = input.next();
            		  if(pwd.equals(repwd)){
            			  manager.username = name;
            			  manager.password = pwd;
            			  System.out.println("用户名和密码已更改！");  
            		  }
            		  else{
            			  System.out.println("两次密码不一致。");
            		  }
            			  
            		  System.out.println("\n请选择，输入数字：");
            	  }else{
            		  System.out.println("抱歉，你没有权限修改！");
            		  con = false;
            	  }
            	  break;
               case  3: 
            	  System.out.println("谢谢您的使用！");
            	  con = false;
            	  break;
               default: 
            	  System.out.print("\n输入有误！请重新选择，输入数字: ");
             }
             if(!con){
            	 break;
             }
           }
          input.close();
      }
}
