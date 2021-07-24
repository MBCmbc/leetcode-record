package Array.P75;

/*
两趟扫描算法
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
时间复杂度：两个for循环，故为O(N)。					执行用时：打败100%
空间复杂度：只用了常数量级的额外空间，故为O(1)。			内存消耗：打败6.67%
*/


class Solution1 {
	public void sortColors(int[] nums) {
		//初始化关于0、1、2个数的计数器
		int len = nums.length;
		int cnt_0 = 0;
		int cnt_1 = 0;
		int cnt_2 = 0;

		//第一次遍历，计算0、1、2各自的个数
		for (int i=0; i<len; i++){
			if(nums[i] == 0) ++cnt_0;
			else if(nums[i] == 1) ++cnt_1;
				//不是0也不是1，只能是2
			else ++cnt_2;
		}

		for(int i=0; i<len; i++){
			if(i < cnt_0) nums[i] = 0;
				//第一个if条件不满足，一定是>=cnt_0的。
			else if(i < cnt_0+cnt_1) nums[i] = 1;
				//前两个条件都不满足，一定是>=cnt_0+cnt_1的,同时又小于len。
			else nums[i] = 2;
		}
	}
}
