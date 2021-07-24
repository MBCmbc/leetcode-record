package Heap.P295;

/*
同剑指offer P41
剑指offer思路，+参考大佬代码
https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
要求中位数，只需知道数组左半边的最大值和右半边的最小值(左右个数差最多为1)，而无需将其全部排序。
因此可以用（元素个数至多差1）的最大堆和最小堆来代表（排序）数组的左半边和右半边。取出边界元素便可直到中位数。

时间复杂度：addNum()：O(logN)，堆的插入和删除时间复杂度均为O(logN)
           findMedian()：O(1)，直接取堆顶元素即可（堆的底层由数组实现，堆顶即为0下标处的元素）。                    打败72.5%

空间复杂度：O(N)，N为数据流中元素总个数，两个堆加起来共存储了这N个元素                                              打败80.3%
*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
	private Queue<Integer> leftHeap, rightHeap;

	/** initialize your data structure here. */
	public MedianFinder() {
		//左半部分，用最大堆实现
		this.leftHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer num1, Integer num2){
				return num2 - num1;
			}
		});

		this.rightHeap = new PriorityQueue<Integer>();  //右半部分，用最小堆实现
	}

	public void addNum(int num) {
		//计算中位数必须保证左右两边元素个数至多差1。这里采用：元素为奇时左半部分多一个，为偶时两边个数相等。
		if(leftHeap.size() == rightHeap.size()){
			//两边相等，目前为偶，故新元素添加到左边。但要先入右堆，再取右堆顶元素入左堆，才能保证左堆元素都<=右堆
			rightHeap.offer(num);
			leftHeap.offer(rightHeap.poll());
		} else{
			//两边不等，目前为奇，根据我们的规则，必定是左边多一个，所以选择入右堆。同理，先入左堆，再取左堆顶元素入右堆。
			leftHeap.offer(num);
			rightHeap.offer(leftHeap.poll());
		}
	}

	public double findMedian() {
		if(leftHeap.size() == rightHeap.size()){
			return (leftHeap.peek() + rightHeap.peek()) / 2.0;      //偶数个元素，取两堆顶元素的平均
		} else{
			return leftHeap.peek();     //奇数个，必定是左堆多一个，取左堆顶元素。
		}
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
