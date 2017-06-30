package entity;
import java.util.Scanner;
/**
 * 图书类
 */
public class Book extends Resource {
	private String author;//作者
	private int pageCount;//页数
	
	public Book(){
		
	}
	
	public Book(String indexId,String resourceName,String publishTime,boolean state,String author,int pageCount){
		//todo  初始化信息
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * 重写查看详细信息
	 */
	public void printInfo() {
		System.out.println("该图书详细信息如下：");
		System.out.println("索引号\t名称\t出版时间\t\t作者\t页数\t状态");
		String state=this.getState()?"已借出":"可借阅";//判断状态
		System.out.println(this.getIndexId()+"\t"
				+this.getResourceName()+"\t"
				+this.getPublishTime()+"\t"
				+this.getAuthor()+"\t"
				+this.getPageCount()+"\t"
				+state);
	}

	/**
	 * 重写登记资源信息
	 */
	public void enrol() {
		//todo调用父类的登记方法
		Scanner input=new Scanner(System.in);
		System.out.print("请输入作者：");
		String author=input.next();
		this.setAuthor(author);
		System.out.print("请输入页数：");
		int pageCount=input.nextInt();		
		this.setPageCount(pageCount);
	}
}
