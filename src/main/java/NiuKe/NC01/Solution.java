package NiuKe.NC01;

/*
大数加法，同leetcode P415 字符串相加
*/
public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * 计算两个数之和
	 * @param s string字符串 表示第一个整数
	 * @param t string字符串 表示第二个整数
	 * @return string字符串
	 */
	public String solve (String s, String t) {
		// write code here
		StringBuilder res = new StringBuilder();
		int i = s.length()-1, j = t.length()-1, carry = 0;
		while(i>=0 || j>=0 || carry>0){
			int x = i>=0 ? s.charAt(i)-'0' : 0;
			int y = j>=0 ? t.charAt(j)-'0' : 0;
			int sum = x + y + carry;
			res.append(sum%10);
			carry = sum/10;
			i--;
			j--;
		}

		return res.reverse().toString();
	}
}
