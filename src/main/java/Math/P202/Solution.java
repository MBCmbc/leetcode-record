package Math.P202;

import java.util.HashSet;

/*
官方题解，方法一，用哈希集合检测循环
https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
根据题解分析，在计算过程中，有以下两种可能：
    1. 最终得到1
    2. 计算得到的数字之间形成一个环，进入无限循环。
所以用一个哈希表存储之前计算得到过的数字，如果当前数字不为1有重复则说明陷入循环，返回false。

时间复杂度：O(logN)。                             打败99.72%
空间复杂度：O(logN)，哈希表占用空间。               打败73.53%
*/
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();     //存储已经得到过得数字
        int curr = n;   //当前数字
        while(curr != 1){
            if(set.contains(curr)) return false;    //不为1且出现循环，返回false。
            set.add(curr);      //未提前返回，说明没有循环，当前数字加入哈希表。
            int next = getNext(curr);   //计算得到下一个数字
            curr = next;    //进入下一次循环
        }

        return true;    //while循环的中断条件就是curr == 1，可以返回true。
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
