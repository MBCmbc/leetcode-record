package DynamicProgramming.P1277;

/*
官方题解的python代码+自己进行了空间优化：
思路：
	用dp数组表示以该点为右下角，且只包含1的正方形的边长最大值,那么同时它也表示以该点为右下角的正方形的数目
	（即，若值为x，则变长为1,2,...x）的正方形各一个。所有dp数组元素累加即可得到矩阵中正方形的数目。
	关键是得到题解中的状态转移公式，具体可以看一下题解。

空间优化就是只用两个数组（pre代表前一行，now代表本行），而不是二维数组。

时间复杂度：O(MN)       打败86.21%
空间复杂度：O(N)        打败80.67%
*/

class Solution {
	public int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] pre = new int[n];
		int[] now = new int[n];
		int ans = 0;

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//根据状态转移方程写if...else就行。
				if(i==0 || j==0){
					now[j] = matrix[i][j];
				} else if(matrix[i][j] == 0){
					now[j] = 0;
				} else{
					now[j] = Math.min(Math.min(pre[j], now[j-1]), pre[j-1]) + 1;
				}
				ans += now[j];
			}
			//注意pre=now是浅拷贝，不是深拷贝。直接用会得到错误结果。
			System.arraycopy(now, 0, pre, 0, n);
		}
		return ans;
	}
}
