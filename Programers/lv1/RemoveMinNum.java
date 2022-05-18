package lv1;

public class RemoveMinNum {
	public static void main(String[] args) {
		
	}
	
	 public int[] solution(int[] arr) {
	        int min = arr[0];
	        int[] answer = new int[arr.length - 1];

	        if (arr.length <= 1) {
	           int[] answer2 = { -1 };
	           return answer2;
	         }

	         for (int i = 0; i < arr.length; i++) {
	            if (min > arr[i]) {
	               min = arr[i];
	            }
	         }
	           int index = 0;
	         for (int i = 0; i < arr.length; i++) {
	            if (min == arr[i]) {
	               continue;
	            } else { 
	               answer[index++] = arr[i];
	            }
	         }
	      return answer;
	    }
}
