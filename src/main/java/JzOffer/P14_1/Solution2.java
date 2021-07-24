package JzOffer.P14_1;

/*
剑指offer贪婪算法，343官方题解方法三，数学。
https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
根据证明结果，将整数n尽可能多的拆分为3，若有4，则拆分为2*2，这样得到的乘积是最大的。

时间复杂度：O(1)            打败100%
空间复杂度：O(1)            打败30.97%
*/

class Solution2 {
	public int cuttingRope(int n) {
		//n=2以及n=3的情况。
		if(n <= 3) return n-1;

		int quotient = n/3;
		int remainder = n % 3;
		if(remainder == 0){
			//拆分成quotient个3
			return (int)Math.pow(3, quotient);
		} else if(remainder == 1){
			//拆分成quotient-1个3和2个2
			return (int)Math.pow(3, quotient-1)*4;
		} else{
			//拆分成quotient个3和1个2
			return (int)Math.pow(3, quotient)*2;
		}
	}
}
