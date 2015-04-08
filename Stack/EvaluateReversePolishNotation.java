package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		Stack<String> ss = new Stack<String>();
		for(String s : tokens) {
			if(s.equals("+")) {
				String a = ss.pop();
				String b = ss.pop();
				int result = Integer.parseInt(a) + Integer.parseInt(b);
				String resultStr = Integer.toString(result);
				ss.push(resultStr);
				continue;
			}
			if(s.equals("-")) {
				String a = ss.pop();
				String b = ss.pop();
				int result = Integer.parseInt(b) - Integer.parseInt(a);
				String resultStr = Integer.toString(result);
				ss.push(resultStr);
				continue;
			}
			if(s.equals("*")) {
				String a = ss.pop();
				String b = ss.pop();
				int result = Integer.parseInt(b) * Integer.parseInt(a);
				String resultStr = Integer.toString(result);
				ss.push(resultStr);
				continue;
			}
			if(s.equals("/")) {
				String a = ss.pop();
				String b = ss.pop();
				int result = Integer.parseInt(b) / Integer.parseInt(a);
				String resultStr = Integer.toString(result);
				ss.push(resultStr);
				continue;
			}
			ss.push(s);
		}
		return Integer.parseInt(ss.pop());
	}
	
	
	public static void main(String[] args) {
//		 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//		  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
		String[] test = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(test));
		
		
	}
}
