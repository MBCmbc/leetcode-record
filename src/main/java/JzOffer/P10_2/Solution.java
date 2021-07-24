package JzOffer.P10_2;

/*
实际上就是斐波那契数列求解。剑指offer思路+题解实现动态规划代码。
https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/

时间复杂度：O(N)            打败100%
空间复杂度：O(1)            打败81.4%
*/

class Solution {
	public int numWays(int n) {
		int[] dp = new int[2];
		dp[0] = 1;
		dp[1] = 1;
		int tmp;

		if(n < 2) return 1;

		for(int i=2; i<=n; i++){
			tmp = (dp[0] + dp[1]) % 1000000007;
			dp[0] = dp[1];
			dp[1] = tmp;
		}

		return dp[1];
	}
}
