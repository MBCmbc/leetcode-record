package JzOffer.P59_1;

/*
同leetcode P239
剑指offer思路，参考大佬题解。（说实话没怎么看懂）
https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
关键是维护一个单调递减的双端队列，每次在窗口内找最大值时，只需把队首元素取出即可。

时间复杂度：O(N)，N为数组长度。遍历一次数组O(N)，且每个元素最多入队出队各一次，为O(N)。            打败71.39%
空间复杂度：O(k)，双端队列queue最多同时存储一个窗口内的k个元素。                                    打败43.44%
*/

import java.util.Deque;
import java.util.LinkedList;

class Solution2 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0) return nums;   //特殊输入提前返回
		Deque<Integer> queue = new LinkedList<>();		//双端队列，存储的是元素在nums内的下标，这样容易判断是否在窗口内
		int[] res = new int[nums.length - k + 1];

		for(int i = 0; i < nums.length; i++){   //i可以认为是即将入窗口的元素下标，也就是本轮循环中，窗口最后一个元素的下标。
			while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]) queue.pollLast();  // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
			queue.offerLast(i);       //当前元素入队
			if(queue.getFirst() < i - k + 1) queue.pollFirst();      //队首元素不在窗口内，出队列。在初期未形成窗口时（元素不足k个），此条语句不会进入。后面窗口开始移动时才起作用。

			if(i+1 >= k) res[i+1-k] = nums[queue.getFirst()];   //窗口最大值放入结果数组。在初期未形成窗口时（元素不足k个），if始终为false，后面窗口形成才为true，进入向结果数组添加元素。
		}

		return res;
	}
}
