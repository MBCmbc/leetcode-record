package Backtracking.P40;

/**
 * @Author MBC
 * @Date 2021/7/30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 参照大佬的思路，自己实现代码。依然是回溯+剪枝。
 https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/

 此题的关键在于如何去掉重复的组合，具体解决办法是先对candidates数组进行从小到大排序，然后对已经用过的元素进行剪枝，避免重复。

 时间复杂度：打败99.8%
 空间复杂度：打败95.09%
 */
class Solution2 {
    private List<List<Integer>> res;
    private int[] candidates;
    private int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先排序
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.res = new ArrayList<>();

        recur(new ArrayList<>(), 0 , 0);
        return res;
    }

    private void recur(List<Integer> path, int idx, int sum){
        //找到一组，入res
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        //后面的每个元素都可能用于path的这一层
        for(int i = idx; i < candidates.length; i++){
            //大剪枝。数组已经排序，当前元素加上后就已经超过target了，后面的元素更不可能符合要求
            if(sum + candidates[i] > target){
                break;
            }

            //小剪枝，同一层相同数值的节点，只用一个就行，避免重复结果。
            if(i > idx && candidates[i] == candidates[i-1]){
                continue;
            }

            //回溯
            path.add(candidates[i]);
            recur(path, i+1, sum+candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
