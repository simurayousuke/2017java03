package biz;
import entity.*;
public class MotoVehicleManage {
	/**
	 * 租赁汽车业务
	 * @param motoType 汽车类型
	 * @return 汽车对象
	 */
 public MotoVehicle motoLeaseOut(String motoType){
	 MotoVehicle  moto=null;
	 if(motoType.equals("轿车")){
		 moto=new Car();
		 moto.leaseOutFlow();
	 }else if(motoType.equals("客车")){
		 moto=new Bus();
		 moto.leaseOutFlow();
	 }
	 return moto;
 }
}