package another;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sort2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		
		for(Integer t : list) {
			sb.append(t).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
