package lv1;

import java.util.Arrays;

public class Lotto {
	public static void main(String[] args) {

	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int cnt = 0;
		int zeroCnt = 0;

		Arrays.sort(lottos);
		Arrays.sort(win_nums);

		for (int lotto : lottos) {
			if (lotto == 0) {
				zeroCnt++;
				continue;
			}
			for (int win_num : win_nums) {
				if (win_num == lotto) {
					cnt++;
					break;
				}
			}
		}

		return new int[] { 7 - Math.max(cnt + zeroCnt, 1), 7 - Math.max(cnt, 1) };

	}
}
