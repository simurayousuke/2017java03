package com.pb.entity;

public class Book {
	private int id;	//���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public EX getEx() {
		return ex;
	}
	public void setEx(EX ex) {
		this.ex = ex;
	}
	private String name;//����
	private String author;//����
	private String pub_date;//����ʱ��
	private int store;//�������
	private double price;//�۸�
	private int num = 1;//��������
	private EX ex;
	public double cost(){
		System.out.println(this.getName()+":"+this.getPrice()+"\n������"+this.getNum());
		System.out.println("С�ƣ�"+this.getPrice()*this.getNum());
		System.out.println("=========================");
		if(ex==null){
			return price;
		}else{
			return price*num+ex.cost();
		}		
	}
}
