package JzOffer.P58_2;

/*
虽然java使用三次翻转法没有任何益处（String字符串是不可变的，必须转为char数组来进行操作，空间复杂度仍是O(N)），但还是强行用一下试试。
三次翻转法，以题目示例1为例：
    1. 翻转整个字符串：“gfedcba”;
    2. 翻转“原后半部分”，也就是“现前半部分”：“cdefgba”；
    3. 翻转“原前半部分”，也就是“现后半部分”："cdefgab"。

时间复杂度：O(N)，三次翻转使用O(N)时间。                        打败32.98%
空间复杂度：O(N)，chars[]数组使用了额外O(N)空间。               打败82.57%
*/

class Solution4 {
	private char[] chars;
	public String reverseLeftWords(String s, int n) {
		chars = s.toCharArray();
		int len = chars.length;
		reverse(0, len - 1);                //1.翻转整个字符串
		reverse(0, len - n - 1);            //2.翻转现前半部分
		reverse(len - n, len - 1);          //3.翻转现后半部分
		return new String(chars);
	}

	void reverse(int start, int end){       //翻转函数
		while(start < end){
			char tmp = chars[start];
			chars[start] = chars[end];
			chars[end] = tmp;
			++start;
			--end;
		}
	}
}
