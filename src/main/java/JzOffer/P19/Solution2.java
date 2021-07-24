package JzOffer.P19;

/*
2.递归思想求解
https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/dong-tai-gui-hua-he-di-gui-liang-chong-fang-shi-ji/

时间：打败8.15%
空间：打败17.7%
*/

class Solution2 {
	public boolean isMatch(String s, String p) {
		if(p.length() == 0) return(s.length() == 0);

		if(p.length()>1 && p.charAt(1) == '*'){
			//正则表达式第二位是'*'
			//两种情况，1.'*'及前面一个字符被忽略，表示匹配0次；2.匹配1次，进入下一次递归。
			return isMatch(s, p.substring(2)) || (s.length()>0 && cmp(s,p) && isMatch(s.substring(1), p));
		} else{
			//正则表达式第二项不是'*'，匹配第一个字符，后面的子串进入下一次递归判断。
			return s.length()>0 && cmp(s, p) && isMatch(s.substring(1), p.substring(1));
		}
	}

	//判断字符串的首字符是否符合正则表达式（不考虑'*'，关于'*'的判断在主函数中。）
	private boolean cmp(String s, String p){
		return (s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.');
	}
}