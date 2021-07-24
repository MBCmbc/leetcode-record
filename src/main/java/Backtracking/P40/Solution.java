package Backtracking.P40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
2021.4.11百度一面笔试题。递归+回溯。
https://leetcode-cn.com/problems/combination-sum-ii/solution/zu-he-zong-he-ii-by-leetcode-solution/
下面awsl的评论。

时间复杂度：打败41.67%
空间复杂度：打败5.16%
*/
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    //先排序，方便后面剪枝。
        recur(new LinkedList<>(), candidates, 0, 0, target);
        return res;
    }

    private void recur(LinkedList<Integer> path,  int[] candidates, int start, int sum, int target){
        if(sum == target){     //找到一个，放入res。
            res.add(new ArrayList<>(path));
            return; //因为都是正整数，后面再加数的话，和必然大于target，所以可以直接返回。
        } else if(sum < target){
            for(int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue; //避免重复的组合。
                path.add(candidates[i]);
                recur(path, candidates, i+1, sum + candidates[i], target);  //每个数只能用一次，所以用i+1作为新的start。
                path.removeLast();
            }
        }
        //若sum > target就直接返回了，相当于剪枝。
    }
}
