package entity;
import java.util.Scanner;

/**
 * 资源
 */
public abstract class Resource {
	private String indexId;//索引号
	private String resourceName;//名称
	private String publishTime;//出版时间
	private boolean state;//资源状态
	public abstract void printInfo();//查看资源详细信息

	public Resource(){
		
	}
	
	public Resource(String indexId,String resourceName,String publishTime,boolean state){
		this.indexId=indexId;
		this.resourceName=resourceName;
		this.publishTime=publishTime;
		this.state=state;
	}
	
	/**
	 * 登记资源信息
	 */
	public void enrol(){
		Scanner input=new Scanner(System.in);
		System.out.print("请输入索引号:");
		String indexId=input.next();
		this.setIndexId(indexId);
		System.out.print("请输入名称:");
		String resourceName=input.next();
		this.setResourceName(resourceName);
		System.out.print("请输入出版时间(yyyy-MM-dd):");
		String publishTime=input.next();
		this.setPublishTime(publishTime);
	}
	
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
