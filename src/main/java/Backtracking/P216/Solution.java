package Backtracking.P216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
递归+回溯

时间复杂度：打败100%
空间复杂度：打败78.49%
*/
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int target;
    private int total;

    public List<List<Integer>> combinationSum3(int k, int n) {
        total = k;
        target = n;
        recur(new LinkedList<Integer>(), 1, 0, 0);
        return res;
    }

    /*
    path：组合内已有的数字
    start：开始搜索的范围
    sum：已有数字的和
    cnt：已有数字的个数
    */
    private void recur(LinkedList<Integer> path, int start, int sum, int cnt){
        if(sum == target && cnt == total){  //找到一种组合，放入结果并返回。
            res.add(new ArrayList<Integer>(path));
            return;
        }

        if(cnt < total && sum < target){    //只有在cnt<k且sum<n的情况下，才有必要继续搜索。
            for(int i = start; i <= 9; i++){
                path.add(i);
                recur(path, i+1, sum+i, cnt+1); //递归+回溯。
                path.removeLast();
            }
        }
    }
}
