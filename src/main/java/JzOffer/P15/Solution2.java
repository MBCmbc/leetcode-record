package JzOffer.P15;

/*
剑指offer令面试官精细的解法，题解方法二，巧用n&(n-1)
https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
利用n&(n-1)相当于把n的二进制表示中最右边一位1变成0的特性，统计1的个数。

时间复杂度：O(M)，M为n的二进制表示中1的个数                     打败97.28%
空间复杂度：O(1)                                             打败86.8%
*/

public class Solution2 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int res = 0;
		while(n != 0){
			n = n&(n-1);
			res++;
		}

		return res;
	}
}
