package JzOffer.P05;

/*
https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-ji-jian-qing-xi-tu-/

思路：遍历添加，因为JAVA中的字符串是不可修改的，所以不能用剑指Offer上的原地修改方法，只能令开辟一个StringBuilder进行构造。
        将原字符串从左至右遍历，碰见非空格就直接添加到res后面，碰到空格就添加"%20"

时间复杂度：O(N)，遍历整个字符串                            打败24.84%
空间复杂度：O(N)，令开辟的字符串空间                        打败32.27%
*/

class Solution {
	public String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for(Character c : s.toCharArray()){
			if(c == ' '){
				res.append("%20");
			}else{
				res.append(c);
			}
		}

		return res.toString();
	}
}
