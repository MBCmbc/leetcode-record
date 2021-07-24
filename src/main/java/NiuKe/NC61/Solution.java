package NiuKe.NC61;

import java.util.*;

/*
两数之和
用哈希表存储已经遍历过的值，后面每遍历到一个数字就查询哈希表中是否有对应元素相加等于target，
直到找到为止。
 */
public class Solution {
	/**
	 * @param numbers int整型一维数组
	 * @param target  int整型
	 * @return int整型一维数组
	 */
	public int[] twoSum(int[] numbers, int target) {
		// write code here
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				res[0] = map.get(target - numbers[i]) + 1;
				res[1] = i + 1;
				return res;
			}
			map.put(numbers[i], i);
		}

		return res;
	}
}
