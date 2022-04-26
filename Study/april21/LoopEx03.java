package april21;

public class LoopEx03 {
	public static void main(String[] args) {
		int cnt =0;
		
		for(int i=2;i<=100;i++) {
			int count = 0 ;
			for(int j=1; j<=i;j++) {
				if(i%j==0) count++;
			}
			if(count==2) {
				System.out.printf("%4d",i);
				if(++cnt%5==0) System.out.println();
			}
		}
	}
}
