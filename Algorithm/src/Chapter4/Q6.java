package Chapter4;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		String ar[] = new String[sc.nextInt()];
 
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.next();
		}
		
		sc.close();
		
		for (int i = 0; i < ar.length; i++) {
			
			int cnt = 0;	
			int sum = 0;	
			
			for (int j = 0; j < ar[i].length(); j++) {
				
				if (ar[i].charAt(j) == 'O') {
					cnt++;
				} 
				else {
					cnt = 0;
				}
				sum += cnt;
			}
			
			System.out.println(sum);
		}
	}
}
