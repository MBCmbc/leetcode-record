package DynamicProgramming.P72;

/*
参考大佬题解。动态规划
https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
dp[i][j]矩阵表示，从word1的前i个字符，变为word2的前j个字符，需要的编辑距离。

时间复杂度：O(MN)，M和N表示word1和word2的长度。         打败88.04%
空间复杂度：O(MN)                                     打败57.94%
*/

class Solution {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int[][] dp = new int[len1+1][len2+1];

		for(int i = 1; i <= len2; i++) dp[0][i] = i;    //矩阵第一行，表示从""到i个字符的距离，即不断插入。
		for(int i = 1; i <= len1; i++) dp[i][0] = i;    //矩阵第一列，表示从i个字符到""的距离，即不断删除。

		for(int i = 1; i <= len1; i++){
			for(int j = 1; j <= len2; j++){
				//word1的第i个字符和word2的第j个字符相等，只需要完成word1的前i-1个到word2的前j-1个转换即可。
				if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                /*否则，有以下三种情况：
                    1. 先完成word1的前i-1个到word2的前j-1个字符的转换，再把word1的第i个字符替换为word2的第j个字符，即dp[i-1][j-1] + 1
                    2. 先完成word1的前i个到word2的前j-1个字符的转换，再插入word2的第j个字符，即dp[i][j-1] + 1
                    3. 先完成word1的前i-1个到word2的前j个字符的转换，再把word1的第i个字符删除，即dp[i-1][j] + 1
                取三者最小值即可。
                */
				else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
			}
		}
		//dp矩阵右下角即为所求
		return dp[len1][len2];
	}
}
