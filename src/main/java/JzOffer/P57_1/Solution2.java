package JzOffer.P57_1;

/*
自己的解法2，+实现代码。HashSet存储。
用一个HashSet存储之前遍历过的元素，霉变粒到一个元素num，就查看一下set中是否包含target-num，
若有则可以直接返回。没有就把当前num也加入到set中。

时间复杂度：O(N)，遍历一遍数组                                      打败20.26%
空间复杂度：O(N)，最坏情况下，set需要保存几乎所有元素。             打败19.14%
*/

import java.util.HashSet;

class Solution2 {
	public int[] twoSum(int[] nums, int target) {
		HashSet<Integer> set = new HashSet<>();
		for(int num : nums){
			if(set.contains(target - num)) return new int[]{num, target-num};   //找到树对，直接返回
			set.add(num);                              //添加num到set中，以便后面的元素查找。
		}

		return null;        //没找到数对，返回null。
	}
}
