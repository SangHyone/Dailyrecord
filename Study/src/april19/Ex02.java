package april19;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= 0;
		do {
			System.out.println("1~100사이의 정수 입력 : ");
			n = sc.nextInt();
		}while (n<1 || n>100);
		int i=0;
		for(i = 1; n*i<100 && n*i%10!=0; i++) {
			System.out.printf("%4d", n*i);
			
		}
		if(i*n<100) System.out.printf("%4d\n", n*i);
		
		sc.close();
	}

	
	
	
		
	
}
