package Array.P121;

/*
官方解法，解法二。一次遍历
只遍历一次数组，在遍历过程中每遍历到一个点都假设要在此点卖出，这时我们自然期望是在此点之前的历史最低点买入的。
所以我们需要时刻更新已经遍历过的点的最小值，表示之前的历史最低点，用以计算当前点可以得到的最大收益。
并在遍历过程中不断更新最大收益，保证拿到全局最大收益。
这样，一次遍历之后我们就可以得到最终要计算的最大收入。

只需要一次遍历，所以时间复杂度O(N)；
只用了常数量个额外空间，所以空间复杂度O(1)。
*/

class Solution2 {
	public int maxProfit(int[] prices) {
		//初始化历史最低值和最大收益
		//int minPrice = prices[0];    不能用prices[0]初始化，因为测试用例可能是一个空数组，会造出数组越界异常。
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		//一次遍历
		for(int i=0; i<prices.length; i++){
			//如果当前节点值比历史最低点还低，就更新历史最低值为当前值。
			//而且如果当前节点比历史最低点还要低，就肯定不能在此点卖出，否则收益将是负的，所以不需要更新最大收益。
			if(prices[i] < minPrice){
				minPrice = prices[i];
			} else {
				//当前节点不是最低点,分两种情况：
				//  一、当前节点能得到的最大收益大于已知最大收益，则更新最大收益；
				//  二、当前节点能得到的最大收益不大于已知最大收益，则不需要更新。
				//所以只需对第一种情况做处理即可。
				if(prices[i]-minPrice > maxProfit) maxProfit = prices[i]-minPrice;
			}
		}

		//遍历结束，返回最大值。
		return maxProfit;
	}
}
