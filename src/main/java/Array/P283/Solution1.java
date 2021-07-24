package Array.P283;

/*
解法一，自己写的，利用冒泡排序的思想，将所有的0都“冒泡”到末尾。
*/

class Solution1 {
	public void moveZeroes(int[] nums) {
		for(int i=0; i<nums.length-1; ++i){
			for(int j=0; j<nums.length-i-1; ++j){
				if(nums[j] == 0){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}
}