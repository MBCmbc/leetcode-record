package DynamicProgramming.P198;

/*
官方题解，方法一，动态规划+滚动数组。

思路：
    用dp[i]表示到第i个房间为止(即，假设数组序列到这就结束了)，所能偷到钱财的最大值。
    对于某个房间i，有两种可能：
        1. 偷，则i-1不能偷，故能偷到的最大值为dp[i-2]+nums[i]
        2. 不偷，则相当于数组序列到i-1就停止了(因为i房间就没有存在的意义了，反正不偷它)，则能偷到的最大值为dp[i-1]
    取二者中较大值，即为到房间i为止所能偷到的最大值。故而得到状态转移方程dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1])

    因为dp[i]只与dp[i-2]、dp[i-1]以及nums[i]相关，可以用变量a和b作为滚动数组存储dp[i-2]和dp[i-1]，降低空间复杂度

时间复杂度：O(N)    打败100%
空间复杂度：O(1)    打败67.32%
*/

class Solution {
	public int rob(int[] nums) {
		int n = nums.length;
		//判断边界条件
		if(n==0) return 0;
		if(n==1) return nums[0];
		if(n==2) return Math.max(nums[0], nums[1]);

		//a表示dp[i-2]， b表示dp[i-1]
		int a = nums[0];
		int b = Math.max(nums[0], nums[1]);
		for(int i=2; i<n; i++){
			//根据状态转移公式计算dp[i]，并更新a(dp[i-2])和b(dp[i-1])
			int temp = b;
			//下次循环的dp[i-1]就是本次循环的dp[i]
			b=Math.max(a+nums[i], b);
			//下次循环的dp[i-2]就是本次循环的dp[i-1]
			a=temp;
		}
		//循环结束后，i=n，故b就是dp[n-1]，也就是一路到最后一间房能偷到的最多钱财。
		return b;
	}
}
