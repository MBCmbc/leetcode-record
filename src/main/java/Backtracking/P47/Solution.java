package Backtracking.P47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
思路同 P46，dfs+回溯，只不过要去重。去重部分参考官方题解
https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/

时间复杂度：O(N*N!)，N为数组长度，N!个排列结果，每个都需要O(N)时间复制到结果res里。                 打败100%
空间复杂度：O(N)，结果数组除外，递归调用栈的最大深度为N，标记数组长度为n。                          打败63.31%
*/
class Solution {
	List<List<Integer>> res = new ArrayList<>();
	boolean[] used;      //标记数组中的某一个数在当前排列中是否已经用过了
	int[] nums;
	int len;      //数组长度

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);     //先排一下序，方便后面去重。
		this.nums = nums;
		this.len = nums.length;
		used = new boolean[len];
		List<Integer> path = new ArrayList<>();
		recur(path);
		return res;

	}

	//path表示当前已形成的排列
	public void recur(List<Integer> path) {
		if (path.size() == len) {     //看看当前path长度，或者说dfs深度，是否已排列完所有元素。
			res.add(new ArrayList<>(path));      //因为java是浅拷贝，所以要new一个。
			return;
		}

		for (int i = 0; i < len; i++) {      //对所有未使用过的数字，遍历进行所有可能的排列。
			//1.如果nums[i]已用，跳过，进入下一次循环。
			//2.去重，保证每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;

			path.add(nums[i]);     //排列延长
			used[i] = true;     //标记已用，防止dfs过程中重复使用某一数字。
			recur(path);      //进入下一位的排列
			path.remove(path.size() - 1);      //回溯，recur完成后回到本层，要把现场恢复到原来recur前的状态，以便进行下一种可能的排列。
			used[i] = false;
		}
	}
}
