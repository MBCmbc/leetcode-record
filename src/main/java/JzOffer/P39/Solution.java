package JzOffer.P39;

/*
同leetcodeP169
剑指offer思路，+大佬题解
https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
投票法，以数组首元素作为投票元素x开始遍历，与其相等则+1，不等则-1。过程中若发现votes为0，则可以看作抛弃前面已遍历部分数组，以剩余部分首元素作为
投票元素x再次开始投票。如此循环下次，直至结束。
因为所求数字出现次数超过了数组长度的一半，可以断定最后x中存储的元素必为所求。

时间复杂度：O(N)，遍历数组                打败99.99%
空间复杂度：O(1)                         打败42.72%
*/

class Solution {
	public int majorityElement(int[] nums) {
		int votes = 0;
		int x = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(votes == 0) x = nums[i];
			votes += nums[i] == x ? 1 : -1;
		}

		return x;
	}
}
