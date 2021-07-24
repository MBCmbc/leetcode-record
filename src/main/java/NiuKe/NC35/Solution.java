package NiuKe.NC35;

/*
思路同leetcode P72
*/
public class Solution {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int len1 = str1.length(), len2 = str2.length();
        //dp[i][j]矩阵表示，从word1的前i个字符，变为word2的前j个字符，需要的编辑距离。
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 0; i <= len2; i++) dp[0][i] = i * ic;    //矩阵第一行，表示从""到i个字符的距离，即不断插入。
        for(int i = 0; i <= len1; i++) dp[i][0] = i * dc;    //矩阵第一列，表示从i个字符到""的距离，即不断删除。

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    //word1的第i个字符和word2的第j个字符相等，只需要完成word1的前i-1个到word2的前j-1个转换即可。
                    dp[i][j] = dp[i-1][j-1];
                } else{
                /*否则，有以下三种情况：
                    1. 先完成word1的前i-1个到word2的前j-1个字符的转换，再把word1的第i个字符替换为word2的第j个字符，即dp[i-1][j-1] + rc
                    2. 先完成word1的前i个到word2的前j-1个字符的转换，再插入word2的第j个字符，即dp[i][j-1] + ic
                    3. 先完成word1的前i-1个到word2的前j个字符的转换，再把word1的第i个字符删除，即dp[i-1][j] + dc
                取三者最小值即可。
                */
                    int replace = dp[i-1][j-1] + rc;
                    int insert = dp[i][j-1] + ic;
                    int delete = dp[i-1][j] + dc;
                    dp[i][j] = Math.min(replace, Math.min(insert ,delete));
                }

            }
        }
        //dp矩阵右下角即为所求
        return dp[len1][len2];
    }
}