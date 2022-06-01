package lv1;

import java.util.Arrays;
import java.util.Collections;

public class StringAsec {
	public static void main(String[] args) {
		
	}
	
	public static String solution(String s) {
		Character [] ar = new Character[s.length()];
		for(int i=0; i<s.length(); i++) {
			ar[i] = s.charAt(i);
		}
		Arrays.sort(ar,Collections.reverseOrder());
		s = "";
		for(int i=0; i<ar.length;i++) {
			s+=ar[i];
		}
		return s;
	}
}
