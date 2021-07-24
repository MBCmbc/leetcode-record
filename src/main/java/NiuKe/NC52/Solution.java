package NiuKe.NC52;

import java.util.*;

/*
有效的括号序列。同leetcode P20
*/
public class Solution {
	/**
	 *
	 * @param s string字符串
	 * @return bool布尔型
	 */
	public boolean isValid (String s) {
		// write code here
		Deque<Character> stack = new ArrayDeque<>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c=='(' || c=='[' || c=='{'){
				stack.push(c);
			} else if(c == ')'){
				if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else return false;
			} else if(c == ']'){
				if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
				else return false;
			} else if(c == '}'){
				if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
				else return false;
			}
		}

		return stack.isEmpty();
	}
}
