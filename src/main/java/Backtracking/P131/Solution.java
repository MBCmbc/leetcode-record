package Backtracking.P131;

/*
自己的解法，递归+回溯。
因为题目要返回所有的分割方案，所以自然想到要用回溯。

时间复杂度：O(N * 2^N)，每个位置拆或不拆有2^N中可能，每种可能要判断是否为回文串需要O(N)。N为字符串s长度。              打败69.86%
空间复杂度：不计算保存答案的空间，为O(N)，递归调用栈深度最大为N                                                     打败89.75%

时、空间复杂度分析见题解方法一：
https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> res = new ArrayList<>();
    private String source;

    public List<List<String>> partition(String s) {
        this.source = s;
        recur(new ArrayList<String>(), 0);
        return res;
    }

    private void recur(List<String> path, int start){   //path保存已分割的回文子串，start表示未分割子串的开始位置
        if(start == source.length()){       //分割完毕，保存并返回
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start+1; i <= source.length(); i++){    //对所有可能的分割方案进行递归遍历。
            String sub = source.substring(start, i);
            if(check(sub)){     //确定这种方案分割出来的子串是回文串才进行下一步搜索
                path.add(sub);
                recur(path, i);
                path.remove(path.size() - 1);   //回溯
            }
        }
    }

    private boolean check(String sub){  //检查一个字符串是否为回文串。
        int l = 0, r = sub.length() - 1;
        while(l < r){
            if(sub.charAt(l) != sub.charAt(r)) return false;
            ++l;
            --r;
        }
        return true;
    }
}
