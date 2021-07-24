package Stack.P155;

/*
官方题解：辅助栈
思路：用一个辅助的最小栈，主栈每压入一个元素，辅助栈也压入一个代表栈内当前所有元素最小值的元素。对应于主栈中从新压入元素到栈底所有元素中的最小值。
      需要取最小值时，从辅助栈顶取即可。主栈进行入栈出栈操作，辅助栈也进行对应的入栈出栈操作。

时间复杂度：O(1)。对于题目中的所有操作，时间复杂度均为 O(1)。因为栈的插入、删除与读取操作都是 O(1)，我们定义的每个操作最多调用栈操作两次。              打败79.01%
空间复杂度：O(N)。其中 n为总操作数。最坏情况下，我们会连续插入 n个元素，此时两个栈占用的空间为 O(n)。                                                  打败98.69%
*/

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
	//主栈
	Deque<Integer> xStack;
	//辅助栈
	Deque<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		xStack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		xStack.push(x);
		//新元素和当前最小元素比较即可得到最新的“最小元素”
		minStack.push(Math.min(x, minStack.peek()));
	}

	public void pop() {
		//主栈进行出栈操作，辅助栈也做对应操作。
		xStack.pop();
		minStack.pop();
	}

	public int top() {
		return xStack.peek();
	}

	public int getMin() {
		//当前主栈的最小元素即辅助栈的栈顶元素
		return minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
