package JzOffer.P47;

/*
同leetcode P64，不过一个是求最小，一个是求最大。
在Solution1的基础上继续优化至O(1)空间，参考大佬题解。
https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
直接把原grid矩阵当做dp矩阵，原地进行修改，无需开辟额外dp空间，空间复杂度优化为O(1)。

时间复杂度：O(MN)，遍历矩阵。               打败79.18%
空间复杂度：O(1)。                         打败26.41%
*/

class Solution2 {
	public int maxValue(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for(int i = 1; i < n; i++) grid[0][i] = grid[0][i-1] + grid[0][i];  //初始化为dp第一行（只能从左往右走，相当于累加）
		for(int i = 1; i < m; i++) grid[i][0] = grid[i-1][0] + grid[i][0];  //初始化为dp第一列（只能从上往下走，相当于累加）
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){     //矩阵余下部分按状态转移方程进行递推
				grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
			}
		}
		return grid[m-1][n-1];
	}
}
