package NiuKe.NC76;

import java.util.Stack;

/*
同剑指offer P09
 */
public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()) stack2.push(stack1.pop());
		}

		if(stack2.isEmpty()) return -1;
		return stack2.pop();
	}
}
