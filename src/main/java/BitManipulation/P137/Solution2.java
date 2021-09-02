package BitManipulation.P137;

/**
 * @Author MBC
 * @Date 2021/8/27
 */
/*
官方题解，方法二，依次确定每一个二进制位。
https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/

1. 除了res之外，所有的数字都出现三次，则他们的各二进制位上1出现的次数也是3的倍数.
2. 我们统计每一位上1出现的总次数，对3取余，把出现了3次的1去掉，就能得到res在该位是0还是1.

时间复杂度：O(32N) = O(N).                  打败89.99%
空间复杂度：O(1).                           打败83.58%
*/
class Solution2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        //int是32位的，对每一位都做相同的统计计算
        for(int i = 0; i < 32; i++){
            int total = 0;
            for(int num : nums){
                //统计当前位上1出现的次数
                total += ((num >> i) & 1);
            }
            //对3取余，确定res当前位是0还是1.
            if(total % 3 != 0){
                res |= (1 << i);
            }
        }

        return res;
    }
}
