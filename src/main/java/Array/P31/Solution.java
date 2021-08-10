package Array.P31;

/**
 官方题解，方法一，两遍扫描。
 https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/

 其思路可以描述如下：
 1.从后向前查找第一个相邻升序的元素对 (idx, idx+1)，满足 A[idx] < A[idx+1]。此时 [idx+1,end) 必然是降序
 2.在 [idx+1,end) 从后向前查找第一个满足 A[idx] < A[k] 的 k。
 3.将 A[idx] 与 A[k] 交换
 4.可以断定这时 [idx+1,end) 必然是降序，逆置 [idx+1,end)，使其升序
 5.如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 该方法支持数据重复，且在 C++ STL 中被采用。

 时间复杂度：O(N)，至多扫描两遍数组，加一个数组反转。                        打败100%
 空间复杂度：O(1)，只需要若干常量空间。                                     打败86.44%
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;

        //1.寻找第一个满足A[idx] < A[idx+1]的idx
        while(idx >= 0 && nums[idx] >= nums[idx+1]){
            idx--;
        }

        if(idx >= 0){
            //2.从end向前找第一个满足 A[idx] < A[k] 的 k。
            int k = nums.length - 1;
            while(k > idx && nums[k] <= nums[idx]){
                k--;
            }
            //3.将 A[idx] 与 A[k] 交换
            swap(nums, idx, k);
        }
        //4.逆置 [idx+1,end)，使其升序
        //5.如果步骤1找不到符合条件的idx，说明 [begin,end)整体降序，则整体反转
        reverse(nums, idx + 1);
    }

    //将nums数组，从下表start开始，反转。
    private void reverse(int[] nums, int start){
        int left = start, right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    //交换nums数组中，下标x和下表y的两个数
    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
