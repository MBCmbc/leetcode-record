package Array.P448;

import java.util.LinkedList;
import java.util.List;

/*
 官方题解：方法二
 思路：数组的值为1~n，索引为0~n-1，可以认为其一一对应。
 第一次遍历数组时，将遍历到的值nums[i]对应的nums[i]-1索引处的值变为负数，相当于一个标记，表示nums[i]出现过。
 第二次遍历时，若某索引处的值nums[i-1]为正，则说明i没有出现过，将i添加到结果中去。

 时间复杂度O(N),空间复杂度O(1)。
 */

class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new LinkedList<>();

		//第一次遍历
		for(int i=0; i<nums.length; i++){
			//根据值1~n以及索引0~n-1的映射，生成新的index。
			//注意：nums[i]要取绝对值，因为有可能已经被标记为负数了。但取绝对值后仍然是原来的值。
			int newIndex = Math.abs(nums[i]) -1;

			//如果nums[newIndex]>0，说明未被标记过，则进行第一次标记
			//相反，如果小于0，则不需要再标记，否则将把负的变成正的。
			if(nums[newIndex] > 0){
				nums[newIndex] *= -1;
			}
		}

		//第二次遍历,以1~n的方式遍历(其实0~n-1是一样的，看个人喜好)
		for(int i=1; i<=nums.length; i++){
			//nums[i-1]>0。说明没被标记过，即i这个值没有出现过，故添加到结果列表
			if(nums[i-1] > 0){
				result.add(i);
			}
		}

		return result;
	}
}
