package Array.P283;

/**
 * @Author MBC
 * @Date 2021/8/27
 */
/*
官方题解，双指针。
https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/

1. 使用双指针，左指针指向已经处理好的序列的尾部，右指针指向待处理序列的头部。
2. 在未遇到0之前，左右指针同步移动；遇到0之后，左指针始终指向第一个0，右指针仍指向待处理序列的头部。
3. 右指针不断右移，遇到非0数，就将左右指针对应的数交换，同时左指针右移。
4. 注意到如下性质：
    a. 左指向左边都是非0数
    b. 右指针左边到左指针处均为0。
5. 因为每次交换，都是将左指针的零与右指针的非零数交换，所以非零数的相对顺序并未改变。

时间复杂度：O(N)，线性遍历。            打败100%
空间复杂度：O(1)。                     打败35.9%
*/
class Solution4 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            //遇到非零数，左右指针对应元素交换，同时做指针右移，确保始终指向第一个0.
            if(nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
