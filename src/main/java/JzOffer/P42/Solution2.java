package JzOffer.P42;

/*
自己的解法，前缀和。

用sum记录从nums[0]到nums[i]所有元素的和，也就是前缀和；
用minPreSum记录到目前为止所有位置前缀和的最小值。
则以nums[i]为结尾的连续子数组最大和，就是当下前缀和sum - minPreSum；
再用res时刻记录更新目前为止所有最大和中的“最大值”即可。

时间复杂度：O(N)，遍历一次数组。            打败98.75%
空间复杂度：O(1)。                          打败70.61%
*/

class Solution2 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;    //从nums[0]到nums[i]所有元素的和，也就是前缀和；
        int minPreSum = 0;  //到目前为止所有位置前缀和的最小值。

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];                             //当下前缀和
            res = Math.max(res, sum - minPreSum);       //以nums[i]为结尾的最大和，与前任res比较，取大者
            minPreSum = Math.min(minPreSum, sum);       //更新minPreSum
        }

        return res;
    }
}
