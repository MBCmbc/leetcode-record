package DynamicProgramming.P718;

/*
与牛客NC127,最长公共子串类似，使用动态规划求解，参考官方题解，方法一。
https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
思路：用一个二维的动态规划数组dp[][]保存A[i:]和B[j:]的“最长公共前缀”的长度，从i=n-1，j=m-1往前依次递推，直到i=0，n=0；并同步更新ans的值，最后就能得到正确结果。
递推公式如下：
    dp[i][j] = dp[i+1][j+1]+1    若A[i]==B[j]，说明公共前缀的长度需要+1；
               0                 若A[i]!=B[j]，说明A[i:]和B[j:]没有公共前缀，置0。

时间复杂度：O(M*N)，两重for循环。           打败37.92%
空间复杂度：O(M*N)，dp数组的大小。          打败19.82%
*/
class Solution {
	public int findLength(int[] A, int[] B) {
		int n = A.length, m = B.length;
		int[][] dp = new int[n+1][m+1];     //dp二维数组需要多申请一行一列，从n-1和m-1开始递推的时候需要用到。否则会数组越界。
		int ans = 0;                        //因为数组默认值为0，所以逻辑上也是合理的，符合递推公式。
		for(int i = n-1; i>=0; i--){
			for(int j=m-1; j>=0; j--){
				dp[i][j] = A[i]==B[j] ? dp[i+1][j+1]+1 : 0;         //递推公式
				ans = Math.max(ans, dp[i][j]);  //结果变量，实时更新
			}
		}

		return ans;
	}
}
