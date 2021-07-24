package Array.P53;

/*
参考：官方题解方法一的C#写法
只需要一次遍历，所以时间复杂度O(N),
只用了常数量级的额外空间，故空间复杂度O(1)。
*/

class Solution {
	public int maxSubArray(int[] nums) {
		//pre用来表示f(i-1)，result用于表示最终返回结果。
		//因为题目已经说明子数组最少包含一个元素，所以可以用nums[0]初始化result，不必担心测试用例为空数组的情况。
		int pre = 0, result = nums[0];

		for(int num : nums){
			//num表示a_i，则pre+num表示f(i-1)+a_i；选取其中较大值作为f(i)
			pre = Math.max(pre+num, num);
			//比较f(i)与之前得到的最大子序和，若f(i)更大则更新结果值，否则保持不变。
			result = Math.max(pre, result);
		}

		return result;
	}
}
