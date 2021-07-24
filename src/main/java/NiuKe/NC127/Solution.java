package NiuKe.NC127;

/*
最长公共子串。思路同leetcode P718，最长重复子数组。动态规划。
*/
public class Solution {
	/**
	 * longest common substring
	 * @param str1 string字符串 the string
	 * @param str2 string字符串 the string
	 * @return string字符串
	 */
	public String LCS (String str1, String str2) {
		// write code here
		int n = str1.length(), m = str2.length();
		int[][] dp = new int[n+1][m+1];
		int maxLen = 0;        //最长公共子串的长度。
		int startIdx = n;    //最长公共子串在str1中的起始位置。
		for(int i = n-1; i >= 0; i--){
			for(int j = m-1; j >= 0; j--){
				dp[i][j] = str1.charAt(i)==str2.charAt(j) ? dp[i+1][j+1]+1 : 0;
				if(dp[i][j] > maxLen){    //更新最大长度和子串起始位置。
					maxLen = dp[i][j];
					startIdx = i;
				}
			}
		}

		if(maxLen > 0) return str1.substring(startIdx, startIdx + maxLen);
		else return "";    //maxLen>0才能返回，否则说明没有公共子串，返回“”；
	}
}
