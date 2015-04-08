package Stack;

import java.util.Stack;
//https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		int length = height.length;
		Stack<Integer> index_stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while(i<length) {
			if(index_stack.isEmpty() || height[index_stack.peek()] <= height[i])
				index_stack.push(i++);
			else {
				int highestIndex = index_stack.pop();
				max = Math.max(max, height[highestIndex] * (index_stack.isEmpty() ? i : i-index_stack.peek()-1));
			}
		}
		while(!index_stack.isEmpty()) {
			int highestIndex = index_stack.pop();
			max = Math.max(max, height[highestIndex] * (index_stack.isEmpty() ? length : length-index_stack.peek()-1));
		}
		return max;
	}
}
