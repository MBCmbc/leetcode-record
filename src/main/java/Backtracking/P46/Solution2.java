package Backtracking.P46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 自己的解法，回溯+swap
 * <p>
 * 问题的关键在于怎么知道哪些数字用过了，哪些没用过。我的解决办法是：通过swap，把用过的数字都交换到到左侧，进行搜索。回溯的时候再swap回去就可以了。
 * 这样不会对后面的搜索造成影响，还能找到所有的排列结果。
 * <p>
 * 时间复杂度：O(N*N!)，N为数组长度，N!个排列结果，每个都需要O(N)时间复制到结果res里。                 打败91.21%
 * 空间复杂度：O(N)，结果数组除外，递归调用栈的最大深度为N。                                          打败98.35%
 */
class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    private int len;        //nums数组长度
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        recur(new LinkedList<>(), 0);
        return res;
    }

    //path表示已加入排列的数字，idx表示这一层递归是排列的第几个数字。
    private void recur(LinkedList<Integer> path, int idx) {
        //找到一个排列
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
        }

        //因为我们的swap做法，idx及其右边的都是都是没用过的数字，遍历搜索。
        for (int i = idx; i < len; i++) {
            //先把要用的数字swap到idx这里来再用，保证每次都是在idx处开始递归查找，并且也不会出现重复使用某一数字。
            swap(idx, i);
            path.add(nums[idx]);
            recur(path, idx + 1);
            //回溯，记得把用完的数字swap回原位置。
            path.removeLast();
            swap(idx, i);
        }
    }

    private void swap(int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
