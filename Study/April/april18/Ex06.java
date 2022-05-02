package april18;
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		int c[] = {100_0000, 10_0000, 5_0000,10000,5000,1000,500,100,50,10,5,1};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월급이 얼마니?");
		int m = sc.nextInt();
//		System.out.println("백만원권 : "+ m/100_0000);
//		m %= 100_0000;
//		System.out.println("십만원권 : "+ m/10_0000);
//		m %= 10_0000;
//		System.out.println("오만원권 : "+ m/5_0000);
//		m %=5_0000;
		for(int i = 0; i<c.length; i++) {
			System.out.printf("%10d원권 : %3d매\n",c[i], m/c[i]);
			m%=c[i];
		}
		sc.close();
	}
}
