package JzOffer.P57_1;

/*
剑指offer思路，+自己实现代码，和大佬题解一样的。
对撞双指针
https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
在“排序数组”中设置两个指针，一个从左端开始，一个从右端开始，向中间移动，直至找到和为target的两个数。

时间复杂度：O(N)，N为数组长度，双指针同时移动，最坏情况下需要遍历一遍数组。                 打败95.54%
空间复杂度：O(1)。                                                                         打败45.09%
*/

class Solution3 {
	public int[] twoSum(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while(left < right){
			int sum = nums[left] + nums[right];
			if(sum == target){                                  //找到，直接返回。
				return new int[]{nums[left], nums[right]};
			} else if(sum > target){        //和太大，右端指针左移
				right--;
			} else{ //sum < target          //和太小，左端指针右移
				left++;
			}
		}

		return new int[0];      //未找到，返回空数组。
	}
}
