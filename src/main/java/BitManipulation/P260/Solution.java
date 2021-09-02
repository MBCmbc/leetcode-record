package BitManipulation.P260;

/**
 * @Author MBC
 * @Date 2021/8/27
 */
/*
官方题解，方法一，分组异或。
https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leet-4i8e/

1. 将所有元素按位异或，得到的是两个所求元素相异或的结果。
2. 根据步骤1得到的结果，从右向左找到第一个为“1”的位，这是res1和res2不相同的第一个位，以此为标志，将数组元素分为两组。
3. 两组元素分别组内全员相异或，把出现两次的元素去掉，就得到最终结果。

时间复杂度：O(N)，两次遍历。                        打败100%
空间复杂度：O(1)。                                 打败90.85%
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        //先全员异或
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        //寻找元素分组的标志位
        int div = 1;
        while((div & xor) == 0){
            div <<= 1;
        }

        //根据标志位，分组异或，得到最终结果。
        int res1 = 0, res2 = 0;
        for(int num : nums){
            if((num & div) == 0){
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }

        return new int[]{res1, res2};
    }
}
