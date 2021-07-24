package Exam.WangYi.P4;

/*
满减优惠，给定一个无序数组int nums[n]，其中放的是n种商品的价格，商家规定满m元可以优惠y元，商品不重复购买，
那么从买家的角度看如何购买才能既享受优惠又花最少钱？
抽象成数学问题就是，从数组中取出若干个元素，使得它们之和sum为大于等于m的最小值。

思路：动态规划法，参考：https://blog.csdn.net/only_on_one/article/details/52337397
这是一个与0-1背包类似的问题，设二维数组dp[n+1][sum+1]中的任一项为dp[j][k]—从num[j],num[j+1],…,num[n-1]
中任取若干个，它们之和不超过k的最大值。
 */
public class Solution {
	public int manJian(int[] nums, int m, int y) {
		int n = nums.length;
		int sum = 0;
		for (int price : nums) sum += price;

		if (sum < m) return -1;            //全部都买了也达不到优惠条件。
		else if (sum == m) return (m - y);        //全部都买了，刚好达到优惠条件。

		//sum > m
		int[][] dp = new int[n + 1][sum + 1];    //dp[j][k]表示在商品价格数组里，从第j到最后一项商品中条，和不超过k的最大和选择方案。
		for (int i = m; i <= sum; i++) {    //在和从m到sum的范围内向上找，找到一个最小的可能和。
			for (int j = n - 1; j >= 0; j--) {    //从后往前遍历nums数组，填充dp数组
				for (int k = 0; k <= i; k++) {    //k表示选择方案所带来的可能和，即dp数组的第二维坐标。
					if (nums[j] > k) dp[j][k] = dp[j + 1][k]; //当前商品价格太高，一个商品就超过了k，不选择。(根据dp数组定义，dp项，也就是和，不能超过k)
						//两种情况：1.不选当前商品，则对应dp[j+1][k]；
						//         2.选当前商品，则对应第二项。j+1~n-1项商品中选不超过k-nums[j]的和，然后加上nums[j]
						//取二者中较大者，作为dp值。
					else dp[j][k] = Math.max(dp[j + 1][k], dp[j + 1][k - nums[j]] + nums[j]);
				}
			}
			if (dp[0][i] == i) return (i - y);    //找到一种方案，选出来和为恰好为m~sum之间的i，由于从小到大遍历，所以一定是最小的，返回。
		}
		//没找到这样的选择方案，又sum > m，想拿优惠的话，那只能把所有商品都买了。
		return (sum - y);
	}
}
/*
i从m逐步递增至sum过程中，一定会有一个i0使得：dp[0][i0]==i0，即从num[0],num[1],…,num[n-1]中任取若干个元素，
它们之和等于i0，并且最早出现的这样的i0就一定是大于等于m的最小值。此时，程序停止.
 */
