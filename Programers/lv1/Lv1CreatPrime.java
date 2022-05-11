package lv1;

public class Lv1CreatPrime {
	public int solution(int[] nums) {
		int answer = 0;
		boolean flag = false;

		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i + 1; j < nums.length-1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int num = nums[i] + nums[j] + nums[k];
					if (num >= 2)
						flag = isPrime(num);
					if (flag == true)
						answer++;

				}
			}

		}
		return answer;
	}

	public boolean isPrime(int num) {
		int cnt=0;
		
		for (int i = 1; i <= (int)(Math.sqrt(num)); i++) {
			if (num % i == 0) cnt++;
		}
		return cnt==1;
	}
}
