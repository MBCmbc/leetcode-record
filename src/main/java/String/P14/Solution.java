package String.P14;

/*
参考大佬代码，思路2.
https://leetcode-cn.com/problems/longest-common-prefix/solution/duo-chong-si-lu-qiu-jie-by-powcai-2/
思路：取首个字符串s，与后面每个字符串s1、s2...比较，并实时更新res，比较完之后就得到整体的最长公共前缀res。
s与s1的比较思路：用indexOf函数看res是否是s1的前半部分，不是就去掉res最后一位，一直循环，直到indexOf(res)==0。得到就是s和s1的最长公共前缀。
用s和s1比较得出的res，再到s2里寻找最长公共前缀。。。以此循环，最后就能得到结果。

时间复杂度：打败84.02%
空间复杂度：打败36.54%
*/
class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) return "";
		String res = strs[0];   //首个字符串
		for(int i = 1; i < strs.length; i++){   //与后面每个字符串比较
			while(strs[i].indexOf(res) != 0){   //利用indexOf函数看当前res是否为strs[i]的前缀，不是就去掉最后一位。直到是前缀为止（indexOf(res)==0就代表是前缀）
				res = res.substring(0, res.length() - 1);   //若没有公共前缀，res会一直缩减为空字符串，此时任何字符串indexOf(""")结果都是0，while会直接结束。最后也就是返""。
			}
		}

		return res;
	}
}
