package String.P151;

/*
同剑指offer P58-1
参考大佬题解，“方法一：双指针”
https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
使用两个指针left和right分别记录字符串中一个单词的起始位置和结束位置，从右向左遍历，逐个将单词拼接到结果StringBuilder上去。

时间复杂度：O(N)，N为s的长度，需要遍历一遍s。       打败66.26%
空间复杂度：O(N)，StringBuilder占用的空间。         打败56.24%
*/

class Solution2 {
	public String reverseWords(String s) {
		StringBuilder res = new StringBuilder();
		s = s.trim();
		int left = s.length() - 1, right = s.length() -1;       //分别代表单词的开头和末尾
		while(left >= 0){
			while(left >= 0 && s.charAt(left) != ' ') --left;           //从当前所在单词的末尾开始，寻找当前所在单词的开头
			res.append(s.substring(left+1, right+1)).append(" ");       //拼接
			while(left >= 0 && s.charAt(left) == ' ') --left;           //越过所有多余的空格，来到下一个单词的末尾
			right = left;                                               //right跟上
		}

		return res.toString().trim();
	}
}
