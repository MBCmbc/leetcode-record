package JzOffer.P16;

/*
剑指offer既全面又高效的解法，即快速幂。
https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/

时间复杂度：O(logN)，指数每次除以2。        打败97.95%
空间复杂度：O(1)                          打败94.98%
*/

class Solution {
	public double myPow(double x, int n) {
		//当n为-2^31，取-n会溢出，所以用long型的b转存n。
		long b = n;
		double dis = 1e-6;
		if(b == 0){
			return 1.0;
		} else if(b > 0){
			return unsignedPow(x, b);
		} else{//n<0的情况
			//x=0.0的情况
			if(x < dis & x > -dis){
				return 0.0;
			}else{
				return 1/unsignedPow(x, -b);
			}
		}
	}

	//只处理n>0的情况，递归的思想更直接，更好理解，建议递归。

	//方法1，递归。
	double unsignedPow(double x, long b){
		if(b == 1) return x;

		double res = unsignedPow(x, b>>1);     //用位右移代替除2，提高效率
		res *= res;
		if((b&1) == 1) res *= x;        //判断b是否为奇数，并且用位与代替对2取余，提高效率。

		return res;
	}

	//方法2，循环。
    /*
     double unsignedPow(double x, long b){
        double res = 1.0;
        while(b > 0){
            if((b&1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }

        return res;
     }
     */
}