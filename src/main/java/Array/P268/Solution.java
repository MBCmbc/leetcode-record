package Array.P268;

/*
自己的解法
思路：根据题意，数组中的数字是不重复的，仅仅缺少0~n的其中一个。
可以推断出：0~n的和，与数组中数字的和，求差。所得结果就是数组中缺少的数字。
时间复杂度：遍历一遍数组求和，故为O(N)；        执行用时：打败100%的用户
空间复杂度：只用了额外常数空间，故为O(1)。      内存消耗：打败6.67%的用户。
*/

class Solution {
	public int missingNumber(int[] nums) {
		//根据数组长度取出n的值
		int n = nums.length;

		//0~n求和的结果，高斯公式
		int sumN = n*(1+n)/2;

		//遍历数组得到数组内元素的和
		int sum = 0;
		for(int i=0; i<n; i++){
			sum += nums[i];
		}

		//求差得到数组中没有出现的那个数，并返回。
		return (sumN - sum);
	}
}
