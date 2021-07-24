package JzOffer.P63;

/*
同leetcode P121
自己的解法。动态规划。用变量result记录到某一天为止，所能得到的股票最大利润。
思路：无论在哪一天卖出，都希望自己是在最低点买入的，所以用一个变量min记录从第一天开始到当前位置的股票最低值，表示到目前为止的最低点。
用当前股票之prices[i]-min，所得结果与result（记录到前一天为止可以得到的最大利润，初始化为0）对比，选更大者作为新的result。
这样一直更新，遍历数组结束后就可以得到最终的最大利润。

时间复杂度：O(N)，N为数组长度，遍历一次数组。           打败97.56%
空间复杂度：O(1)，使用常数级别的额外空间。              打败71.38%
*/
class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int min = prices[0];    //到目前为止的历史最低点，随着遍历数组同步更新。
		int result = 0;         //所能得到的最大利润，dp变量，随着遍历数组同步更新。
		for(int i = 1; i < prices.length; i++){
			if(prices[i] <= min){
				min = prices[i];      //prices[i]更小，更新min即可，不会有更高的利润。
			} else{
				result = Math.max(result, prices[i] - min);   //min更小，需要计算一下min点买入，当前卖出的利润与之前的result对比，更新result。
			}
		}

		return result;
	}
}
