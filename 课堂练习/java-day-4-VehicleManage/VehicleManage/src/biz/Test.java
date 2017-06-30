package biz;
import biz.MotoManage;
import java.util.Scanner;
import entity.MotoVehicle;
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
       Scanner input=new Scanner(System.in);
       MotoManage motoMgn=new MotoManage();
       MotoVehicle moto=null;
       System.out.println("欢迎光临本汽车租赁公司");
       System.out.println("1、轿车 \t2、客车"); 
       System.out.println("请选择你要租赁的汽车类型");
       int choose=input.nextInt();
       String motoType="";
       if(choose==1){
    	   motoType="Car";
       }else if(choose==2){
    	   motoType="Bus";
       }
       moto=motoMgn.motoLeaseOut(motoType);
       System.out.println("请输入你要租赁的天数");
       int days=input.nextInt();
       double money=moto.calRent(days);
       System.out.println("分配给你的车牌号是:"+moto.getVehicleID());
       System.out.println("你需要支付的租赁费用："+money);
       input.close();
	}

}