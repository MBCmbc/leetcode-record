package String.P415;

/*
字符串相加，大数相加，做过类似的，知道思路，但是还是拉跨，没做出来，代码能力太差。参考了大佬的代码：
https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/
思路就是模拟数字加法的过程，从两个操作数num1和num2的末尾向前遍历相加，时刻记录进位，拼成一个字符串就行了。

时间复杂度：O(max(M,N)),M和N分别是两个操作数字符串的长度。while循环的次数以较大的数为准。            打败65.05%
空间复杂度：O(max(M,N))，StringBuilder的大小。                                                  打败29.64%
*/
class Solution {
	public String addStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int i = num1.length()-1, j = num2.length()-1, carry = 0; //i和j是指针，代表目前在num1和num2的第几位。carry是进位值。
		while(i>=0 || j>=0 || carry>0){
			int x = i>=0 ? num1.charAt(i)-'0' : 0;
			int y = j>=0 ? num2.charAt(j)-'0' : 0;
			int sum = x+y+carry;        //不要忘了加进位。
			res.append(sum%10);
			carry = sum / 10;
			i--;
			j--;
		}

		return res.reverse().toString();    //返回前记得翻转一下。
	}
}
