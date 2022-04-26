package april21;

public class LoopEx01 {
	public static void main(String[] args) {
		int sum = 0, i = 1;
		while (i <= 100) {
			sum += i;
			i++;
		}
		System.out.println("1~100까지의 합 : " + sum);

		sum = i = 0;
		while (i < 100)
			sum += ++i;
		System.out.println("1~100까지의 합 : " + sum);

		for (sum = 0, i = 1; i <= 100; sum += i++)
			;

	}
}
