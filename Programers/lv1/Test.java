package lv1;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {

	}

	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int score1 = 0, score2 = 0, score3 = 0;

		for (int i = 0; i < answers.length; i++) {
			if (person1[i % person1.length] == answers[i])
				score1++;
			if (person2[i % person2.length] == answers[i])
				score2++;
			if (person3[i % person3.length] == answers[i])
				score3++;
		}
		int max = Math.max(Math.max(score1, score2), score3);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (max == score1)
			list.add(1);
		if (max == score2)
			list.add(2);
		if (max == score3)
			list.add(3);

		answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
