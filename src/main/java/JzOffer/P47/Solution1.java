package JzOffer.P47;

/*
同leetcode P64，不过一个是求最小，一个是求最大。
剑指offer思路，自己实现代码。
动态规划的思想，设f(i,j)表示以坐标(i,j)为终点所能得到的礼物最大价值，因为每一步只能向右或者向左走，则有f(i,j) = max[f(i-1,j),f(i,j-1)]+grid[i][j]
（第一行和第一列需要特殊处理，见代码注释）。

按常规思想，需要设置二维的dp矩阵，存储每一个(i,j)坐标对应的f(i,j)，但这里由于只能向右或向下走，我们可以进行空间优化，用一行的dp数组存储结果。
遍历到gird[i][j]时，dp[]的前j-1个已经修改过，就相当于dp[i][x]，dp[]的后面部分则还没有修改过，相当于dp[i-1][x]，可以进行正常更新。
空间复杂度则由O(MN)优化为O(N)。
更新完最后一行后，dp[]数组的末尾值就相当于dp[m-1][n-1]，即为所求，返回即可。

时间复杂度：O(MN)，M为矩阵行数，N为矩阵列数。遍历了一遍矩阵。                   打败97.78%
空间复杂度：O(N)，dp[]数组占用额外O(N)的空间。                                打败49.09%
*/

class Solution1 {
	public int maxValue(int[][] grid) {
		//gird为null或无内容
		if(grid == null || grid.length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int[] dp = new int[n];

		//对于第一行，由于没有dp[i-1][j]，需要手动初始化一下（从左至右累加即可）。
		dp[0] = grid[0][0];
		for(int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];

		//遍历grid矩阵，更新dp[]数组
		for(int i = 1; i < m; i++){
			for(int j = 0; j <n; j++){
				if(j == 0){
					dp[0] = dp[0] + grid[i][0]; //每一行的起始，只能由上一行的起始位置向下走得到。
				} else{
					//动态规划转移方程
					dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
				}
			}
		}

		return dp[n - 1];   //对应于矩阵右下角所得最大礼物价值
	}
}