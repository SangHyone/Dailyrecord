package april21;

public class LoopEx02 {
	public static void main(String[] args) {
		for(int i = 2; i<=100 ; i++ ) {
			int count =0;
			System.out.print(i+ "의 약수 : " );
			
			for(int j=1; j<=i;j++) {
				if(i%j==0) {
					count++;
					System.out.printf("%4d", j);
				}
			}
			System.out.println(" : " + count +"개 : " + (count==2 ? "소수" : "합성수"));
		}
	}
}
