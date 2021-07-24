package Array.P283;

/*
https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
一次遍历的解法，用i和j两个指针。
*/

class Solution3 {
	public void moveZeroes(int[] nums) {
		if(nums == null) return;

		//指针j，遍历开始后，在遇到0元素之前，随i同步移动，自从遇到第一个0元素，永远代表数组内从左到右的第一个0元素
		int j = 0;
		for(int i=0; i<nums.length; i++){
			//指针i，从左到右逐个遍历，若不为0，与nums[j++]交换
			if(nums[i] != 0){
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j++] = temp;
			}
		}

	}
}
