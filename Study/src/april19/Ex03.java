package april19;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0, n=0, i=0;
	
		for(i =0; i<20 ; i++) {
			System.out.println("정수를 입력해주세요.");
			n = sc.nextInt();
			result += n;
			if (n==0) break;
			
		}
		if(result==0) {
			System.out.println("0입력해서 끝남");
		}else {
			System.out.println(result/i);
		}
		sc.close();
	}
}
