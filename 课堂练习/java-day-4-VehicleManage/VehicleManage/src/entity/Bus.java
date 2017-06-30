package entity;

import java.util.Scanner;

public class Bus extends MotoVehicle {

	/**
	 * 
	 */
	int seat;

	/**
	 * @return
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * @param seat
	 */
	public void setSeat(int seat) {
		this.seat = seat;
	}

	/**
	 * 
	 */
	public Bus() {

	}

	/**
	 * @param vehicleID
	 * @param brand
	 * @param perRent
	 * @param seat
	 */
	public Bus(String vehicleID, String brand, int perRent, int seat) {
		super(vehicleID, brand, perRent);
		this.seat = seat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.MotoVehicle#calRent(int)
	 */
	@Override
	public double calRent(int days) {
		double rate = 0;
		if (days < 3) {
			rate = 1;
		} else if (days < 7) {
			rate = 0.9;
		} else if (days < 30) {
			rate = 0.8;
		} else {
			rate = 0.6;
		}
		return this.getPerRent() * rate*days;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.MotoVehicle#leaseOutFlow()
	 */
	@Override
	public void leaseOutFlow() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("1：金杯 \t  2： 金龙");
		System.out.println("请选择你要租赁的客车品牌：");
		int carTypeId = input.nextInt();
		if (carTypeId == 1) {
			this.setBrand("金杯");
		} else if (carTypeId == 2) {
			this.setBrand("金龙");
		} else {
			System.out.println("对不起,没有此类品牌的车");
		}
		System.out.println("请输入客车的座位数");
		int seat=input.nextInt();
		if(seat<=16){
			this.setSeat(16);
			this.setPerRent(800);
			if(carTypeId==1){
				this.setVehicleID("辽B12345");
			}else{
				this.setVehicleID("辽B54321");
			}
		}else{
			this.setSeat(34);
			this.setPerRent(1500);
			if(carTypeId==1){
				this.setVehicleID("辽B21345");
			}else{
				this.setVehicleID("辽B32145");
			}
		}
	}

}
