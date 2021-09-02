package Backtracking.P22;

import java.util.ArrayList;
import java.util.List;

/*
官方题解，方法二，回溯。
https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/

1. 需要记录所有的括号组合，自然想到回溯的方法。
2. 但是要满足n >= l >= r才可能是合法的括号序列，要注意仔细分析【剪枝、以及开启下一层回溯的条件】。

时间复杂度：打败100%
空间复杂度：打败67.21%
*/
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recur(new StringBuilder(), 0, 0, n);
        return res;
    }

    //l：已有左括号数量，r：已有右括号数量，n:输入参数
    private void recur(StringBuilder path, int l, int r, int n){
        if(l == n && r == n){           //找到一个
            res.add(path.toString());
            return;
        }

        //括号序列要合法，必须满足 n >= l >= r，即 n >= l && l >= r，否则就剪枝。
        if(n < l || l < r){
            return;
        }

        //在满足n >= l >= r的基础上，n > l时才能加左括号，进行回溯递归
        if(n > l){
            path.append('(');
            recur(path, l+1, r, n);
            path.deleteCharAt(path.length() - 1);
        }

        //在满足n >= l >= r的基础上，l > r时才能加右括号，进行回溯递归
        if(l > r){
            path.append(')');
            recur(path, l, r+1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
