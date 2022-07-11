package lv2;

public class Hanoi {
	public static void main(String[] args) {
		
	}
	
	private int index = 0;
	
	public int[][] solution(int n) {
		int[][] answer = new int[(int)Math.pow(2, n) - 1][2];

		hanoi(n,1, 3, 2, answer);

		return answer;
	}
	
	public void hanoi(int n, int a, int b, int c, int[][] answer){
		if(n == 1)
			answer[index++] = new int[] {a, b};
		else{
			hanoi(n-1, a, c, b, answer);
			answer[index++] = new int[] {a, b};
			hanoi(n-1, c, b, a, answer);
		}
	}
}
