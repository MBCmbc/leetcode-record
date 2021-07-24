package Array.P560;

/*
官方题解，方法一
思路：对数组中的每一个元素位置，从后往前计算遍历求和，得到一次k，就在总次数加1。相当于暴力求解。
时间复杂度：O(N^2)      执行用时：打败38.96%
空间复杂度：O(1)        内存消耗：打败37.21%
*/

class Solution1 {
	public int subarraySum(int[] nums, int k) {
		//计数，计算和为k的子序列个数
		int count = 0;
		//遍历数组内元素
		for(int start=0; start<nums.length; start++){
			int sum = 0;
			//以当前元素为末尾。向前遍历，计算和为k的子序列个数。
			for(int end=start; end>=0; end--){
				sum += nums[end];
				//和为k，计数器+1
				if (sum == k) count++;
			}
		}
		//返回结果。
		return count;
	}
}
