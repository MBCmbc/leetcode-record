package JzOffer.P47;

/*
同leetcode P64，不过一个是求最小，一个是求最大。
最简单的动态规划。
时间复杂度：O(MN)         打败82.66%
空间复杂度：O(MN)         打败99.40%
 */
public class Solution0 {
	public int maxValue(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];       //初始化第一行和第一列
		for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];   //根据从左来或从上来的状态转移方程，更新dp矩阵。
			}
		}

		return dp[m - 1][n - 1];
	}
}

