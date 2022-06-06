package lv1;

public class RemainderEqualOne {
	public static void main(String[] args) {
		
	}
	
	public static int solution(int n) {
        int answer = 0;
        int divisor = 1;
        while(true) {
        	if(n%divisor==1) {
        		answer=divisor;
        		break;
        	}else {
        		divisor++;
        	}
        }
        return answer;
    }
}
