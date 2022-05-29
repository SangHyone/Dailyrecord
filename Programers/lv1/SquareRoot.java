package lv1;

public class SquareRoot {
	public static void main(String[] args) {
		
	}
	
	public static long solution(int n) {
		long answer = 0;
        double base = Math.sqrt(n);
        if ( base % 1 > 0 ) {
        	answer = -1;
        }
        else answer = (long) Math.pow(base+1, 2);
        return answer;
	}
}
