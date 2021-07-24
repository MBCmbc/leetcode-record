package NiuKe.NC59;

/*
同leetcode P64，最小路径和，动态规划解法。
优化空间复杂度至O(1),直接在原矩阵上修改，不再额外开辟dp矩阵。
*/
public class Solution2 {
	/**
	 *
	 * @param matrix int整型二维数组 the matrix
	 * @return int整型
	 */
	public int minPathSum (int[][] matrix) {
		// write code here
		int m = matrix.length;
		int n = matrix[0].length;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 && j == 0) continue;
				else if(i == 0) matrix[0][j] = matrix[0][j-1] + matrix[0][j];
				else if(j == 0) matrix[i][0] = matrix[i-1][0] + matrix[i][0];
				else matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + matrix[i][j];
			}
		}

		return matrix[m-1][n-1];
	}
}
