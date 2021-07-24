package JzOffer.P14_1;

/*
剑指offer的动态规划思路，leetcode343题的官方题解方法一代码。
https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
其中关于动态规划递推公式的推导，leetcode官方题解的更好，也更清晰。

时间复杂度：O(n*n),两重for循环                      打败42.84%
空间复杂度：O(N)，dp数组所用空间                    打败70.48%
*/


class Solution1 {
	public int cuttingRope(int n) {
		//0和1都不能拆分，所以dp[0]=dp[1]=0
		int[] dp = new int[n+1];

		for(int i=2; i<=n; i++){
			for(int j=1; j<i; j++){
				//j表示第一段长度，截取第一段后，剩下的一大段，可以不再拆分，也可以拆分，对应max()函数的两个选项。
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}

		return dp[n];
	}
}
