package NiuKe.NC59;

/*
同leetcode P64，最小路径和，动态规划解法。
优化空间复杂度至O(N)。
*/
public class Solution1 {
	/**
	 *
	 * @param matrix int整型二维数组 the matrix
	 * @return int整型
	 */
	public int minPathSum (int[][] matrix) {
		// write code here
		int m = matrix.length;
		int n = matrix[0].length;
		int[] dp = new int[n];
		dp[0] = matrix[0][0];
		for(int j = 1; j < n; j++) dp[j] = dp[j-1] + matrix[0][j];

		for(int i = 1; i < m; i++){
			for(int j = 0; j < n; j++){
				if(j == 0) dp[0] = dp[0] + matrix[i][0];
				else dp[j] = Math.min(dp[j], dp[j-1]) + matrix[i][j];
			}
		}

		return dp[n-1];
	}
}
