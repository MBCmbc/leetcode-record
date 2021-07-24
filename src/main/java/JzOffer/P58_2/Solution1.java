package JzOffer.P58_2;

/*
API战士的搞笑解法。
根据题目的“左旋”意义，直接用后半部分拼上前半部分即得所求。

时间复杂度：O(N),N为字符串长度，substring()方法时间复杂度为O(N)。	打败100%
空间复杂度：O(N)，两个substring的总长度为N。						打败94.69%
*/

class Solution1 {
	public String reverseLeftWords(String s, int n) {
		return s.substring(n) + s.substring(0, n);
	}
}
