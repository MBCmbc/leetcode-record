package Math.P202;

/*
官方题解，方法二，快慢指针法。
https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
根据题解分析，在计算过程中，有以下两种可能：
    1. 最终得到1
    2. 计算得到的数字之间形成一个环，进入无限循环。
在方法一的基础上改进，不使用哈希表存储，而是用快慢指针法判断是否有环（和判断链表是否有环的思想相同），优化空间使用。
此时我们的循环有两种可能：
    1. 快指针先找到1
    2. 快慢指针在换上相遇。

时间复杂度：O(logN)。分析复杂，见题解。                         打败99.72%
空间复杂度：O(1)。                                            打败83.42%
*/
class Solution2 {
    public boolean isHappy(int n) {
        int slow = n;               //慢指针
        int fast = getNext(n);      //快指针
        while(fast != 1){
            if(slow == fast) return false;      //发现循环，返回false
            slow = getNext(slow);               //慢指针走一步
            fast = getNext(getNext(fast));      //快指针走两步
        }

        return true;    //快指针走到了1，退出while循环。可以返回true
    }

    private int getNext(int num){   //计算一个数所有位的平方和
        int sum = 0;
        while(num != 0){
            int d = num % 10;
            sum += d * d;
            num /= 10;
        }
        return sum;
    }
}
