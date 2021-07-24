package Backtracking.P301;

/*
官方题解，方法一，dfs+回溯。
https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/shan-chu-wu-xiao-de-gua-hao-by-leetcode/
1. 先统计最少需要删除的左括号和右括号的数量
2. dfs的方式遍历原始字符串，构成有效字符串，对于每一个字符，有两种可能：
    2.1 不保留，即删除
    2.2 保留
   如果搜索到最后，正好把第一步统计的数量删完，则找到一个有效结果
3. 因为有可能出现重复，所以先用一个HashSet存储结果，以去重。最后返回时再转为List。

时间复杂度：打败92.59%
空间复杂度：打败80.87%
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private int len;    //原始字符串长度
    private char[] chars;   //原字符串转换为字符数组
    private Set<String> resSet = new HashSet<>(); //先用Set保存结果以去重

    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        this.chars = s.toCharArray();

        int leftRemove = 0, rightRemove = 0;    //统计最少需要删除的左括号和右括号的数量。
        for(char c : chars){
            if(c == '('){
                ++leftRemove;
            } else if(c == ')'){
                if(leftRemove == 0){    //在当前为')'时，若没有多余'('，说明需要删除当前')'
                    ++rightRemove;
                } else if(leftRemove > 0){  //若有多余'('，则抵消一对，'('可以少删一个。
                    --leftRemove;
                }
            }
        }

        dfs(0, 0,  0, leftRemove, rightRemove, new StringBuilder());
        return new ArrayList<String>(resSet);
    }

    /*
    index：当前遍历到的位置
    leftCount：当前path中已有的左括号数量
    rightCount：当前path中已有的右括号数量
    leftRemove：还需要删除的左括号数量
    rightRemove：还需要删除的右括号数量
    path：遍历到当前，已构成的字符串
    */
    private void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder path){
        if(index == this.len){
            if(leftRemove == 0 && rightRemove == 0) resSet.add(path.toString());    //找到一种可能结果
            return;
        }

        char ch = this.chars[index];
        //第一种可能，不保留当前遍历到的字符,即删除。
        if(ch == '(' && leftRemove > 0){
            dfs(index+1, leftCount, rightCount, leftRemove-1, rightRemove, path);
        } else if(ch == ')' && rightRemove > 0){
            dfs(index+1, leftCount, rightCount, leftRemove, rightRemove-1, path);
        }

        //第二种可能，保留当前遍历到的字符。
        path.append(ch);
        if(ch != '(' && ch != ')'){ //ch是英文字母，继续dfs
            dfs(index+1, leftCount, rightCount, leftRemove, rightRemove, path);
        } else if(ch == '('){
            dfs(index+1, leftCount+1, rightCount, leftRemove, rightRemove, path);
        } else if(rightCount < leftCount){  //当前为')'的情况下，必须rightCount < leftCount才可以保留。
            dfs(index+1, leftCount, rightCount+1, leftRemove, rightRemove, path);
        }
        path.deleteCharAt(path.length() - 1);   //回溯，别忘了删除最后一个字符！！！！！
    }
}
