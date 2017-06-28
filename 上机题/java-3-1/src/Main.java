
public class Main {

	public static void main(String[] args) {
		final int nums=10;
		final int max=250;
		int i=0;
		System.out.printf("摄氏温度\t华氏温度\n");
		do{
			System.out.printf("%d\t%d\n", i*20,(int)(i*20* 9 / 5.0 + 32));
			++i;
		}while(i<nums&&i*20<max);
	}

}
