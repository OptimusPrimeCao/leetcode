package dynamicProgramming;

import java.util.Stack;


public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		if(s == null)
			return 0;
		char[] chArr = s.toCharArray();
		int max = 0;
		int[] count = new int[s.length()];
		Stack<Integer> ss = new Stack<Integer>();
		
		for(int i = 0; i <s.length(); i++) {
			if(chArr[i] == '(') {
				ss.push(i);
			}
			else {
				if(!ss.isEmpty()) {
					int idx = ss.pop();
					count[i] = i - idx + 1 + (idx > 0 ? count[idx-1] : 0);
					if(count[i] > max)
						max = count[i];
				}
				
			}
				
		}
			
		return max;
		
	}
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(())"));
	}
}
