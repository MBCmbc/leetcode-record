package JzOffer.P10_1;

/*
动态规划+自下而上的循环实现代码，去除大量的重复计算。
剑指offer思路+题解代码实现。
https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/mian-shi-ti-10-i-fei-bo-na-qi-shu-lie-dong-tai-gui/

题目已经给出了动态规划的状态转移方程，拿来用就可以。


时间复杂度：O(N)，for循环                  打败100%
空间复杂度：O(1)                          打败91.78%
*/

class Solution {
	public int fib(int n) {
		int[] dp = new int[2];
		dp[0] = 0;
		dp[1] = 1;

		if(n == 0) return dp[0];
		if(n == 1) return dp[1];

		int tmp;
		for(int i=2; i<=n; i++){
			//注意每次循环的计算都要取余，不然会溢出。
			tmp = (dp[0] + dp[1]) % 1000000007;
			dp[0] = dp[1];
			dp[1] = tmp;
		}

		return dp[1];
	}
}
