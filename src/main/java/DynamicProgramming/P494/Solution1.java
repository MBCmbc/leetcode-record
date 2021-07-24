package DynamicProgramming.P494;

/*
官方题解，方法一：枚举
思路：使用递归枚举出所有的情况，当处理到nums[i]时，可以选择加上它或者减去它，递归搜索这两种情况。当处理到最后一个数时，判断一下和是否为S。

时间复杂度：O(2^N)                      打败32.67%
空间复杂度：O(N)，递归使用的栈空间        打败84.86%
*/

class Solution1 {
	//存储结果。
	int count = 0;
	public int findTargetSumWays(int[] nums, int S) {
		calculate(nums, 0, 0, S);
		return count;
	}

	public void calculate(int[] nums, int i, int sum, int S){
		//sum表示到本次递归调用开始前的和
		//i代表层数，i==nums.length说明已经计算完了某一种情况下的所有数和，判断一下是否为S即可。
		if(i == nums.length){
			if(sum == S) count++;
		} else{
			//未计算到数组末尾，继续递归计算。
			calculate(nums, i+1, sum+nums[i], S);
			calculate(nums, i+1, sum-nums[i], S);
		}
	}
}
