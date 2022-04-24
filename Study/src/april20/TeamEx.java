package april20;
import java.util.Random;

public class TeamEx {
	public static void main(String[] args) {
		int[] emp = new int[40];

		Random rnd = new Random();
		int t;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<10;j++) {
				do {
					t = rnd.nextInt(emp.length);
				}while(emp[t]!=0);
				emp[t] = i;
			}
		}
		for(int i=0; i<4; i++) print(emp, i);

	}

	private static void print(int[] ar, int team) {
		String[] names = " 금성, 목성, 화성, 토성".split(","); //name[] = {금성,목성,화성,토성}
		System.out.print(names[team]+ "팀 : ");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]==team) System.out.printf("%3d", i+1);
				
		}
		System.out.println();
		System.out.println("-".repeat(40));
	}
}
