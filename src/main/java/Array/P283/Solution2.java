package Array.P283;

/*
https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
两次遍历的解法，第一次遍历记录非零元素个数，并将它们都挪到数组前部；第二次遍历把超出非零元素个数的部分都置0
*/

class Solution2 {
	public void moveZeroes(int[] nums) {
		if(nums == null) return;

		int j = 0;
		//第一次遍历
		for(int i=0; i<nums.length; ++i){
			//将非零元素赋值到数组的前部，并用j记录下标
			if(nums[i] != 0){
				nums[j++] = nums[i];
			}
		}

		//第二次遍历,把j下标之后的所有元素置0
		for(int i=j; i<nums.length; ++i){
			nums[i] = 0;
		}
	}
}
