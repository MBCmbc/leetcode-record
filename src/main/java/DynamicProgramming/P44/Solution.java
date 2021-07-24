package DynamicProgramming.P44;

/*
官方题解，方法一：动态规划。
思路：用dp[i][j]表示s的前i个字符和p的前j个字符是否能匹配，根据题解中推导出的状态转移方程，并初始化和好边界条件后，即可得到代码。

时间复杂度：O(MN),M和N分别为两个字符串的长度        打败32.09%
空间复杂度：O(MN)                                 打败69.84%
*/

class Solution {
	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];

        /*
        初始化边界条件
        1. dp[0][0] = true
        2. dp[i][0] = false
        3. dp[0][i]只有在p的前半部分都为'*'的时候才为true，某一个点断了，后面就全为false
        */
		dp[0][0] = true;
		for(int i=1; i<n+1; ++i){
			if(p.charAt(i-1) == '*'){
				dp[0][i] = true;
			} else{
				break;
			}
		}

		//动态规划填充dp[][]
		for(int i=1;  i<m+1; i++){
			for(int j=1; j<n+1; j++){
				if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				} else if(p.charAt(j-1) == '*'){
					//分别对应用或不用(即用'*'匹配0个字符)'*'号
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}

		return dp[m][n];
	}
}
