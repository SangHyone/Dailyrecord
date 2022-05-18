package lv1;

public class GetAvg {
	public static void main(String[] args) {
		
	}
	
	class Solution {
	    public double solution(int[] arr) {
	        double answer = 0;
	        for(int i = 0; i<arr.length; i++){
	            answer+=arr[i];
	        }
	        answer/=arr.length;
	        return answer;
	    }
	}
}
