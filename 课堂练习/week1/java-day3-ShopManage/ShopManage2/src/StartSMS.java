public class StartSMS {
      /**
       * 购物管理系统的入口
       *
       */
	  public static void main(String[] args){
    	   /*出始化商场的商品和客户信息*/
           Data initial = new Data();
           initial.ini();
           //
           
           /*进入系统*/
           Menu menu = new Menu();
     	   menu.setData(initial.goods, initial.customers); 
           menu.showCustMMenu();
           
          
      }
}
