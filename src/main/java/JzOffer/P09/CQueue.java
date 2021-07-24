package JzOffer.P09;

/*
剑指Ofefer思路，官方题解做法。
https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
    队列是先进先出，栈是先进后出。用两个栈，一串数据进了一个栈后，再依次出栈进另一个栈，相当于经过两次反转，实现先进先出的效果。

时间复杂度：插入和删除均为O(1)。插入显然。对于删除，其实每个元素至多[被插入和弹出stack2一次]，均摊下来每个元素被删除的时间复杂度为O(1)。    打败82.24%
空间复杂度：O(N)，使用了两个栈。                                                                                                  打败95.35%
*/

import java.util.ArrayDeque;
import java.util.Deque;

class CQueue {
	private Deque<Integer> stack1;
	private Deque<Integer> stack2;

	public CQueue() {
		stack1 = new ArrayDeque<>();
		stack2 = new ArrayDeque<>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		//注意，必须等stack2为空之后才能把stack1内的元素转移过来，否则会打乱“先进先出”的效果
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}

		if(stack2.isEmpty()){
			return -1;
		}else{
			return stack2.pop();
		}
	}
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
