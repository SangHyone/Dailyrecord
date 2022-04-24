package april18;
import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1, len , temp; 
		int j = 0;
		while(n!=0) {
			System.out.println("정수 입력 : ");
			n = sc.nextInt();
			if(n==0) continue;
			len = 1;
			temp= n;
			
			while(temp>=10) {
				len *=10;
				temp /= 10;
				System.out.println("len 의 자릿수의 값은: "+ len + ","+ j);
			}
			System.out.println("자릿수 : " + len);
			int rev = 0;
			temp= n;
			while(temp>0) {
				rev+=temp%10 * len;
				temp /=10;
				len /= 10;
			}
			System.out.println(n+ " : " + rev);
		}
		sc.close();
	}
}
