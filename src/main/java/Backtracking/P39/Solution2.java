package Backtracking.P39;

import java.util.*;
/*
自己的实现，递归+回溯+剪枝。思想类似如下题解：
https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/

时间复杂度：打败20.46%
空间复杂度：打败13.59%
*/
class Solution2 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        Arrays.sort(nums);  //先排序，这是剪枝的前提
        recur(new LinkedList<Integer>(), 0, 0, target);
        return res;
    }

    public void recur(LinkedList<Integer> path, int start, int sum, int target) {
        if (sum == target) {                //找到一组结果，放入结果数组。
            res.add(new ArrayList<>(path));
            return; //因为都是正整数，后面再加数的话，和必然大于target，所以可以直接返回。
        } else if (sum < target) {     //递归查找
            for (int i = start; i < nums.length; i++) {
                path.addLast(nums[i]);
                recur(path, i, sum + nums[i], target);  //因为元素可以重复使用，所以从新的start还是i，而不是i+1
                path.removeLast();          //回溯记得删除最后一个节点。
            }
        }
        //若sum > target就直接返回了，相当于剪枝。
    }
}
