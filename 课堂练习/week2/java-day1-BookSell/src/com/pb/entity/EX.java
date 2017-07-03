package com.pb.entity;

public abstract class EX {
  private double price;//价格
  private String ex_name;//附赠品名称
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getEx_name() {
	return ex_name;
}
public void setEx_name(String ex_name) {
	this.ex_name = ex_name;
}
public double cost(){
	System.out.print("附赠品:");
	System.out.println(ex_name+":"+price);
	System.out.println("===================");
	return  price;
}
  
}
