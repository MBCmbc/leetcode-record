package JzOffer.P62;

/*
大佬解法2，数学解法，不是很懂。
https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/

根据删除规律，倒推出最后应该剩下的元素。
总结一下反推的过程就是：(当前idx+m) % 上一轮剩余数字个数。

时间复杂度：O(N)            打败99.91%
空间复杂度：O(1)            打败91.45%
*/

class Solution2 {
	public int lastRemaining(int n, int m) {
		int ans = 0;        //最后只剩一个元素，idx必为0。
		//最后一轮剩下两个人，所以从2开始。
		for(int i = 2; i <= n; i++) ans = (ans + m) % i;
		return ans;
	}
}
