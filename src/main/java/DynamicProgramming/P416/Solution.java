package DynamicProgramming.P416;

/*
最高赞回答：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/

思路：
    转化为0-1背包问题，是否可以从输入数组中挑出一部分数，使得他们的和为整个数组和的一半。
    并利用了巧妙的初始化优化和空间优化。

    状态转移方程：
        对于dp[i][j]（前i个数中找出一个子集和为j），只有两种方案，用或是不用nums[i]这个数：
            1.不用，相当于前i-1个数中找出一个子集和为j，即dp[i-1][j]
            2.用，相当于前i-1个数中找出一个子集和为j-nums[i]，即dp[i-1][j-nums[i]]
        故 dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]

时间复杂度：O(NC)，其中N为数组长度，C为数组和的一半         打败89.51%
空间复杂度：O(C)                                        打败84.28%
*/

class Solution {
	public boolean canPartition(int[] nums) {
		int len = nums.length;
		//数组为空或只有一个元素，必然为false
		if (len < 2) return false;

		int sum = 0;
		for(int num : nums){
			sum += num;
		}

		//和为奇数，不可能分为两个和相等的子集。
		if((sum&1) == 1) return false;

		int target = sum/2;
		//动态规划数组，长为[target+1]，表示和为0~target的“目标值”能否为true。
		boolean[] dp = new boolean[target+1];
		//目标值为0，所有元素成为一组，空元素集成为一组，即可满足条件。
		dp[0] = true;

		//nums[0]<=target时，nums[0]自己一个数可以分为一组，表示和为nums[0]的子集，故dp[nums[0]]=true
		if(nums[0] <= target) dp[nums[0]] = true;

		//第0行的情况上面一行代码已经初始化（只用第0个数组成子集，只有target为nums[0]才可能为true），从第1行开始遍历即可。
		for(int i=1; i<len; i++){
            /*
            运用了空间优化：每一行都由上一行得来，而且当前行总是参考了它上面一行 「头顶上」 那个位置和「左上部分」某个位置的值
            所以使用空间优化将二维数组降为一维数组后，更新数组必须从后往前。
            本轮迭代，更新某个位置的值可能会需要用到动态规划数组中前面某个位置的值，从前往后更新会造成原本值被覆盖而无法使用，所以要从后往前。
            */
            /*
            另外，一旦不满足j>=nums[i]就可以直接退出当前循环，因为后面的j会越来越小，没有必要判断，直接进入外循环的下一层即可，相当于剪枝。
                1.从转移方程可知j-nums[i]>=0必须满足。
                2.或者可以理解为，状态转移方程中的第二种情况（使用当前nums[i]）已经不可能出现（nums[i]比target还大，不可能用）。只有第一种情况，
                  即dp[i][j]=dp[i-1][j]，而动态规划数组尚未被更新的前半部分就是dp[i-1][j]，所以也不用再更新。
            */
			for(int j=target; j>=nums[i]; j--){
				//不管是第几行，若最后一个元素为true，由状态转移方程的第一种情况可知，最后一列的剩下所有元素一定全为true，
				//而我们要求的值也就是动态规划数组的最后一行最后一个元素dp[len-1][target]，顾可以直接返回true。
				if(dp[target]) return true;

				//状态转移方程
				dp[j] = dp[j] || dp[j-nums[i]];
			}
		}

		return dp[target];
	}
}
