package Backtracking.P39;

/*
https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
DFS+剪枝。
*/

import java.util.*;

class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int len = candidates.length;

		// 排序是为了提前终止搜索，也即剪枝。
		Arrays.sort(candidates);

		dfs(candidates, len, target, 0, new ArrayDeque<Integer>(), res);

		return res;

	}

	/**
	 * @param candidates 数组输入
	 * @param len        输入数组的长度，冗余变量
	 * @param residue    剩余数值
	 * @param begin      本轮搜索的起点下标
	 * @param path       从根结点到任意结点的路径
	 * @param res        结果集变量
	 */
	public void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> res){
		if(residue ==0){
			// 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int i=begin; i<len; i++){
			// 在数组有序的前提下，剪枝(现在这个较小的值去搜索都搜不到了，用较大的值去搜肯定更搜不到了))
			if(residue-candidates[i] < 0) break;

			path.addLast(candidates[i]);
			dfs(candidates, len, residue-candidates[i], i, path, res);
			path.removeLast();
		}
	}
}
