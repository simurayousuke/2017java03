package entity;
import java.util.Scanner;

/**
 * 轿车类
 * @author mrx
 *
 */
public class Car extends MotoVehicle {
     private String type;//型号

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
   public Car(){
	   
   }
   public Car(String vehicleID,String brand,int perRent,String type){
	   super(vehicleID,brand,perRent);
	   this.type=type;
   }
	@Override
	public double calRent(int days) {
		 double rate=0;
		 if(days>7){
			 rate=0.9;
		 }else if(days>30){
			 rate=0.8;
		 }else if(days>150){
			 rate=0.7;
		 }else{
			 rate =1;
		 }
		return this.getPerRent()*rate*days;
	}

	@Override
	public void leaseOutFlow() {
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("1：宝马 \t  2： 别克");
		System.out.println("请选择你要租赁的轿车品牌：");
		int  carTypeId=input.nextInt();
		switch(carTypeId){
		case 1:
			this.setBrand("宝马");
			System.out.println("1 550i\t 2.x6");
			System.out.println("请选择你要租赁的轿车型号");
			carTypeId=input.nextInt();
			if(carTypeId==1){
				this.setType("550i");
				this.setPerRent(600);
				this.setVehicleID("京 NY28588");				
			}else if(carTypeId==2){
				this.setType("x6");
				this.setPerRent(800);
				this.setVehicleID("京cNY3284");	
			}else{
				System.out.println("没有此型号的车");
			}			
			break;
		case 2:
			this.setBrand("别克");
			System.out.println("1. 林荫大道\t 2.GL8");
			System.out.println("请选择你要租赁的轿车型号");
			carTypeId=input.nextInt();
			if(carTypeId==1){
				this.setType("林荫大道");
				this.setPerRent(300);
				this.setVehicleID("京 NTT288");				
			}else if(carTypeId==2){
				this.setType("GL8");
				this.setPerRent(600);
				this.setVehicleID("京cNY3299");	
			}else{
				System.out.println("没有此型号的车");
			}			
			break;
			default:
				System.out.println("对不起,没有此类品牌的车");
		}
	}

	
}