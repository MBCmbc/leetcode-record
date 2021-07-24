package Array.P217;

/*
自己的解法
思路：遍历整个数组，并用一个HashSet存储遍历过的元素。每从数组中拿到一个数字，就和HashSet中元素做对比，如果已经存在，说明重复，返回true
如果遍历完整个数组都没有返回true，说明没有重复元素，返回false。
时间复杂度：一次for循环遍历数组，故为O(N)                                                                  执行用时：打败57.97%
空间复杂度：额外用了一个HashSet存储元素，最坏情况下，数组没有重复元素，需要全部存储进HashSet，故为O(N)。         内存消耗：打败6.98%
*/

import java.util.HashSet;

class Solution1 {
	public boolean containsDuplicate(int[] nums) {
		//HashSet存储不同元素
		HashSet<Integer> set = new HashSet<>();
		//遍历数组，并把数组中元素和HashSet中元素对比
		for(int num : nums){
			//有重复，直接返回true
			if(set.contains(num)) return true;
				//无重复，则把遍历到的元素放进HasshSet，便于与后面遍历到的元素对比
			else set.add(num);
		}

		//遍历完了都没有返回true，说明数组中不存在重复元素，返回false
		return false;
	}
}
