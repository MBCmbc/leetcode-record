package JzOffer.P58_2;

/*
大佬题解2，若规定不能使用substring()方法时，使用。
https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
相当于把substring展开来自己拼，一个字符一个字符的拼上去。

时间复杂度：O(N)，N为字符串长度，遍历s并添加需要线性时间。	打败20.48%
空间复杂度：O(N)，res的长度为N。							打败21.64%
*/

class Solution2 {
	public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
		for(int i = n; i < s.length(); i++) res.append(s.charAt(i));    //先拼后面的
		for(int i = 0; i < n; i++) res.append(s.charAt(i));     //再拼前面的
		return res.toString();
	}
}
