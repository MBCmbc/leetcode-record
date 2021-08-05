package DynamicProgramming.P62;

/*
 自己的解法，动态规划。
 思路：用一个二维数组grid[][]表示网格中到达每个点可有的不同路径数。利用动态规划遍历最终得到要到达右下角有多少不同的路径。

 状态转移方程：因为每一步都只能向右或者向下走，所以对于网格的第一行中的元素，只有从左到右一种走法；网格第一列元素同理。
 对于其他普通网格，则路径数=到达左边网格的路径数+到达上边网格的路径数。即，grid[i][j] = grid[i-1][j] + grid[i][j-1]。

 时间复杂度：O(m*n);
 空间复杂度：O(m*n);
*/

class Solution1 {
	public int uniquePaths(int m, int n) {
		//定义二维数组表示网格
		int[][] grid = new int[m][n];

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//第一行或者第一列元素，表格值必定为1.
				if(i==0 || j==0) grid[i][j] =1;
					//状态转移方程，到达当前格的路径数=到达左边格子的路径数+到达上边格子的路径数。
				else grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}

		//返回到达右下角格子的路径数。
		return grid[m-1][n-1];
	}
}
