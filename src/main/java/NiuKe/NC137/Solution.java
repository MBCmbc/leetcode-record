package NiuKe.NC137;

import java.util.*;

/*
同leetcde P224、P227
*/
public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * 返回表达式的值
	 *
	 * @param s string字符串 待计算的表达式
	 * @return int整型
	 */
	public int solve(String s) {
		// write code here
		Deque<Character> queue = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c != ' ') queue.offer(c);
		}

		return dfs(queue);
	}

	private int dfs(Deque<Character> queue) {
		Deque<Integer> stack = new ArrayDeque<>();


		char op = '+';
		int num = 0;
		while (!queue.isEmpty()) {
			char c = queue.poll();
			if (c == '(') num = dfs(queue);
			if (Character.isDigit(c)) num = num * 10 + (c - '0');
			if (!Character.isDigit(c) || queue.isEmpty()) {
				if (op == '+') stack.push(num);
				else if (op == '-') stack.push(-num);
				else if (op == '*') stack.push(stack.pop() * num);
				else if (op == '/') stack.push(stack.pop() / num);

				num = 0;
				op = c;
			}
			if (c == ')') break;
		}

		int res = 0;
		for (int i : stack) res += i;
		return res;
	}
}
