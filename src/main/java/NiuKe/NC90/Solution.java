package NiuKe.NC90;

import java.util.*;

/*
设计getMin功能的栈，同 leetcode P155。
自己实现了。
 */
public class Solution {
	/**
	 * return a array which include all ans for op3
	 * @param op int整型二维数组 operator
	 * @return int整型一维数组
	 */
	public int[] getMinStack (int[][] op) {
		// write code here
		ArrayList<Integer> tmp = new ArrayList<>();
		MinStack minStack = new MinStack();
		for(int i = 0; i < op.length; i++){
			if(op[i][0] == 1) minStack.push(op[i][1]);
			else if(op[i][0] == 2) minStack.pop();
			else if(op[i][0] == 3) tmp.add(minStack.getMin());
		}

		int[] res = new int[tmp.size()];
		for(int i = 0; i < tmp.size(); i++) res[i] = tmp.get(i);
		return res;

	}
}

class MinStack{
	private Deque<Integer> stack;
	private Deque<Integer> min;

	public MinStack(){
		stack = new ArrayDeque<>();
		min = new ArrayDeque<>();
	}

	public void push(int num){
		stack.push(num);
		if(min.size() == 0 || num < min.peek()) min.push(num);
		else min.push(min.peek());
	}

	public int pop(){
		if(stack.size() == 0) return Integer.MAX_VALUE;
		int res = stack.peek();
		stack.pop();
		min.pop();
		return res;
	}

	public int getMin(){
		return min.peek();
	}
}
