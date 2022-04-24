package april20;
import java.util.Random;

public class LottoEx01 {
	public static void main(String[] args) {
		System.out.println(Math.random()); //0~1사이의 난수
		//원하는 범위의난수 발생 : (int)(Math.random()*(최대-최소+1) + 최소
		for(int i=0; i<6; i++) {
			System.out.printf("%3d", (int)(Math.random()*(45-1+1))+1);
		}
		System.out.println();
		
		Random random = new Random();
		System.out.println(random.nextDouble());
		System.out.println(random.nextInt());
		
		for(int i=0; i<6; i++) {
			System.out.printf("%3d",random.nextInt(45-1+1)+1);
		}
		System.out.println();
		
		for(int i=0; i<6; i++) {
			System.out.printf("%5d",random.nextInt(200-101+1)+101);
		}
		System.out.println();
	}
}
