package NiuKe.NC59;

/*
同leetcode P64，最小路径和，动态规划解法。
*/
public class Solution {
	/**
	 * @param matrix int整型二维数组 the matrix
	 * @return int整型
	 */
	public int minPathSum(int[][] matrix) {
		// write code here
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = matrix[0][0];
		for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + matrix[0][j];
		for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + matrix[i][0];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + matrix[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
