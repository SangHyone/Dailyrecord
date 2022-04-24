package april20;
import java.util.Scanner;

public class IDEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민번호를 -없이 입력 : ");
		
		String id = sc.nextLine();
		
		sc.close();
		int sum =0;
		
		for(int i=0; i<12;i++) {
			sum +=(id.charAt(i)- '0') * (i%8+2);
		}
		
		sum =(11-sum%11)%10;
		
		System.out.println(id.charAt(12)==sum+'0' ? "맞는번호" : "틀린번호");
	}
}
