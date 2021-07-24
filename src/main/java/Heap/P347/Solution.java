package Heap.P347;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
前k个XXXXX元素，仍然是堆（优先队列）的做法，参考官方题解，方法一。
https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
思路：1.首先统计nums数组中各元素出现的次数。
     2.然后用一个优先队列，根据出现次数排序。（求k个最高频的，就定义成最小堆，然后随着遍历，不断小的出来，大的进去）
     3.最后把堆里的这k个返回即可。

时间复杂度：O(N*logK)，N为nums长度，K为k。构造map为O(N)。用堆排序最坏情况下循环N次，每次调整的时间复杂度为O(logK)，所以O(N*logK)。    打败87.43%
空间复杂度：O(N)，哈希表大小最坏为N，堆大小为K，所以O(N)。                                                                       打败30.66%
*/
class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();    //统计nums中各元素出现的次数。
		for(int i : nums){
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		//最小堆，按出现次数排序。
		//数组中，int[0]代表值，int[1]代表出现次数。
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		for(int key : map.keySet()){    //遍历，找出k个最高频的
			int val = map.get(key);
			if(queue.size() == k){  //堆里已满k个，根据堆中最小（堆顶）和当前遍历到的值，决定留哪个。
				if(val > queue.peek()[1]){
					queue.poll();
					queue.offer(new int[]{key, val});
				}
			}else{  //堆里不满k个，直接进堆
				queue.offer(new int[]{key, val});
			}
		}

		int[] res = new int[k];

		for(int i = 0; i < k; i++){     //把堆中剩下的k个最高频元素，放入结果数组。
			res[i] = queue.poll()[0];
		}

		return res;
	}
}