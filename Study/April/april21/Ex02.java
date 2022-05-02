package april21;

public class Ex02 {
	public static void main(String[] args) {

		int sum = 0;

		int num = 100;
		int count = num;

		for (int i = 1; i <= num; i++) {// 반복횟수
			sum += i * count;
			count--;
		}

		System.out.println(sum);
	}
}
