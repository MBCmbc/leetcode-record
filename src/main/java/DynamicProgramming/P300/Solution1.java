package DynamicProgramming.P300;

/*
自己的解法

思路：动态规划，用dp[i]表示以nums[i]为结尾的最长升上子序列，则可以得到状态转移方程为：
        dp[i] = MAX(dp[j]) + 1
     其中j表示在nums[i]之前，且满足nums[j]<nums[i]的所有数的下标。

     在所有的dp[i]中取最大值，即为所求。

时间复杂度：O(N*N)，两重循环                打败43.63%
空间复杂度：O(N)，额外开辟了dp[]数组        打败93.58%
*/


import java.util.Arrays;

class Solution1 {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		//数组为空，返回0
		if(len == 0) return 0;
		int[] dp = new int[len];
		//数组中的每个数都可以都可以看做以自己为起点，且以自己为终点的一个上升子序列，所以dp[]初始化为全1
		Arrays.fill(dp, 1);
		//存储结果的变量，至少为1.
		int result = 1;

		//遍历填充dp[]
		for(int i=1; i<len; i++){
			//遍历nums[i]之前的所有数
			for(int j=0; j<i; j++){
				//若满足nums[j]<nums[i]，则可以认为在以nums[j]为结尾的最长上升子序列后面再加上nums[i]，形成长度+1的上升子序列
				//在当前存储的dp[i]与dp[j]+1中取较大者作为新的dp[i]，遍历完j之后，就得到正确的dp[i]。
				if(nums[j] < nums[i]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			//每填充完一次dp[i]，就比较一下dp[i]和当前result，取较大者作为新的result，这样在外循环结束后，正确的result也就得到了。
			result = Math.max(result, dp[i]);
		}

		return result;
	}
}
