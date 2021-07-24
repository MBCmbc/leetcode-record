package JzOffer.P58_2;

/*
大佬题解3，若规定不能使用substring()方法且不能使用StringBuilder时，使用。
https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
相当于把substring展开来自己拼，一个字符一个字符的拼上去。

时间复杂度：O(N)，N为字符串长度，遍历s并添加需要线性时间。											  打败5.41%
空间复杂度：O(N)，假设循环过程中内存会被及时回收，内存中至少同时存在长度为N和N-1的两个字符串
                 （新建长度为N的res需要使用前一个长度为N-1的res），故至少使用O(N)空间。                 打败5.95%
*/

class Solution3 {
	public String reverseLeftWords(String s, int n) {
		String res = "";
		for(int i = n; i < s.length(); i++) res += s.charAt(i);    //先拼后面的
		for(int i = 0; i < n; i++) res += s.charAt(i);     //再拼前面的
		return res;
	}
}
