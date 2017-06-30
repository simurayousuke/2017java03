package Bookbiz;
import java.util.Scanner;
import entity.Resource;

/**
 * 图书资源管理系统类
 */
public class Test {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		CatalogItem catalog=new CatalogItem();//创建资源目录的对象
		System.out.println(">>您目前的位置:资源目录记录");
		System.out.print("1.图书\t2.唱片\n请选择你要记录的资源类型：");
		int choose=input.nextInt();
		String resourceType="";
		if(choose==1){//判断客户选择资源类型
			resourceType="图书";
		}else if(choose==2){
			resourceType="唱片";
		}	
		
		//todo 调用记录资源的方法
		//todo调用资源的详细信息	
		
		
		System.out.println("资源已记录成功！");	
	}
}
