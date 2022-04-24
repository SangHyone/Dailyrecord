package april21;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort2 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int ar[] = new int[10];
		for (int i = 0; i < ar.length; i++)
			ar[i] = rnd.nextInt(101);
		System.out.println("정렬전 : " + Arrays.toString(ar));
		for (int i = 0; i < ar.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < ar.length - 1 - i; j++) {
				if (ar[j] > ar[j + 1]) {
					int temp = ar[j + 1];
					ar[j + 1] = ar[j];
					ar[j] = temp;
					flag = false;
				}
			}
			if(flag) break;
			System.out.println(i + 1 + "회전 : " + Arrays.toString(ar));
		}
		System.out.println("정렬후 : " + Arrays.toString(ar));
	}
}
