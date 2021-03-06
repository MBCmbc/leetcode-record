package Array.P122;

/*
自己的解法，也和官方题解的方法3思路相同。

思路：股票赚钱的核心在于：“低价买入，高价卖出”。所以可以简单的进行一次遍历，只要发现今天的价格比昨天高，就可以视为昨天买入，今天卖出，得到利润。
就算明天的价格更高，也可以视为，昨天买入今天卖出后，今天买入明天又卖出，其效用等同于昨天买入，明天卖出。
以此类推，按照这样的思路就可以拿到在此次股票价格波动中的所有可获取利润，也即最大利润。

时间复杂度：对数组做了一次遍历，故为O(N)。             执行用时：打败了99.48%的用户
空间复杂度：只用了常数量级的额外空间，故为O(1)。        内存消耗：打败了6.25%的用户
*/

class Solution {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for(int i=1; i<prices.length; i++){
			//只要有利润可以赚，就视为昨天买入，今天卖出，得到利润。
			if(prices[i] > prices[i-1]) profit += (prices[i] - prices[i-1]);
		}

		return profit;
	}
}
