package JzOffer.P64;

/*
参考大佬解法3，递归。
https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
利用java中逻辑运算符&&的“短路效应”，代替if语句作为递归的终止条件，计算n + n-1 + n-2 +......+ 3 + 2 + 1。

时间复杂度：O(N)，N次递归调用。                 打败52.91%
空间复杂度：O(N)，递归调用栈的深度。            打败20.04%
*/

class Solution2 {
	int res = 0;    //全局变量res，1-n的数值会加到这上面去。
	public int sumNums(int n) {
		//利用短路效应终止递归（n=1时&&后面的递归调用就不会触发，从而终止）
		boolean x = n > 1 && sumNums(n - 1) > 0;    //写成"x=..."以及“sumNumS(...)>0”是为了构成boolean表达式，避免报错。没有实际意义
		res += n;       //每次递归调用触发一次，最终把1-n都加到res上去。
		return res;     //返回结果，只有最顶层调用有用。
	}
}
