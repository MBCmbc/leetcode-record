package Array.P42;

/*
https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
解法四：双指针

要点如下：
1. 用两个指针left和right从两边往中间遍历；
2. 用maxLeft和maxRight两个值记录左、右两边的最高点，并随遍历的进行不停更新。
3. 在maxLeft和maxRight两者中取较小者作为“高度上限”，并据此计算储水量。

注意：left或right的值更新后要及时更新maxLeft或maxRight，否则会导致maxLeft和maxRight的比较出现错误。

时间复杂度：O(N)    打败99.99%
空间复杂度：O(1)    打败40.46%
*/

class Solution {
	public int trap(int[] height) {
		int sum = 0;
		//height为空的特殊情况
		if(height.length==0) return 0;
		int maxLeft = height[0], maxRight = height[height.length-1];
		//序列两端无论如何都是不会储水的，所以往中间各走一步再开始遍历
		int left = 1, right = height.length-2;
		for(int i=1; i<height.length-1; i++){
			//maxLeft较小，取其为上界，计算当前left列储水值，从左往右更新
			if(maxLeft < maxRight){
				//如果maxLeft大于left列的值，取二者差加入总储水量，否则说明该列没有储水。
				sum += maxLeft>height[left] ? maxLeft-height[left] : 0;
				left++;
				//更新maxLeft
				maxLeft = Math.max(maxLeft, height[left-1]);
			} else{
				//maxRight较小，取其为上界，计算当前right列储水值，从右往左更新

				//如果maxRight大于right列的值，取二者差加入总储水量，否则说明该列没有储水。
				sum += maxRight>height[right] ? maxRight-height[right] : 0;
				right--;
				//更新maxRight
				maxRight = Math.max(maxRight, height[right+1]);
			}
		}

		return sum;
	}
}