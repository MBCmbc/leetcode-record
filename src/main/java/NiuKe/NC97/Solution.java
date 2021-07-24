package NiuKe.NC97;

import java.util.*;

/*
同leetcode P347
出现次数的topK问题，很显然要用堆来做，但是其排序规则，和要排序的内容都略为复杂，要仔细思考。
 */
public class Solution {
	/**
	 * return topK string
	 * @param strings string字符串一维数组 strings
	 * @param k int整型 the k
	 * @return string字符串二维数组
	 */
	public String[][] topKstrings(String[] strings, int k) {
		HashMap<String, Integer> map = new HashMap<>();					//统计各字符串出现的次数
		for (String s : strings) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		//要求出现次数最多的前k个，所以用最小堆。
		//先看二者出现次数是否相同，相同则按逆字典序排序，这样后面构建res时（从后往前填），才能保证最终结果是字典升序。
		//若出现次数不同，则按出现次数排序，出现次数少的排前面，构成最小堆。
		PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2));

		//向容量为k的最小堆插入元素。
		for (String key : map.keySet()) {
			queue.offer(key);
			if (queue.size() > k) queue.poll();
		}

		//根据我们构造的最小堆排序规则，依次取出堆顶元素，并从后往前填充res即可。
		String[][] res = new String[k][2];
		for (int i = k - 1; i >= 0; i--) {
			String poll = queue.poll();
			res[i][0] = poll;
			res[i][1] = String.valueOf(map.get(poll));
		}

		return res;
	}
}
