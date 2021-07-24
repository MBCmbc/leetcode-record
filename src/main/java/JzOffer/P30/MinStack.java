package JzOffer.P30;

/*
同leetcode第155题
大佬解法
https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
除了主栈外，另外维护一个辅助栈，存放压入元素的单调不增序列：只有新元素小于等于minStack栈顶元素，才能入minStack。
            （小于等于中的等于是针对连续两个最小元素入栈的情况）
            出栈时，若主栈和辅助栈的栈顶元素相同，minStack才能出栈。

时间复杂度：O(1)，push()，pop()，top()，min()四个方法均为O(1)。                                     打败50.62%
空间复杂度：最坏情况下，压入的元素就是单调不增的。除主栈外，辅助栈使用额外O(N)空间。                    打败76.9%
*/

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
	private Deque<Integer> xStack;
	private Deque<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		this.xStack = new ArrayDeque<Integer>();
		this.minStack = new ArrayDeque<Integer>();
	}

	public void push(int x) {
		xStack.push(x);
		//若minStack为空，则可直接入栈。
		//若不为空，比较后，若新元素小于等于minStack栈顶，即可入栈。
		if(minStack.size() == 0 || x<=minStack.peek()) minStack.push(x);
	}

	public void pop() {
		//Integer不能用==，要用equals比较
		if(xStack.pop().equals(minStack.peek())) minStack.pop();
	}

	public int top() {
		return xStack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
