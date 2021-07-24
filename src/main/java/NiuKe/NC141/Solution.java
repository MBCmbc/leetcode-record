package NiuKe.NC141;

/*
判断字符串是否是回文串
 */
public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 *
	 * @param str string字符串 待判断的字符串
	 * @return bool布尔型
	 */
	public boolean judge (String str) {
		// write code here
		if(str == null || str.length() == 0) return true;
		int len = str.length();
		for(int i = 0; i < len/2; i++){
			if(str.charAt(i) != str.charAt(len - i - 1)) return false;
		}

		return true;
	}
}
