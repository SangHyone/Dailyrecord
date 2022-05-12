package lv1;

import java.util.Stack;

public class crane {
	public static void main(String[] args) {
		
	}
	
	public int solution(int[][] board, int[] moves) {
	    int cnt = 0;

	    Stack<Integer> stack = new Stack<>();
	    stack.push(0);

	    for (int move : moves) {
	      for (int i = 0; i < board.length; i++) {
	        if (board[i][move - 1] != 0) {
	          if (stack.peek() == board[i][move - 1]) {
	            stack.pop();
	            cnt += 2;
	          } else {
	           stack.push(board[i][move - 1]);
	          }
	          board[i][move - 1] = 0; 
	          break;
	        }
	      }
	    }
	    return cnt;
	  }
}
