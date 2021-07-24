package Array.P59;

/*
思路同leetcode P54 螺旋矩阵。换换写法。

时间复杂度：O(N*N)，遍历res矩阵并填充。                         打败100%
空间复杂度：O(1),如果res矩阵不计入空间复杂度的话。               打败55.3%
*/
class Solution {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int up=0, down=n-1, left=0, right=n-1;
		int num = 1;
		while(left <= right && up <= down){
			for(int c=left; c<=right; c++) res[up][c] = num++;
			for(int r=up+1; r<=down; r++) res[r][right] = num++;
			if(left < right){   //余下矩阵有两行及以上的情况下，才有必要向左遍历填写
				for(int c=right-1; c>=left; c--) res[down][c] = num++;
			}
			if(up < down){  //余下矩阵有两列及以上的情况下，才有必要向上遍历填写
				for(int r=down-1; r>=up+1; r--) res[r][left] = num++;
			}

			up++;
			down--;
			left++;
			right--;
		}

		return res;
	}
}
