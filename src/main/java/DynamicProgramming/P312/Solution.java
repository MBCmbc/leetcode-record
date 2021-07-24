package DynamicProgramming.P312;

/*
官方题解，方法二：动态规划
看懵圈了，不是很懂。如果后面想搞明白就再去仔细看看官方题解吧。
先抄一波答案。
时间复杂度：O(N^3)      打败92.10%
空间复杂度：O(N^2)      打败86.71%
*/

class Solution {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[][] rec = new int[n+2][n+2];
		int[] val = new int[n+2];
		val[0] = val[n+1] = 1;
		for(int i=1; i<=n; i++){
			val[i] = nums[i-1];
		}

		for (int i=n-1; i>=0; i--){
			for(int j=i+2; j<=n+1; j++){
				for(int k=i+1; k<j; k++){
					int sum = val[i] * val[k] * val[j];
					sum += rec[i][k] + rec[k][j];
					rec[i][j] = Math.max(rec[i][j], sum);
				}
			}
		}

		return rec[0][n+1];
	}
}
