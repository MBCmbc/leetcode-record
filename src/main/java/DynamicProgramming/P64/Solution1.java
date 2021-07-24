package DynamicProgramming.P64;

/*
同剑指offer P47，不过一个是求最小，一个是求最大。
在第一版的基础上，优化空间复杂度至O(N)。
时间复杂度：O(MN)         打败97.98%
空间复杂度：O(N)         打败99.21%
 */
public class Solution1 {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];       //初始化第一行，只能往右走

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(j == 0) dp[0] = dp[0] + grid[i][0];      //第一列，只能从上往下。
				else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];   //根据从左来或从上来的状态转移方程，更新dp矩阵。
			}
		}

		return dp[n - 1];
	}
}
