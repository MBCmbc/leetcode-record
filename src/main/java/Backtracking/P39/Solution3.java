package Backtracking.P39;

/**
 * @Author MBC
 * @Date 2021/7/30
 */

import java.util.ArrayList;
import java.util.List;

/**
 回溯+剪枝，参考官方题解的思路，自己实现。
 https://leetcode-cn.com/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/

 1.对于这种需要记录路径的题目，大部分都能用到回溯，必要时可以剪枝。
 2.根据题意，在每次递归的时候，可以选择当前数字“不用”还是“用”：
 1.若不用的话，则直接跳过，也不需要回溯
 2.若用的话，就用回溯的方式进行查找。

 时间复杂度：o(S),其中S是所有可行解的长度之和。                                                      打败99.93%
 空间复杂度：O(target)，除答案数组外，空间复杂度取决于递归的栈深度，在最差情况下需要递归O(target)层         打败71.02%
 */
class Solution3 {
    private List<List<Integer>> res = new ArrayList<>();
    private int target;
    private int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;

        List<Integer> path = new ArrayList<>();
        recur(path, 0, 0);

        return res;
    }

    /**
     path：当前路径内已有元素
     idx：接下来要访问的元素下标（该元素可能用，也可能不用）
     sum：路径内元素和
     */
    private void recur(List<Integer> path, int idx, int sum){
        //防止下标越界
        if(idx >= candidates.length){
            return;
        }

        //找到一组，记录
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        //不用该元素，故直接跳过，
        recur(path, idx+1, sum);

        //用该元素，以回溯的方式继续查找
        if(sum+candidates[idx] <= target){
            path.add(candidates[idx]);
            recur(path, idx, sum+candidates[idx]);
            path.remove(path.size() - 1);
        }
    }
}
