package lv1;

public class XandN {
	public static void main(String[] args) {
		System.out.println(solution(2, 5));
	}
	
	 public static long[] solution(int x, int n) {
	        long[] answer = new long[n-1];
	        for(int i=0;i<=answer.length;i++){
	            answer[i] = x+x*i;
	        }
	        return answer;
	    }
}
