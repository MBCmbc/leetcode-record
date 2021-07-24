package Array.P84;

/*
官方题解，方法二：单调栈 + 常数优化

看得迷迷糊糊的，也不知道它啥意思，就这吧。

时间复杂度：O(N)    打败83.41%
空间复杂度：O(N)    打败71.79%
*/

import java.util.Arrays;
import java.util.Stack;

class Solution {
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);

		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<n; i++){
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
				right[stack.peek()] = i;
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		int ans = 0;
		for(int i=0; i<n; i++){
			ans = Math.max(ans, (right[i]-left[i]-1)*heights[i]);
		}

		return ans;
	}
}
