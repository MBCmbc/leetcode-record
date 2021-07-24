package Array.P48;

/*
官方题解，方法一。
思路：先转置然后翻转每一行。
时间复杂度：两层的for循环，故时间复杂度O(N^2);
空间复杂度：直接在输入矩阵上做的矩阵转置和行翻转操作，只用了常数量级的额外空间，故空间复杂度O(1)。
*/

class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		//转置矩阵
		for(int i=0; i<n; i++){
			//转置时，对角线元素不变，所以从i+1开始即可。
			for(int j=i+1; j<n; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		//翻转每一行
		for(int i=0; i<n; i++){
			for(int j=0; j<n/2; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n-1-j];
				matrix[i][n-1-j] = tmp;
			}
		}
	}
}
