package Backtracking.P22;

import java.util.ArrayList;
import java.util.List;

/*
官方题解，方法二，回溯。
https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
需要记录所有的括号组合，自然想到回溯的方法。

时间复杂度：打败96.62%
空间复杂度：打败26.48%
*/
class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), 0, 0, n);
        return res;
    }

    //left：已有左括号数量，right：已有右括号数量，n:输入参数
    private void backTrack(StringBuilder curr, int left, int right, int n){
        if(left == right && left == n){
            res.add(curr.toString());
            return;
        }

        if(left < right) return;    //剪枝

        if(left < n){               //left未满n，可以加一个左括号
            curr.append('(');
            backTrack(curr, left+1, right, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(left > right){           //left更大，可以加一个右括号
            curr.append(')');
            backTrack(curr, left, right+1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        //其他情况，如left > n等，因为没有对应的if函数，所以不会进入下一步回溯，直接走到最后return了。
    }
}
