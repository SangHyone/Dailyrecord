package april25;

import java.util.Arrays;
import java.util.TreeSet;

public class Picktwosum {
	public static void main(String[] args) {

	}

	// 트리셋을 모를때 쓰는것.
	public static int[] solution1(int[] numbers) {
		int[] ar = new int[(numbers.length * (numbers.length - 1)) / 2];
		int cnt = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				ar[cnt++] = numbers[i] + numbers[j];
			}
		}
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[i] == ar[j])
					ar[j] = -1;
			}
		}

		cnt = 0;

		for (int i = 0; i < ar.length - 1; i++)
			if (ar[i] != -1)
				cnt++;

		int result[] = new int[cnt];

		cnt = 0;

		for (int i = 0; i < ar.length - 1; i++)
			if (ar[i] != -1)
				result[cnt++] = ar[i];

		Arrays.sort(result);
		return result;
	}

	// 트리셋 사용했을때
	public static int[] solution2(int[] numbers) {
		TreeSet<Integer> answer = new TreeSet<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				answer.add(numbers[i] + numbers[j]);
			}
		}
		int result[] = new int[answer.size()];
		int i = 0;
		for (Integer t : answer)
			result[i++] = t;
		return result;
	}

}
