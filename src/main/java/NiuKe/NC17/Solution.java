package NiuKe.NC17;

/*
同leetcode P05，只不过这里只需要返回最长回文子串的长度，更简单了。
*/
public class Solution {
	public int getLongestPalindrome(String A, int n) {
		// write code here
		int res = 0;
		for(int i = 0; i < n; i++){
			int len1 = expand(A, i, i);
			int len2 = expand(A, i, i+1);
			int len = Math.max(len1, len2);
			res = Math.max(res, len);
		}

		return res;
	}

	public int expand(String s, int left, int right){
		while(left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		return right-left - 1;
	}
}
