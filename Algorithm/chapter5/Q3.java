package chapter5;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(getNum(sc.nextInt()));
		
		sc.close();
	}
	
	public static int getNum(int n) {
		
		int cnt=0;
		
		if(n<100) {
			return n;
		}else {
			cnt = 99;
			
			for(int i = 100; i <= n; i++){
				
				int h = i / 100;	
				int t = (i / 10) % 10;	
				int o = i % 10;
	            
				if((h - t) == (t - o)){	
					
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
