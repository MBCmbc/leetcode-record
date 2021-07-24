package JzOffer.P29;

/*
同leetcode第54题，下述题解方法二，按层模拟
https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/shun-shi-zhen-da-yin-ju-zhen-by-leetcode-solution/
像剥洋葱一样，按顺时针一圈圈的遍历，但是要注意四个方向下，是否需要遍历的条件。

时间复杂度：O(MN)，M和N分别为矩阵的行数和列数，相当于遍历了一圈矩阵。               打败97.13%
空间复杂度：O(1)，除结果数组外，只使用了常数级别的额外空间。                        打败38.69%
*/

class Solution {
	public int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
		int rows = matrix.length, columns = matrix[0].length;
		int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
		int index = 0;
		int[] result = new int[rows * columns];

		while(top <= bottom && left <= right){
			//每一圈的起始，从左到右第一行，是必须的。
			for(int i = left; i <= right; i++){
				result[index++] = matrix[top][i];
			}

			//在本圈的最右一列，从上至下。
			for(int i = top+1; i <= bottom; i++){
				result[index++] = matrix[i][right];
			}

			//在这种条件下，本圈才不会是“一行”、“一列”或“一个块”，也才有必要向左或向上遍历。
			if(top < bottom &&  left < right){
				for(int i = right - 1; i >= left; i--){
					result[index++] = matrix[bottom][i];
				}

				for(int i = bottom - 1; i > top; i--){
					result[index++] = matrix[i][left];
				}
			}

			++top;
			--bottom;
			++left;
			--right;
		}

		return result;
	}
}
