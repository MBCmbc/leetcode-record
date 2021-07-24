package JzOffer.P53_1;

/*
自己的愚蠢解法：
从数组头部开始遍历，每找到一个target元素，res+1。
因为是排序树组，所以可以只在<=rtarget的范围内搜索。

时间复杂度：O(N),需要遍历数组               打败100%
空间复杂度：O(1)。                          打败65.46%
*/

class Solution1 {
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;  //特殊情况
		int res = 0;
		int index = 0;
		while(index < nums.length && nums[index] <= target){        //边界条件，下标不能越界。
			if(nums[index++] == target) ++res;
		}

		return res;
	}
}
