package Array.P128;

/*
官方题解：方法一，哈希表

要点：
1. 用HashSet记录数组元素，这样在一可以去重，二可以把寻找匹配元素的时间复杂度将至O(1)
2. 只有当HashSet中不包含x-1时，才对以x开头的序列进行查找，否则就跳过。（因为如果x-1存在，其必然代表更长的连续序列）

时间复杂度：O(N)，外层for循环需要O(N)的时间复杂度，只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，因此数组中的每个数只会进入内层循环一次。根据上述分析可知，总时间复杂度为 O(N)。        打败88%

空间复杂度：O(N)，用哈希表存储了数组元素。      打败92.28%
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int longestConsecutive(int[] nums) {
		int maxLength = 0;

		//创建哈希表存储数组元素
		Set<Integer> numSet = new HashSet<Integer>();
		for(int num : nums){
			numSet.add(num);
		}

		//外循环
		for(int num : numSet){
			//只有HashSet中不包含num-1时，才对以num开头的序列进行搜索匹配
			if(!numSet.contains(num-1)){
				int currentNum = num;
				int currentLength = 1;

				//内循环
				while(numSet.contains(currentNum+1)){
					currentNum += 1;
					currentLength += 1;
				}

				//更新最大长度
				maxLength = Math.max(maxLength, currentLength);
			}
		}

		return maxLength;
	}
}