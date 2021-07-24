package Math.P171;

/*
https://leetcode-cn.com/problems/excel-sheet-column-number/solution/hua-jie-suan-fa-171-excelbiao-lie-xu-hao-by-guanpe/
思路：本质上就是26进制转换为10进制。从头到尾遍历字符串，取出字符对应的十进制数字并转换即可。

时间复杂度：O(N)            执行用时：打败100%
空间复杂度：O(1)            内存消耗：打败5.55%
*/

class Solution {
	public int titleToNumber(String s) {
		//结果变量
		int ans = 0;
		//从字符串头部开始遍历
		for(int i=0; i<s.length(); i++){
			//取出对应位置字符对应的十进制数字大小
			int num = s.charAt(i) - 'A' + 1;
			//每向后遍历一次，前面遍历过的数字就升高一位，需要乘26完成对应的位数升高。再加上当前数字即可表示已经遍历过的字符串对应的数字。
			//后面依次推进，即可得到最终结果。
			ans =ans*26 + num;
		}

		return ans;
	}
}