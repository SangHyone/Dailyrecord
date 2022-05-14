package lv1;

import java.util.Arrays;

public class NotFinishPlayer {
	public static void main(String[] args) {
		
	}
	
	public String solution(String[] participant, String[] completion) { 
		
		Arrays.sort(participant);
		Arrays.sort(completion); 
		
		int i = 0;
		for(i=0;i<completion.length;i++)
			if(!participant[i].equals(completion[i])) break;
		
		return participant[i]; 

	}
}
