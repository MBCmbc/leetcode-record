package DynamicProgramming.P377;

/*
参考大佬解法，动态规划
https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/

* dp[i]表示和为i的组合的个数。
* 状态转移方程：dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
* 特别注意：dp[0] = 1，表示，如果那个整数的值刚刚好等于需要凑出的价值，这个就成为 1 种组合方案
* 再举一个具体的例子：nums=[1, 3, 4], target=7;
* dp[7] = dp[6] + dp[4] + dp[3]
* 即：7 的组合数可以由三部分组成，1 和 dp[6]，3 和 dp[4], 4 和dp[3];

时间复杂度：O(target * N),N表示数组长度。           打败98.68%
空间复杂度：O(target)，dp数组的大小                 打败36.22%
*/
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(num <= i) dp[i] += dp[i-num];    //当num==i，dp[i]+=dp[0](1)，也就是数num单独构成一种组合。
            }
        }

        return dp[target];
    }
}
