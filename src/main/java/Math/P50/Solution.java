package Math.P50;

/*
官当题解，方法二，快速幂+迭代

思路：将幂指数按二进制进行拆分成(1+2+4+8+....)的形式，如果对应的二进制位上为1，则计入贡献。否则不计入贡献

时间复杂度：O(logN)，即为对n进行二进制拆分的时间复杂度。        打败97.36%
空间复杂度：O(1)                                                打败36.00%
*/

class Solution {
	public double myPow(double x, int n) {
		long N = n;
		//若n为负，则转正后求幂再求倒数
		return N>0 ? quickMul(x, N) : 1.0/quickMul(x, -N);
	}

	public double quickMul(double x, long N){
		double ans = 1.0;
		//贡献初始值为X^1
		double x_contribute = x;
		while(N > 0){
			//若二进制最低位为1，则需要计入贡献
			if(N%2 == 1){
				ans *= x_contribute;
			}

			//贡献平方，代表二进制的更高一位
			x_contribute *= x_contribute;
			//N右移一位，次低位变成最低位，以便下一次循环的判断
			N >>= 1;
		}

		return ans;
	}
}
