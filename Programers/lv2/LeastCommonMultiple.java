package lv2;

public class LeastCommonMultiple {
	
    public int gcd(int a, int b){
    	return b>0 ? gcd(b, a % b) : a;
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1;i<arr.length;i++){
            int gcd = gcd(answer,arr[i]);
            answer = answer * arr[i] / gcd;
        }
        
        return answer;
    }
}
