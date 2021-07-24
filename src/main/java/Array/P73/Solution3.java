package Array.P73;

/*
官方题解，方法三
思路：用第一列和第一行分别扮演两个HashSet的角色，如果某元素为0，就将对应的行头和列头元素置0，作为标记，在第二次遍历的时候，将标记的行和列置0。
另外，由于第一行和第一列的特殊性，需要额外对待，产生了一些细节性的问题：
    1.用matrix[0][0]作为第一行的标记，额外声明一个变量“isCo1”作为第一列的标记；
    2.为了避免第一列数据判定时对matrix[0][0]的影响，第一次遍历时对第一列的数据要额外对待。
具体看代码及注释。

时间复杂度：O(MN)           执行用时：打败100%
空间复杂度：O(1)            内存消耗：打败95.56%
*/

class Solution3 {
	public void setZeroes(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		//第一列是否需要置0的标记。
		boolean isCo1 = false;

		//第一次遍历，打标记
		for(int i=0; i<R; i++){
			//额外判定第一列的数据
			if(matrix[i][0] == 0) isCo1 = true;

			for(int j=1; j<C; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		//第二次遍历，置0，从第二行和第二列开始。第一行和第一列因为特殊作用，需要额外用自己的标记判断是否置0。
		for(int i=1; i<R; i++){
			for(int j=1; j<C; j++){
				if(matrix[i][0]==0 || matrix[0][j]==0){
					matrix[i][j]=0;
				}
			}
		}

		//先判断第一行是否需要置0，
		if(matrix[0][0] == 0){
			for(int i=1; i<C; i++){
				matrix[0][i] = 0;
			}
		}

		//再判断第一列是否需要置0
		if(isCo1){
			for(int i=0; i<R; i++){
				matrix[i][0] = 0;
			}
		}

		//注意，必须先判断第一行再判断第一列，否则第一列置0会影响matrix[0][0]的标记。
	}
}