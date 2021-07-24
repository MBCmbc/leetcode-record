package NiuKe.NC73;

import java.util.*;
/*
同leetcode P169,但不太一样，这里还有可能不存在出现次数超过一半的数字，所以只能用哈希。
自己的解法，用哈希表存储各个元素的出现次数。
时间复杂度O(N)
空间复杂度O(N)
*/
public class Solution {
	public int MoreThanHalfNum_Solution(int [] array) {
		if(array == null || array.length == 0) return 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int num : array)map.put(num, map.getOrDefault(num, 0) + 1);

		for(int key : map.keySet()){
			if(map.get(key) > array.length / 2) return key;
		}

		return 0;
	}
}