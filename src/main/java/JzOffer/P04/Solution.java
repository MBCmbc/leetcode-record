package JzOffer.P04;

/*
剑指offer书上的解法，从右上角往左、往下寻找target，过程中不断剔除一些行或列，直到最终找到。


时间复杂度：O(M+N),"右上角"的坐标最多下移M次，左移N次，故最多循环M+N次。                打败100%
空间复杂度：O(1)                                                                   打败71.45%
*/

class Solution {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		//输入为空
		if(matrix.length == 0) return false;

		//(x,y)表示当前的“右上角”坐标
		int x = 0;
		int y = matrix[0].length - 1;
		while(x<=matrix.length-1 && y>=0){
			if(matrix[x][y] == target){
				return true;
			} else if(matrix[x][y] > target){
				//“右上角元素”大于target，剔除当前列，往左走
				y -= 1;
			} else{
				//“右上角元素”小于target，剔除当前行，往下走
				x += 1;
			}
		}

		//遍历完都没发现target元素，返回false
		return false;
	}
}
