import java.util.Scanner;

public class Main {
	
	private static void handle1(double grade){
		if(grade==100){
			System.out.println("if:爸爸给他买辆车");
		}else if(grade>=90){
			System.out.println("if:妈妈给他买MP4");
		}else if(grade>=60){
			System.out.println("if:妈妈给他买本参考书");
		}else{
			System.out.println("if:什么都不买");
		}
	}
	
private static void handle2(double grade){
		int g=(int)grade;
		switch(g){
		case 100:
			System.out.println("switch:爸爸给他买辆车");
			break;
		case 99:case 98:case 97:case 96:case 95:case 94:case 93:case 92:case 91:case 90:
			System.out.println("switch:妈妈给他买MP4");
			break;
		case 89:case 88:case 87:case 86:case 85:case 84:case 83:case 82:case 81:case 80:case 79:case 78
		:case 77:case 76:case 75:case 74:case 73:case 72:case 71:case 70:case 69:case 68:case 67:case 66
		:case 65:case 64:case 63:case 62:case 61:case 60:
			System.out.println("switch:妈妈给他买本参考书");
			break;
		default:
			System.out.println("switch:什么都不买");
			break;
		}
	}

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        System.out.println("请输入分数：");
        String grade=input.nextLine();
        double dGrade=Double.parseDouble(grade);
        handle1(dGrade);
        handle2(dGrade);
        input.close();
	}

}
