package Math.P89;

import java.util.ArrayList;
import java.util.List;

/*
大佬的镜面反射法，具体可以看题解。
https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
过程：1.初始化为n=0的情况，只有一个0
     2.进入循环：将集合内已有元素镜面反射，并将后半部分左侧补上1，前半部分不变（相当于左侧补0），直到位数为n。

时间复杂度：打败73.38%
空间复杂度：打败50.67%
*/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);         //初始化，只有一个0，对应n=0的情况
        int head = 1;       //最开始给左侧补1，相当于+1
        for(int i = 0; i < n; i++){                     //循环直到位数为n
            for(int j = res.size() - 1; j >= 0; j--){   //倒序遍历，达到镜面反射的效果
                res.add(head + res.get(j));             //+上head就是在左侧补1的操作。
            }
            head <<= 1;                                 //head左移一位，便于下次循环的时候左侧补1
        }

        return res;
    }
}
