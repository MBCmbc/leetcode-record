package Array.P238;

/*
官方题解，解法二。
因为结果数组不计算入空间复杂度，所以我们可以利用结果数组来存储nums[i]的左侧元素乘积。
另外再用R动态地表示nums[i]右侧元素的乘积，从而达到降低空间复杂度的效果。
时间复杂度：先后两次for循环，故为O(N)；
空间复杂度：除了结果数组外，只用了常数量级个额外空间，故为O(1)。
*/

class Solution {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		//结果数组，先用来表示nums[i]左侧元素乘积，再用来表示nums[i]两侧元素乘积，最后返回。
		int[] answers = new int[len];

		//第一次遍历，构造answers[i]，代表nums[i]左侧所有数字的乘积。
		//因为nums[0]左侧没有元素，所以answers[0] = 1；
		answers[0] = 1;
		for(int i=1; i<nums.length; i++){
			answers[i] = answers[i-1] * nums[i-1];
		}

		//初始化R，因为数组最后一个元素的右边没有元素了，所以R初始化为1;
		int R = 1;
		//第二次遍历,从右至左，计算answers[i]并动态地更新R。
		for(int i=len-1; i>=0; i--){
			//将answers[i]由nums[i]左侧元素乘积更新为nums[i]两侧元素乘积。
			answers[i] = answers[i] * R;
			//动态更新R的值。
			R *= nums[i];
		}

		return answers;
	}
}
