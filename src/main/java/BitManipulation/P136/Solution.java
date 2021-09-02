package BitManipulation.P136;

/**
 * @Author MBC
 * @Date 2021/8/26
 */
/*
自己的解法，按位异或。

思路：
1. 根据按位异或的特性【相同为0，不同为1】，将数组中所有数字遍历并按位异或，所有出现过两次的数字将被异或为0，
2. 而任何数和0异或仍得到该数字本身。
3. 按这种思路，最终得到的就是哪个只出现了一次的数字。

时间复杂度：O(N)，遍历一次数组。                    打败100%
空间复杂度：O(1)，只使用常数额外空间。               打败33.76%
*/
class Solution {
    public int singleNumber(int[] nums) {
        //任何数和0异或都得到本身，所以res初始化为0。
        int res = 0;
        //数组全部元素都参与按位异或，最终将得到只出现了一次的数字。
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}
