package JzOffer.P59_2;

/*
参考官方题解，方法二：维护一个单调的双端队列
https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
大体思路同剑指offer P59-1，除本身队列q外维护一个单调递减（不增）的双端队列d，双端队列d队首元素就是当前队列q的最大元素。

时间复杂度：O(1)。 max_value()和pop_front()显然为O(1)。push_back()时，因为每个元素最多出d入d各一次，所以均摊到每次push_back()也就是O(1)。           打败50.12%
空间复杂度：O(N)。需要用队列存储所有插入的元素。                                                                                                    打败65.82%
*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
	Queue<Integer> q;
	Deque<Integer> d;

	public MaxQueue() {
		q = new LinkedList<>();
		d = new LinkedList<>();
	}

	public int max_value() {
		return d.isEmpty() ? -1 : d.peek();     //d和q是否为空是同步的。若为空返回-1，否则返回d队首，即最大值
	}

	public void push_back(int value) {
		while(!d.isEmpty() && d.peekLast() < value) d.pollLast();       //把d队尾所有<value的都出队，保证d单调递减（不增）。

		d.offer(value);
		q.offer(value);
	}

	public int pop_front() {
		if(q.isEmpty()) return -1;

		int ans = q.poll();
		if(ans == d.peek()) d.poll();       //若出队q的队首元素恰好是最大元素，则相应的d队首元素也要出队。

		return ans;
	}
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
