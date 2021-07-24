package Backtracking.P46;

/*
回溯算法，参考大佬题解。
https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
思路：dfs+回溯，求得所有全排列。

时间复杂度：O(N*N!)，N为数组长度，N!个排列结果，每个都需要O(N)时间复制到结果res里。                    打败96.61%
空间复杂度：O(N)，结果数组除外，递归调用栈的最大深度为N。                                             打败75.53%
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<List<Integer>> res = new ArrayList<>();    //结果
	int[] nums;
	int len;                //数组长度
	boolean[] used;         //标记数组中的某一个数在当前排列中是否已经用过了
	public List<List<Integer>> permute(int[] nums) {
		this.nums = nums;
		this.len = nums.length;
		this.used = new boolean[len];

		if(len == 0) return res;

		recur(new ArrayList<Integer>());
		return res;
	}

	//path表示当前已形成的排列
	public void recur(List<Integer> path){
		int depth = path.size();        //depth表示当前排列里已经有多少个数了，或者说是dfs的深度。
		if(depth == len){       //形成一种排列，注意因为java是浅拷贝，所以此时要new一个新的subRes存放排列结果，然后再放到结果res里。
			List<Integer> subRes = new ArrayList<>(path);
			res.add(subRes);
		}

		for(int i = 0; i < len; i++){   //对所有未使用过的数字，遍历进行所有可能的排列。
			if(!used[i]){
				path.add(nums[i]);      //排列延长
				used[i] = true;         //标记已用，防止dfs过程中重复使用某一数字。
				recur(path);            //进入下一位的排列
				path.remove(path.size() - 1);       //回溯，recur完成后回到本层，要把现场恢复到原来recur前的状态，以便进行下一种可能的排列。
				used[i] = false;
			}
		}
	}
}
