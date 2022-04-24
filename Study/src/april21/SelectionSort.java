package april21;
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
	public static void main(String[] args) {
		Random rnd = new Random();
		int ar[] = new int[10];
		for(int i=0; i<ar.length; i++) ar[i]= rnd.nextInt(101);
		System.out.println("정렬전 : " + Arrays.toString(ar));
		for(int i=0; i<ar.length-1;i++) {
			int k = i;
			for(int j=i+1;j<ar.length; j++) {
				if(ar[j]<ar[k]) {
					k = j;
				}
			}
			int temp = ar[k];
			ar[k] = ar[i];
			ar[i] = temp;
			System.out.println(i+1 + "회전 : " + Arrays.toString(ar));
		}
		System.out.println("정렬후 : " + Arrays.toString(ar));
	}
}
