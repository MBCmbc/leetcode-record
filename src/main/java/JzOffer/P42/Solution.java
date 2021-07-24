package JzOffer.P42;

/*
同leetcode P53
剑指Offer解法二：动态规划
用f(i)表示以nums[i]为结尾的子序列的和的最大值，有如下两种情况：
    1. i==0 || f(i-1)<0     ->     f(i) = nums[i]
    2. 否则                 ->     f(i) = f(i-1) + nums[i]
然后取max[f(i)]即可

时间复杂度：O(N)，遍历一次数组                      打败98%
空间复杂度：O(1)                                  打败15.68%
*/

class Solution {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[2];          //dp数组，dp[0]表示f(i-1)，dp[1]表示f(i)
		int result = nums[0];           //保存结果。注意最后返回结果为子序列和的最大值，与dp数组的定义不一致，所以每计算完一个f(i)要更新一下result
		//确保返回最大值。

		for(int i = 0; i < nums.length; i++){
			if(i == 0 || dp[0] < 0){    //情况1
				dp[1] = nums[i];
			} else{
				dp[1] = dp[0] + nums[i];    //情况2
			}

			result = Math.max(result, dp[1]);   //更新result，时刻记录最大值
			dp[0] = dp[1];  //更新dp数组
		}

		return result;
	}
}
