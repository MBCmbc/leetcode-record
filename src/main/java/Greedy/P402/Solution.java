package Greedy.P402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author MBC
 * @Date 2021/8/23
 */
/*
官方题解，贪心 + 单调栈
https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/

1. 想要使得删除后余下的数字尽量小，就应该让靠前的数字尽量小，这是贪心的思想。
2. 所以我们考虑使用单调栈【从栈底到栈顶单调不减】，记录删除后余下的数字。

时间复杂度：O(N)，遍历一次字符串，一次栈。                  打败48.41%
空间复杂度：O(N)，栈的大小。                                打败61.08%
*/

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();        //单调栈
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() > ch && k > 0){  //构造单调栈，但最多只能删k个数
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while(k > 0){           //若没删够k个，就删除最末尾的几个数字，直至删够k个。
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;                 //标记当前是否处于前导0阶段。
        while(!stack.isEmpty()){
            char ch = stack.removeLast();           //从栈底开始取数字，后续就不用再反转了。
            if(leadingZero && ch == '0') {          //前导0跳过
                continue;
            }

            leadingZero = false;
            res.append(ch);
        }

        return res.length() == 0 ? "0" : res.toString();        //若res为空，根据题意应该返回0，否则返回正常数字。
    }
}
