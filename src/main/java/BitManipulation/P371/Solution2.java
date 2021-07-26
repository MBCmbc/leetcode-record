package BitManipulation.P371;

/**
 * @Author MBC
 * @Date 2021/7/26
 */
/*
同剑指offer P65
自己的解法，递归。
将两个数字相加的过程，拆分为数值相加与进位相加两个过程，并用二进制的按位异或、按位与、按位左移，代替获取数值和进位的过程（证明见剑指offer）。
从而可以不用加减乘除得到两个数相加的结果。

时间复杂度：O(1)，最坏情况下a为0x7fffffff，b=1，需要循环32次，可认为是O(1)时间复杂度。      打败100%
空间复杂度：O(1)。同理                                                                   打败88.46%
*/
class Solution2 {
    public int getSum(int a, int b) {
        if(b == 0) return a;                //终止条件，进位为0
        int base = a ^ b;                   //按位异或与“按位加且不计进位”的效果是一样的。
        int carry = (a & b) << 1;           //“按位与后左移”与计算进位的结果是一样的。
        return getSum(base, carry);            //递归调用。
    }
}
