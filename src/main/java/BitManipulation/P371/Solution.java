package BitManipulation.P371;

/*
同剑指offerP65
题解：https://leetcode-cn.com/problems/sum-of-two-integers/solution/li-yong-wei-cao-zuo-shi-xian-liang-shu-qiu-he-by-p/
将两个数字相加的过程，拆分为数值相加与进位相加两个过程。数值相加就用按位异或代替；进位的计算就用按位与并左移一位来代替。
将得到的数值相加结果和进位结果再相加。如此循环，直至进位为0，就说明得到了最终的计算结果。

时间复杂度：打败100%
空间复杂度：打败92.38%
*/
class Solution {
    public int getSum(int a, int b) {
        while(b != 0){          //b==0可以直接返回a；b!=0就进入循环计算。
            int tmp = a ^ b;    //tmp暂存数值相加的结果
            b = (a & b) << 1;   //用b存储进位
            a = tmp;            //把数值相加的结果赋给a，进入下一轮循环，相加结果(a)和进位结果(b)作为新的加数进行相加计算
        }                       //直至进位为0，最终的相加结果就存在了a里。
        return a;
    }
}
