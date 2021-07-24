package DynamicProgramming.P322;

/*
官方题解：方法三、动态规划：自下而上

思路：用F(i)表示amount为i时对应的结果(硬币面额数组都是coins)，则可以得到如下转移方程
        F(i) = Min{F(i-coins[j])} + 1        {coins[j] = coins[0]、coins[1]....}
     即F(i)等于i去掉某一面额后需要的最少硬币数+1(去掉的那个面额对应的硬币)

     注意：当i==0时，用“0”个硬币组成，故F(0)=0，当i为负时，忽略。

时间复杂度：O(Sn)，S为amount数值大小，n为coins[]数组大小，对应动态规划中的两重循环          打败68.26%
空间复杂度：O(S)，开辟了大小为"amount+1"的数组                                           打败91.62%
*/

import java.util.Arrays;

class Solution {
	public int coinChange(int[] coins, int amount) {
		//i从0到amount对应的dp数组
		int[] dp = new int[amount+1];
		//若F(i)是有意义的，即i可以被硬币组成，则最大值为amount(amount个1元硬币)
		//状态转移方程中是用min计算的，数组全初始化为超过上限的值，便于状态转移方程中的计算
		//另外，在最后return时，也会利用到此值，具体看return处的注释
		Arrays.fill(dp, amount+1);
		//当i==0时，用“0”个硬币组成，故F(0)=0
		dp[0] = 0;

		//金额从1到amount一步一步的计算（动态规划）
		for(int i=1; i<=amount; i++){
			//将所有可能的硬币面额枚举一遍，求出最小的F(i-coins[j])
			for(int j=0; j<coins.length; j++){
				//只有当i>=coins[j]时F(i-coins[j])才有意义，否则i-coins[j]为负，没有意义。
				if(i >= coins[j]){
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}

		//由dp[]数组的定义，必然是根据dp[amount]返回。
		//若dp[amount]>amount，说明未被改变过，仍是初始化值，也就说明没有任何组合可以组成该金额，返回-1
		//否则，说明有正确的组合方案，由dp[]数组定义，返回dp[amount]即可
		return dp[amount]>amount ? -1 : dp[amount];
	}
}