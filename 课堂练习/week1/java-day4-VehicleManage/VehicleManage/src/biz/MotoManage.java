package biz;
import entity.*;

public class MotoManage {
	
	public MotoVehicle motoLeaseOut(String motoType) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> motoClass=Class.forName("entity."+motoType);
		MotoVehicle moto= (MotoVehicle)motoClass.newInstance();
		moto.leaseOutFlow();
		return moto;
	}

}
