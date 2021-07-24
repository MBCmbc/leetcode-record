package Array.P11;

/*
双指针法。做过一次，还是不会，拉跨。参考官方题解：
https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
思路：一开始左右指针l和r位于数组左右边界，计算此时的容量。然后每次将l和r指针中高度较小的那个向中间移动，计算新的容量。移动过程中实时更新最大容量。
这么做的原因：容量=底*高，高=min(height[l],height[r])。向中间移动“底”一定会减小，若移动l和r中较高者，那么新高<=原高，容量一定减小，移动较小者是有可能增大的。

时间复杂度：O(N)，遍历一次数组。            打败24.15%
空间复杂度：O(1)。                        打败6.86%
*/

class Solution {
	public int maxArea(int[] height) {
		int l = 0, r = height.length-1; //左右指针
		int res = 0;
		while(l < r){
			res = Math.max(res, Math.min(height[l], height[r]) * (r - l));  //当前容量
			if(height[l] < height[r]) l++;  //移动较低的指针
			else r--;
		}
		return res;
	}
}
