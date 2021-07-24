package String.P05;

/*
最长回文子串，参考官方题解方法二，中心扩展算法。（我也是这么想的，但是太菜，代码漏洞百出）
https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
思路：扩展中心有两种情况：单个字符/两个字符。对s中的每一个位置，以这两种情况为初始中心[(i,i)以及(i,i+1)]进行扩展，计算以此为中心的最长回文子串长度。记录下每次“最长回文子串”的起始位置和结束位置，并根据长度不断实时更新记录最长的那个，最后返回即可。

时间复杂度：O(N*N),N位字符串s长度。单字符中心有N个，双字符中心有N-1个，每个中心最多向外扩展N次。故为N*N。           打败80.28%
空间复杂度：O(1).未使用额外空间。                                                                             打败75.14%
*/

class Solution {
	public String longestPalindrome(String s) {
		if(s==null || s.length()==0) return "";
		int start=0, end=0;     //记录“最长回文子串”起始和结束位置。
		for(int i=0; i<s.length(); i++){
			int len1 = expand(s, i, i); //单个字符为中心
			int len2 = expand(s, i, i+1);   //两个字符为中心
			int len = Math.max(len1, len2); //取较大者
			if(len > end - start + 1){  //若本次长度更长，记录新的start和end。
				start = i - (len-1)/2;  //不管是单字符为中心还是双字符为中心，用这两个公式都能正确计算出“回文子串”的正确起始和结束位置。
				end = i + len/2;        //这是因为除法向下取整。
			}
		}

		return s.substring(start, end+1);   //substring方法左闭右开，所以end需要+1位。
	}

	//从中心向两边扩展，寻找最长回文子串的函数。
	public int expand(String s, int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;    //while退出时多了两位不属于回文子串的，长度为right - left + 1 - 2；
	}
}
