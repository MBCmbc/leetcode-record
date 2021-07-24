package DynamicProgramming.P338;

/*
官方题解，方法三：动态规划 + 最低有效位

思路：观察x和x/2的二进制数关系：
    605——>1001011101
    302——>100101110
    可以发现只有一位不同，这是因为x/2可以看作x右移1位得到的结果。
    从而得到状态转移方程：P(x) = P(x/2) + (x mod 2)

时间复杂度：O(N)                                打败74.42%
空间复杂度：O(N),这还是算上了结果数组的。          打败89.63%
*/

class Solution2 {
	public int[] countBits(int num) {
		int[] ans = new int[num+1];
		//数组初始化后，ans[0]自然为0，所以从i=1开始计算
		for(int i=1; i<=num; i++){
			//用位运算的方式得到的状态转移方程
			ans[i] = ans[i>>1] + (i&1);
		}

		return ans;
	}
}
