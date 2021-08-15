package String.P05;

/**
 最长回文子串，参考官方题解方法二，中心扩展算法。自己实现的，代码更好理解。
 https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/

 思路：扩展中心有两种情况：单个字符/两个字符。对s中的每一个位置，以这两种情况为初始中心[(i,i)以及(i,i+1)]进行扩展，计算以此为中心的最长回文子串长度。记录下每次“最长回文子串”的起始位置和结束位置，并根据长度不断实时更新记录最长的那个，最后返回即可。

 时间复杂度：O(N*N),N位字符串s长度。单字符中心有N个，双字符中心有N-1个，每个中心最多向外扩展N次。故为N*N。           打败80.28%
 空间复杂度：O(1).未使用额外空间。                                                                             打败75.14%
 */

class Solution2 {
    private int maxLen = 0;     //已经找到的最长回文子串的长度，初始化为0
    private int start = 0;      //已经找到的最长回文子串的开始和结束位置，以闭区间的方式表示，所以都初始化为0。
    private int end = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            expand(s, i, i);        //单个字符为中心
            expand(s, i, i+1);      //两个字符为中心
        }

        return s.substring(this.start, this.end+1);     //substring方法左闭右开，所以end需要+1位。
    }

    //从中心向两边扩展，寻找最长回文子串的函数。
    private void expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        int len = right - left - 1;         //while退出时多了两位不属于回文子串的，长度为right - left + 1 - 2；
        if(len > this.maxLen){              //如果这次找到的更长，则更新maxLen、start、和end。
            this.maxLen = len;
            this.start = left + 1;          //因为定义start和end是闭区间表示，所以需要left+1，right-1。
            this.end = right - 1;
        }
    }
}
