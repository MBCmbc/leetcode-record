package Array.P560;

/*
官方题解，方法二。
思路：看官方题解吧去，有点复杂。不想写了。

时间复杂度：一次for循环遍历，其中哈希表查询和删除的操作为O(1),故总计为O(N)；            执行用时：打败91.10%
空间复杂度：额外一个哈希表，最坏情况下有n个不同键值，故为O(N)。                         内存消耗：打败74.42%
*/

import java.util.HashMap;
import java.util.Map;

class Solution2 {
	public int subarraySum(int[] nums, int k) {
		//初始化count，pre，以及哈希表
		//未遍历数组前，也可以认为已经出现过一次和(pre)为0.
		int count=0, pre=0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		for(int i=0; i<nums.length; i++){
			//更新pre
			pre += nums[i];
			//如果出现过和为pre-k，就意味着满足等式，把对应次数加到结果上。
			if(map.containsKey(pre-k)){
				count += map.get(pre-k);
			}
			//根据本次计算得到的pre，更新进map，有出现过该pre值就直接加1，没有出现过就置1(0+1)。
			map.put(pre, map.getOrDefault(pre, 0)+1);
		}

		//返回结果
		return count;
	}
}