package JzOffer.P40;

/*
剑指offer思路2，官方题解方法2，堆。适用于不能修改输入数组的情况（也适用于输入数组较大，无法一次读入，只能一次读一部分的情况，像流一样）
https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/

用一个优先队列（底层使用最大堆实现的），存储k个最小的元素。每遍历一个数组元素，和堆顶元素对比，若更小，则堆顶元素出队列，当前元素入队列。
之后优先队列会自动调整，得到一个排好序的优先队列，无需我们担心。遍历结束之后，队列内的k个元素就是我们要求的。

时间复杂度：O(NlogK)，N为数组长度。最大堆内维护k个元素，插入删除都是O(logK)，最坏情况下N个元素都会经历入堆，所以是O(NlogK)。        打败30.93%
空间复杂度：O(K)，优先队列的大小                                                                                             打败86.64%
*/

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {
	public int[] getLeastNumbers(int[] arr, int k) {
		int[] res = new int[k];
		if(arr == null || k == 0) return res;

		//基于最大堆的优先队列
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer num1, Integer num2){
				return num2 - num1;
			}
		});

		//先往堆内填k个元素
		for(int i = 0; i < k; i++) queue.offer(arr[i]);

		//遍历剩余数组，有比堆顶元素更小的就替换
		for(int i = k; i < arr.length; i++){
			if(queue.peek() > arr[i]){
				queue.poll();
				queue.offer(arr[i]);
			}
		}

		//返回堆内k个元素
		for(int i = 0; i < k; i++) res[i] = queue.poll();
		return res;
	}
}
