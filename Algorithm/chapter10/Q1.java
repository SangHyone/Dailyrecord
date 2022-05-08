package chapter10;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] ar = new int[N];
		
		for(int i=0;i<N;i++) {
			ar[i] = sc.nextInt();
		}
		
		sc.close();
		
		int answer = getAnswer(ar,N,M);
		
		System.out.println(answer);
		
	}
	
	public static int getAnswer(int[] ar, int N, int M) {
		int answer = 0;
		
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++	) {
					int t = ar[i] + ar[j] + ar[k];
					
					if(M == t) {
						answer = t;
						break;
					}else if(answer < t && t<M) {
						answer = t;
					}
					
					
					
				}
			}
		}
		return answer;
	}
}
