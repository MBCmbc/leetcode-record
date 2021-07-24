package JzOffer.P14_2;

/*
大佬题解，贪心解法
https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/jian-zhi-offer-14-ii-jian-sheng-zi-iihua-r5op/
思路：尽量把绳子拆成长度为3的段（特殊情况，若恰好剩4，则拆成2*2，而不是3*1）
因为动态规划取余会对后面的计算结果造成影响，所以此题只能用贪心。

时间复杂度：O(N)        打败100%
空间复杂度：O(1)        打败99.58%
*/

class Solution {
    public int cuttingRope(int n) {
        //n=2,返回1，n=3,返回2，两种情况合并。
        if(n < 4) {
            return n - 1;
        }

        //因为1000000006*3超过了int的存储范围，所以要用long型存储。
        long res = 1;
        //尽量拆成长度为3的段
        while(n > 4){
            res = res * 3 % 1000000007;     //过程中取余，和最后统一取余的结果是一样的。
            n -= 3;
        }

        //最后剩余长度可能为2、3或4：
        //2和3的情况是直接乘；4是拆成2*2再乘，也相当于直接乘，所以可以合并。
        return (int)(res * n % 1000000007);
    }
}
