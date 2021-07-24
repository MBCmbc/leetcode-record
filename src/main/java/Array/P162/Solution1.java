package Array.P162;

/*
官方题解，方法一。

参考官方题解的分析，会有如下三种情况：
1.数组开头部分是降序的，那么第一个元素就是结果，将返回0；
2.数组整体是升序的，那么最后一个元素就是结果，将返回nums.length-1；
3.数组开头部分先升后降，则第一个峰值元素就是第一个拐点，也就是第一个满足nums[i]>nums[i+1]的元素。
而参考代码则完美的覆盖了这三种情况。

时间复杂度：O(N)    打败100%
空间复杂度：O(1)    打败31.44%
*/

class Solution1 {
	public int findPeakElement(int[] nums) {
		for(int i=0; i<nums.length-1; i++){
			if(nums[i] > nums[i+1]) return i;
		}

		return nums.length-1;
	}
}
