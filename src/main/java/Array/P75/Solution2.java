package Array.P75;

/*
官方题解，一遍扫描。
思路：用三个指针（p0, p2 和curr）来分别追踪0的最右边界，2的最左边界和当前考虑的元素。

初始化：
    初始化0的最右边界：p0 = 0。在整个算法执行过程中 nums[idx < p0] = 0.
    初始化2的最左边界 ：p2 = n - 1。在整个算法执行过程中 nums[idx > p2] = 2.
    初始化当前考虑的元素序号 ：curr = 0.

While curr <= p2：
    若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。
    若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移。
    若 nums[curr] = 1 ：将指针curr右移。


时间复杂度：O(N);       执行用时：打败100%
空间复杂度：O(1)。      内存消耗：打败6.67%
*/

class Solution2 {
	public void sortColors(int[] nums) {
		//初始化三个指针
		int curr=0, p0=0, p2= nums.length-1;

		int tmp;
		while(curr <= p2){
			if(nums[curr] == 0){
				//交换第 curr个 和 第p0个 元素，并将指针都向右移。
				tmp = nums[curr];
				nums[curr++] = nums[p0];
				nums[p0++] = tmp;
			} else if(nums[curr] == 2){
				//交换第 curr个和第 p2个元素，并将p2指针左移。
				//因为换过来的可能还是2，所以curr不能右移。
				tmp = nums[curr];
				nums[curr] = nums[p2];
				nums[p2--] = tmp;
			} else{
				//nums[curr] = 1 ：将指针curr右移。
				curr++;
			}
		}
	}
}
