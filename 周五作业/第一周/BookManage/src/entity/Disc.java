package entity;

import java.util.Scanner;

/**
 * 唱片类
 */
public class Disc extends Resource {
	private String singMan;//演唱人
	private String type;//介质类型（CD或磁带）
	
	public Disc(){}

	public Disc(String indexId, String resourceName, String publishTime, boolean state, String singMan, String type) {
		// finish  初始化数据
		super(indexId, resourceName, publishTime, state);
		this.singMan = singMan;
		this.type = type;
	}

	public String getSingMan() {
		return singMan;
	}

	public void setSingMan(String singMan) {
		this.singMan = singMan;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	/**
	 * 重写查看详细信息
	 */
	public void printInfo() {
		System.out.println("该唱片详细信息如下：");
		System.out.println("索引号\t名称\t出版时间\t\t演唱人\t类型\t状态");
		String state=this.getState()?"已借出":"可借阅";//判断状态
		System.out.println(this.getIndexId()+"\t"
				+this.getResourceName()+"\t"
				+this.getPublishTime()+"\t"
				+this.getSingMan()+"\t"
				+this.getType()+"\t"
				+state);
	}

	/**
	 * 重写登记资源信息
	 */
	public void enrol() {
		// finish 调用父类的登记方法
		super.enrol();
		Scanner input=new Scanner(System.in);
		System.out.print("请输入演唱人：");
		String singMan=input.next();
		this.setSingMan(singMan);
		System.out.print("介质类型(1.CD  2.磁带)：");
		int typeId=input.nextInt();
		if(typeId==1)//根据客户选择登记介质类型
			this.setType("CD");
		else
			this.setType("磁带");	
	}
}
