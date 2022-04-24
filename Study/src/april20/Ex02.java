package april20;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수입력");
		int n = sc.nextInt();

		sc.close();
		int f = 0, s = 1;

		while (f < n) {
			System.out.printf("%5d", f);
			
			s += f ;
			f = s-f;
		}

	}
}
