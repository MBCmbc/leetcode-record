package DynamicProgramming.P1262;

/*
2021-3-27,网易笔试第三题。参考大佬题解。动态规划。
https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/solution/kuo-zhan-yi-xia-ba-ti-mu-de-chu-3bian-cheng-chu-kx/
思路：用一个二维数组dp[i][j]，表示在表示长度为i的数组中，选出的和能被j整除的最大和。从左到右遍历nums数组并构造、更新dp数组。
     最终dp[n][0]即为所求。

时间复杂度：O(N*K)，N为nums数组长度，K为3.          打败53.17%
空间复杂度：O(N*K),dp数组的大小。                   打败73.62%
*/

class Solution {
	public int maxSumDivThree(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		return (helper(nums, 3));
	}

	public int helper(int[] nums, int k){
		int n = nums.length;
		int[][] dp = new int[n+1][k];   //二维dp数组，dp[i][j]在表示长度为i的数组中，选出的和能被j整除的最大和。
		//同时也表示一个有限状态机，dp[i][j]中，第二维下标j，就表示余数为j的状态。
		//多的第0行，表示初始，数组长度为0的状态。

		boolean[] flag = new boolean[k];    //在某次大循环过程中，标记某种余数状态是否更新过了。
		for(int i = 1; i <= n; i++){
			int num = nums[i-1];
			for(int j = 0; j < k; j++){
				int sum = dp[i-1][j] + num;
				int rem = sum % k;           //从上一状态j，转移到下一状态rem。
				//和该状态之前的最大和比较，取最大者进行更新。
				//因为本循环的前面一些轮次可能已经更新过rem状态，所以dp[i][rem]也要加入比较。
				dp[i][rem] = Math.max(sum, Math.max(dp[i][rem], dp[i-1][rem]));
				flag[rem] = true;         //标记状态rem已更新。
			}
			for(int j = 0; j < k; j++){
				if(flag[j]) flag[j] = false;  //对某种状态j，如果更新过，就重置为false，以便下一次大循环使用标记数组。
				else dp[i][j] = dp[i-1][j];         //如果没更新过，说明加上nums[i]余数不可能为j，不会引起更新，就继承dp[i-1][j]即可。
			}
		}

		return dp[n][0]; //根据dp数组定义，dp[n][0]表示n个数中，所能选出的模k余0的最大和，也即整除k的最大和。
	}
}
