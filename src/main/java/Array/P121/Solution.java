package Array.P121;

/**
 同剑指offer p63
 自己的解法：股市挣钱的关键在于低买高卖，所以思路如下：
 1.用minPrice记录到前一天为止的股市最低价
 2.当天股价prices[i]-minPrice就是今天卖出能获取的最高利润
 3.res记录每天能获取的最高利润，取其中最大者即可。

 时间复杂度：O(N)，一次遍历                          打败97.26%
 空间复杂度：O(1)，常数级额外空间                     打败77.44%
 */
class Solution {
	public int maxProfit(int[] prices) {
		//无法获取利润时，需要返回0，所以直接将res最低值置为0。
		int res = 0;

		//记录最低价
		int minPrice = prices[0];
		//不能同一天买卖，从第二天开始计算
		for(int i = 1; i < prices.length; i++){
			//更新最大利润
			res = Math.max(res, prices[i] - minPrice);
			//更新最低价
			minPrice = Math.min(minPrice, prices[i]);
		}

		//res一定>=0，可以直接返回。
		return res;
	}
}
