package Array.P78;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
思路一
在某一个子集中，输入数组的每个元素，都可以有选(1)或不选(0)两个选项，用二进制来抽象地表示某个元素选或不选，可以很好地解决该问题。
比如对于有四个元素的整数数组，就可以用0000~1111这16个二进制数来表示所有的(2^4)个子集。
*/

class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		//用于保存结果并最终返回的集合
		List<List<Integer>> result = new ArrayList<>();

		//假设输入数组nums[]共有n个元素，则子集个数共2^n个。
		for(int i=0; i<(1<<nums.length); i++){
			//用于保存本次循环所代表的子集
			List<Integer> sub = new ArrayList<Integer>();
			//对输入数组中的n个元素位置，从左到右依次和本次大循环所代表的抽象数字(如，0011)对比，如果对应位置的抽象数值为1，就在子集中加入该数字。
			//(但是注意，在草稿本上画的时候是逆序对应的，比如nums[0]对应的是0011的最后一位，即最低位，1；nums[4]对应的是最高位，0)
			for(int j=0; j<nums.length; j++){
				//如果抽象数字i的从左至右第j位(从0开始数)是1，则代表本次大循环所对应的子集中，是有nums[j]这个数的，应该加入到结果子集中。
				//比如j=0时，0011右移0位还是0011，和1(也就是0001)按位与，得到结果为0001(也就是1),所以nums[0]应该加入到子集中。
				if(((i >> j) & 1) == 1) sub.add(nums[j]);
			}

			//本次大循环对应的子集添加到结果集中。
			result.add(sub);
		}

		return result;
	}
}
