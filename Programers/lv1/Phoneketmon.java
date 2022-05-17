package lv1;

import java.util.HashSet;

public class Phoneketmon {
	public static void main(String[] args) {

	}

	public static int solution(int[] nums) {
		int answer = nums.length / 2;

		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		if (set.size() > answer) {
			return answer;
		} else {
			return set.size();
		}
	}
}
