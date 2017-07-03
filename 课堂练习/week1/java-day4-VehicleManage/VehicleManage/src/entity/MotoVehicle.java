package entity;

//import java.util.Scanner;

/**
 * @author zhuang
 *
 */
public abstract class MotoVehicle {

	/**
	 * 
	 */
	/**
	 * 
	 */
	private String vehicleID;
	/**
	 * 
	 */
	private String brand;
	/**
	 * 
	 */
	private int perRent;

	/**
	 * @return
	 */
	public String getVehicleID() {
		return vehicleID;
	}

	/**
	 * @param vehicleID
	 */
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}


	/**
	 * @return
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return
	 */
	public int getPerRent() {
		return perRent;
	}

	/**
	 * @param perRent
	 */
	public void setPerRent(int perRent) {
		this.perRent = perRent;
	}

	/**
	 * 
	 */
	public MotoVehicle(){

	}

	/**
	 * @param vehicleID
	 * @param brand
	 * @param perRent
	 */
	public MotoVehicle(String vehicleID, String brand, int perRent) {
		this.vehicleID = vehicleID;
		this.brand = brand;
		this.perRent = perRent;
	}

	/**
	 * @param days
	 * @return
	 */
	public abstract double calRent(int days);
	/**
	 * 
	 */
	public abstract void leaseOutFlow();

}
