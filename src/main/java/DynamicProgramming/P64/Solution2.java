package DynamicProgramming.P64;

/*
同剑指offer P47，不过一个是求最小，一个是求最大。
走到每一个格子，只能从上面下来，或者左面过来，据此形成状态转移方程，取最小即可。
在第二版的基础上，优化空间复杂度至O(1)，直接把原矩阵当做DP矩阵，进行修改。
时间复杂度：O(MN)         打败97.98%
空间复杂度：O(1)         打败99.21%
 */
public class Solution2 {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int j = 1; j < n; j++) grid[0][j] = grid[0][j-1] + grid[0][j];       //初始化第一行，只能往右走
		for (int i = 1; i < m; i++) grid[i][0] = grid[i-1][0] + grid[i][0];       //初始化第一列，只能往下走

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];   //根据从左来或从上来的状态转移方程，更新dp矩阵。
			}
		}

		return grid[m-1][n - 1];
	}
}
