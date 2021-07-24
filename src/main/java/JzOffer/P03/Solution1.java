package JzOffer.P03;

import java.util.HashSet;

/*
思路一：leetcode官方题解
遍历数组的同时，用一个哈希表存储遍历过的元素。若遍历到某个元素发现哈希表中已存在该元素，说明有重复的。

时间复杂度：O(N)，最坏情况下，所有元素都不相同，需要遍历整个数组			打败28.11%
空间复杂度：O(N)，最坏情况下，所有元素都不相同，哈希表大小为N				打败35.02%
 */
public class Solution1 {
	public int findRepeatNumber(int[] nums) {
		int repeat = -1;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++){
			if (set.contains(nums[i])) {
				repeat = nums[i];
				break;
			}
			set.add(nums[i]);
		}

		return repeat;
	}
}
