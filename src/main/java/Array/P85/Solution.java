package Array.P85;

/*
官方题解，方法四：动态规划 - 每个点的最大高度

思路：利用动态规划的思想，计算以每一行为“底”边界所能得到的最大矩形面积，再由此推出下一行为“底”边界所能得到的最大矩形面积，
     因此，遍历完整个矩阵，就能得到要求的最大矩形面积。

时间复杂度：O(MN)，两层循环，遍历整个矩阵       打败99.92%
空间复杂度：O(N))，额外开辟了三个数组空间       打败16.37%
*/

import java.util.Arrays;

class Solution {
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;

		//三个数组存储每一行的h、l、和r
		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);

		int maxArea = 0;
		//按行遍历
		for(int i=0; i<m; i++){
			//cur_left是我们遇到的最右边的0的序号加1，cur_right 是我们遇到的最左边的0的序号
			int currLeft=0, currRight=n;

			//行内按列遍历，更新height
			for(int j=0; j<n; j++){
				if(matrix[i][j] == '1'){
					//当前元素为‘1’,高度+1
					height[j]++;
				} else{
					//当前元素为‘0’，高度置0
					height[j] = 0;
				}
			}

			//行内按列遍历，更新left
			for(int j=0; j<n; j++){
				if(matrix[i][j] == '1'){
					//当前元素为‘1’，说明在某个“矩形”内，则左边界为（上一行对应元素的左边界）与（当前元素往左最远的连续1）中，靠右的那个。
					left[j] = Math.max(left[j], currLeft);
				} else{
					//当前元素为‘0’,代表当前高度是 0，所以left[j]初始化为0，防止对下次循环的影响
					//因为当前高度为0，所以计算出来面积一定也是0，故不必担心这里的赋值对面积计算结果的影响
					left[j] = 0;
					currLeft = j+1;
				}
			}

			//行内逆向按列遍历，更新right
			for(int j=n-1; j>=0; j--){
				if(matrix[i][j] == '1'){
					//当前元素为‘1’，说明在某个“矩形”内，则右边界为（上一行对应元素的右边界）与（当前元素往右最远的连续1）中，靠左的那个。
					right[j] = Math.min(right[j], currRight);
				} else{
					//当前元素为‘0’,代表当前高度是 0，所以right[j]初始化为n，防止对下次循环的影响
					//因为当前高度为0，所以计算出来面积一定也是0，故不必担心这里的赋值对面积计算结果的影响
					right[j] = n;
					currRight = j;
				}
			}

			//行内按列遍历，计算并更新最大矩形面积
			for(int j=0; j<n; j++){
				maxArea = Math.max(maxArea, (right[j]-left[j])*height[j]);
			}
		}

		return maxArea;
	}
}
