package JzOffer.P21;

/*
剑指offer思路，左边一个指针，右边一个指针，当发现左偶右奇时，交换二者。遍历结束即得到要求数组

时间复杂度：O(N)，遍历一遍数组          打败98.63%
空间复杂度：O(1)                       打败70.22%
*/

class Solution1 {
	public int[] exchange(int[] nums) {
		int left = 0, right = nums.length-1;
		while(left < right){
			if((nums[left] & 1) == 1){
				++left;//left为奇，符合要求，且不可能交换，left直接左移
				if((nums[right] & 1) == 0) --right; //right为偶，符合要求，right左移
				//若right为奇，则right原地等待
			}else{//left为偶
				if((nums[right] & 1) == 1){//right为奇，left位和right交换数值
					int tmp = nums[left];
					nums[left] = nums[right];
					nums[right] = tmp;
					++left;
				}
				//两种情况：1.right为奇，交换完后，right左移； 2.right为偶，left原地等待，right左移
				//综上，right一定左移。
				--right;
			}
		}

		return nums;
	}
}