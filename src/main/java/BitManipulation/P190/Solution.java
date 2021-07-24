package BitManipulation.P190;

/*
官方题解，方法一，逐位颠倒。
https://leetcode-cn.com/problems/reverse-bits/solution/dian-dao-er-jin-zhi-wei-by-leetcode-solu-yhxz/
将n看作一个长32位的二进制串，从低位往高位枚举n的每一位，将其倒序添加到翻转结果res中.
代码实现中，每枚举一位就将n右移一位，这样当前n的最低位就是我们要枚举的比特位。

时间复杂度：O(1)，确定循环32次。            打败100%
空间复杂度：O(1)。                        打败64.45%
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res |= (n & 1) << (31 - i);     //n的最低位就是我们当前要枚举的位，将其放到res对应的颠倒位上。
            n >>= 1;    //n右移一位，将要枚举的下一位移到最低位。（此处用普通右移还是无符号右移都可以，因为我们限制了枚举长度是32，高位补进来的符号位不会造成影响）
        }
        return res;
    }
}
