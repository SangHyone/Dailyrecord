package lv1;

public class StringPY {
	public static void main(String[] args) {
		
	}
	
	public static boolean solution(String s) {
		int cnt = 0;
	    for(char c : s.toUpperCase().toCharArray()){
	      if(c == 'P'){
	        cnt ++;
	      }
	      if(c == 'Y'){
	        cnt --;
	      }
	    }
	 
	    return cnt == 0 ? true : false;
	}
}
