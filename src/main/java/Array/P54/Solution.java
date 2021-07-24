package Array.P54;

/*
官方题解，方法二。

按层模拟，像剥洋葱，或者扯卷纸一样，一圈一圈地遍历。

时间复杂度：O(MN)   打败100%
空间复杂度：O(1)    打败42.73%
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;
		//每一层遍历所对应的上、下、左、右四个边界。
		int up=0, down=matrix.length-1, left=0, right=matrix[0].length-1;

		//在该条件下，才有可能还有元素需要遍历
		while(up<=down && left<=right){
			//只要还有元素，第一步的首行从左到右遍历是肯定需要的。
			//如果只剩一行元素，则到此遍历结束。
			for(int y=left; y<=right; y++){
				result.add(matrix[up][y]);
			}

			//第二步，在有边界上从上到下遍历
			//如果剩余元素超过一行，则这一步需要进行；如果只有一行，根据for循环对x的条件限制，这个for循环将不被执行。
			for(int x=up+1; x<=down; x++){
				result.add(matrix[x][right]);
			}

			//如果行数和列数均至少为2，才有需要进行剩余的便利；否则(只剩一行或一列)，前两个遍历就把剩余的元素遍历完了。
			if(up<down && left<right){
				//第三步，在下边界上从右到左遍历
				for(int y=right-1; y>=left; y--){
					result.add(matrix[down][y]);
				}

				//第四步，在左边界上从下到上遍历
				for(int x=down-1; x>up; x--){
					result.add(matrix[x][left]);
				}
			}

			//该层结束，更新边界值，准备下一层遍历
			up++;
			down--;
			left++;
			right--;
		}

		return result;
	}
}
