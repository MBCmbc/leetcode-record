package DynamicProgramming.P1143;

/**
 * @Author MBC
 * @Date 2021/8/26
 */
/*
大佬解法，二维dp。
https://leetcode-cn.com/problems/longest-common-subsequence/solution/fu-xue-ming-zhu-er-wei-dong-tai-gui-hua-r5ez6/

思路：
    1. 设text1长len1，text2长len2，则二维矩阵dp[len1+1][len2+1]中，dp[i][j]表示text1[0:i-1]和text2[0:j-1]【闭区间】的最长公共子序列长度。
    2. 行数和列数都多1的原因是：i和j为0时分别代表text1长度为0和text2长度为0，此时最长公共子序列长度为0，方便直接初始化。
    3. 在dp计算dp[i][j]时，根据text[i-1]和text[j-1]的情况，有如下两种情况：
        a. text[i-1]==text[j-1]时，两字符串最后一位相等，所以最长公共子序列长度+1。dp[i][j] = dp[i-1][j-1] + 1。
        b. text[i-1]!=text[j-1]时，两字符串最后一位不等，则dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j])。
        比如对于ace和bc而言，他们的最长公共子序列的长度等于【1】ace和b的最长公共子序列长度0与【2】ac和bc的最长公共子序列长度1的最大值，即1。
    4. 最终dp矩阵的右下角元素即为所求。

时间复杂度：O(MN)，M为text1长度，N为text2长度。dp时需要二维遍历。           打败75.68%
空间复杂度：O(MN)，dp矩阵的大小。                                         打败53.98%
/*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //情况1，两字符串最后一位相等。
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //情况2，两字符串最后一位不相等。
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[len1][len2];
    }
}
