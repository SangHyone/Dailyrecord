package lv1;

import java.util.ArrayList;

public class Lv1HateSameNum {
	public int[] solution(int[] arr) {
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		int t = 50;
		for (int num : arr) {
			if (t != num)
				answerList.add(num);
			t = num;
		}
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i).intValue();
		}
		return answer;
	}
}
