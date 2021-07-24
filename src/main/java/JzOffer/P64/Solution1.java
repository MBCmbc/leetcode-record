package JzOffer.P64;

/*
自己的解法，布置是否符合题意。
从1+2+...+n的公式(n*n+n)/2出发，用Math.pow()和>>代替乘法和除法，进行计算。

时间复杂度：打败100%
空间复杂度：打败94.74%
*/
class Solution1 {
	public int sumNums(int n) {
		return (int)(Math.pow(n, 2) + n) >> 1;
	}
}
