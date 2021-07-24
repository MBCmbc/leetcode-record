package Heap.P215;

import java.util.Arrays;

/*
草率了，乱写的，以后肯定不能这样写，要改的。
 */
class Solution {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
