package DynamicProgramming.P221;

/*
官方题解：根据P1277得到的状态转移方程进行计算。思路完全一样，只是这里最后需要的是最大值，而P1277需要的是总和。
用dp数组表示以改点为右下角，且只包含1的正方形的边长最大值。

注意：
    1. 这里的输入矩阵为char类型的，而非int类型，注意转换；
    2. 这里的数组可能是空的，注意特殊情况。

时间复杂度：O(MN)       打败85.65%
空间复杂度：O(N)        打败5.05%
*/

class Solution {
	public int maximalSquare(char[][] matrix) {
		//输入矩阵为空的情况
		if(matrix == null || matrix.length==0 || matrix[0].length==0) return 0;

		int m = matrix.length;
		int n = matrix[0].length;
		//最大边长
		int maxSide = 0;
		int[] pre = new int[n];
		int[] now = new int[n];

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				//处于第一行或第一列的边界条件
				if(i==0 || j==0){
					now[j] = matrix[i][j] - '0';
				} else if(matrix[i][j] == '0'){
					now[j] = 0;
				} else{
					now[j] = Math.min(Math.min(pre[j-1], pre[j]), now[j-1]) + 1;
				}
				maxSide = Math.max(maxSide, now[j]);
			}
			//注意要用深拷贝，直接pre=now是浅拷贝，会得到错误结果。
			System.arraycopy(now, 0, pre, 0, n);
		}
		return maxSide*maxSide;
	}
}
