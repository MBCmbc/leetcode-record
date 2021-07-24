package Array.P121;

/*
自己的解法，暴力搜索。用i标记买入时间，j标记卖出时间，从头到尾进行遍历，计算所有可能的收益，取最大值。
时间复杂度O(n^2)，空间复杂度O(1)。
*/

class Solution1 {
	public int maxProfit(int[] prices) {
		int result=0;
		for(int i=0; i<prices.length-1; i++){
			for(int j=i+1; j<prices.length; j++){
				result=Math.max(result, prices[j]-prices[i]);
			}
		}
		return result;
	}
}
