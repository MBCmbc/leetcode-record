package DynamicProgramming.P53;

/**
 * @Author MBC
 * @Date 2021/8/4
 */
/**
 自己的解法，前缀和 + 动态规划

 1. 用一个dp数组记录到各个位置为止的前缀和，为节省空间，dp[0]表示到nums[i-1]为止的前缀和，dp[1]表示到nums[i]为止的前缀和
 2. 用minPreSum记录到目前为止所有前缀和中的最小值
 3. 动态规划：
 1. 遍历数组，则res = Math.max(res, dp[1] - minPreSum);
 2. 其中 dp[1] - minPreSum表示以nums[i]为结尾的最大子序和。
 3. 更新minPreSum = Math.min(minPreSum, dp[1]);
 3. 更新dp[0]，为下一轮循环做准备。
 4. dp结束后，即可得到res。

 时间复杂度：O(N)，遍历一次数组。                    打败93.81%
 空间复杂度：O(1)，常数级别的额外空间。               打败70.78%
 */

class Solution2 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //dp[0]表示到nums[i-1]为止的前缀和，dp[1]表示到nums[i]为止的前缀和
        int[] dp = new int[2];
        //minPreSum表示到目前为止所有前缀和中的最小值
        int minPreSum = 0;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++) {
            dp[1] = dp[0] + nums[i];
            //更新res
            res = Math.max(res, dp[1] - minPreSum);
            //更新minPreSum
            minPreSum = Math.min(minPreSum, dp[1]);
            //更新dp数组，为下一轮循环做准备
            dp[0] = dp[1];
        }

        return res;
    }
}
