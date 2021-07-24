package NiuKe.NC07;

/*
买卖股票的最好时机，同剑指offer P63
*/
public class Solution {
	/**
	 *
	 * @param prices int整型一维数组
	 * @return int整型
	 */
	public int maxProfit (int[] prices) {
		// write code here
		if(prices==null || prices.length <2) return 0;
		int min = prices[0];
		int res = 0;
		for(int i=1; i < prices.length; i++){
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return res;
	}
}
