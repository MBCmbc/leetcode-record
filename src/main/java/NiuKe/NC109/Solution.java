package NiuKe.NC109;

/*
求矩阵中所构成的岛屿数量，dfs。同leetcode P200
*/
public class Solution {
	/**
	 * 判断岛屿数量
	 *
	 * @param grid char字符型二维数组
	 * @return int整型
	 */
	private int res = 0;
	private int rows;
	private int columns;
	private char[][] grid;

	public int solve(char[][] grid) {
		// write code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		this.grid = grid;
		rows = grid.length;
		columns = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == '1') {
					dfs(i, j);
					++res;
				}
			}
		}

		return res;
	}

	public void dfs(int r, int c) {
		if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == '0') return;

		grid[r][c] = '0';
		dfs(r - 1, c);
		dfs(r + 1, c);
		dfs(r, c - 1);
		dfs(r, c + 1);
	}
}