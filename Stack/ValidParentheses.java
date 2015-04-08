package Stack;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		if(s == null)
			return false;
		int chLength = s.length();
		char[] chArr = s.toCharArray();
		Stack<Character> index_stack = new Stack<Character>();
		int i;
		for(i=0; i<chLength; i++) {
			if(chArr[i] == '(' || chArr[i] == '{' || chArr[i] == '[') {
				index_stack.push(chArr[i]);
			}
			else {
				if(index_stack.isEmpty()) {
					return false;
				}
				else {
					char left = index_stack.pop();
					if(chArr[i] == ')' && left == '(')
						continue;
					if(chArr[i] == '}' && left == '{')
						continue;
					if(chArr[i] == ']' && left == '[')
						continue;
		
					return false;
				}
			}
		}
		if(i == chLength && index_stack.isEmpty())
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
}
