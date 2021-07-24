package JzOffer.P21;

/*
剑指offer的优化版思路，将判断元素是否符合要求的部分单独剥离出一个函数，以适用于更多的场景。

时间复杂度：O(N)        打败26.8%
空间复杂度：O(1)        打败91.53%
*/

class Solution2 {
	public int[] exchange(int[] nums) {
		int left = 0, right = nums.length-1;
		while(left < right){
			//从左往右找偶数
			while((left<right) && isOdd(nums[left])) ++left;
			//从右往左找奇数
			while((left<right) && !isOdd(nums[right])) --right;

			//左偶右奇，不符合要求，交换。
			if(left < right){
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				++left;
				--right;
			}
		}

		return nums;
	}

	//判断整数是否为奇
	boolean isOdd(int num){
		return (num&1) == 1;
	}
}
