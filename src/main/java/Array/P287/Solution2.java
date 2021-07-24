package Array.P287;

/*
官方题解，方法三：快慢指针。
时间复杂度：O(n)。「Floyd 判圈算法」时间复杂度为线性的时间复杂度。
空间复杂度：O(1)。我们只需要常数空间存放若干变量。
*/

class Solution2 {
	public int findDuplicate(int[] nums) {
		int slow=0, fast=0;
		//因为初始时slow==fast==0,所以采用do...while结构。用正常的while的话，无法进入循环。
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while(slow != fast);

		//slow指针置零，然后slow和fast每次同时前进一步，最后的相遇点就是重复值。
		slow=0;
		do {
			slow = nums[slow];
			fast = nums[fast];
		} while(slow != fast);

		//最后slow和fast是相等的，返回哪一个都可以。
		return fast;
	}
}
