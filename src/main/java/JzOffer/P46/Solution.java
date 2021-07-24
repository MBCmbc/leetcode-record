package JzOffer.P46;

/*
动态规划，自己的思路+代码，巧合的是，与剑指offer的思路，大佬的思路2，是一样的。
https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
（从右往左遍历计算的结果和从左往右是一样的）
用f(i)表示以第i位数字作为截止，一共有多少种翻译方法。则有递推公式：
1. f(i) = f(i-2) + f(i-1)       //i-1位和i位拼接起来在[10,25]中，有两种翻译方法：i位单独翻译、i-1位和i位拼接翻译
2. f(i) = f(i-1)                //i-1位和i位拼起来不在[10,25]中，则只能i位单独翻译。
根据上述递推公式，用动态规划的方式实现代码（从右向左）。

时间复杂度：O(N)，N为num的位数                                  打败100%
空间复杂度：O(1)，几个变量只用了常数级空间                       打败70.1%
*/

class Solution {
	public int translateNum(int num) {
		int[] dp = new int[3];          //dp[2]代表f(i)，dp[1]代表f(i-1)，dp[0]代表f(i-2)
		dp[0] = 1;                      //初始值，dp[0]代表f(0)，值为1
		int rem = num % 100;
		if(rem >=10 && rem <=25){       //根据最后两位是否在[10,25]之中，为dp[1]赋初始值，即f(1)。
			dp[1] = 2;
		} else{
			dp[1] = 1;
		}

		if(num >=0 && num <= 9){                //若num只有1位或者两位，则可以直接提前返回。
			return dp[0];
		} else if(num >=10 && num <= 99){
			return dp[1];
		}

		num /= 10;                              //开始动态规划递推，因为要结合i-1位判断是否在[10,25]之间，所以要多保留一位
		while(num/10 != 0){                     //此时，num/10代表当前位往左的数，
			rem = num % 100;                    //i-1位和i位拼接所得数值
			dp[2] = rem >=10 && rem <= 25 ? dp[0] + dp[1] : dp[1];

			dp[0] = dp[1];                      //为下一次循环进行准备
			dp[1] = dp[2];
			num /= 10;
		}

		return dp[2];
	}
}
