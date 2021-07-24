package DynamicProgramming.P279;

/*
参考题解：https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/

思路：动态规划。
    某个数n，减去j的平方(j从1递加)，得到数m，则数m的对应结果+1，就是数n的一种分解方式，遍历j就能得到个数最少的分解。
    得到状态转移方程dp[i] = Math.min(dp[i], dp[i-j*j]+1);

时间复杂度：O(N*sqrt(N))    打败77.97%
空间复杂度：O(N)            打败85.21%
*/

class Solution {
	public int numSquares(int n) {
		//初始化一个长度为n+1的数组dp[]，存储0~n所对应的待求结果，目前每个位置都为0。
		int[] dp = new int[n+1];
		//因为n已定位正整数，所以默认dp[0]为0，从1开始遍历并给数组赋值。
		for(int i=1; i<=n; i++){
			//每个数i的最坏情况就是由i个1组成其完全平方和，所以先初始化dp[i]为i
			dp[i] = i;
			//从j=1开始，减去j的平方得到一个数m，则dp[m]+1是一种可能的分解方式（1代表减去的j平方）；
			//j递加，以动态规划的思想列举出所有可能的分解方式，取最小者即可。
			for(int j=1; i-j*j>=0; j++){
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}

		return dp[n];
	}
}
