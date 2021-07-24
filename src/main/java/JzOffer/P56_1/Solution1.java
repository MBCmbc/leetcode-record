package JzOffer.P56_1;

/*
自己的愚蠢解法，用一个HashMap记录元素在数组中是否出现了多次，出现多次则标记为false，单次标记为true。

时间复杂度：O(N)，N为数组元素个数。需要遍历数组和哈希表。               打败6.24%
空间复杂度：O(N)，额外的哈希表空间。                                    打败5.22%
*/

import java.util.HashMap;

class Solution1 {
	public int[] singleNumbers(int[] nums) {
		int[] res = new int[2];
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int num : nums){
			if(!map.containsKey(num)){
				map.put(num, true);
			} else{
				map.put(num, false);
			}
		}

		int index = 0;
		for(int key : map.keySet()){
			if(map.get(key)) res[index++] = key;
			if(index == 2) break;
		}

		return res;
	}
}