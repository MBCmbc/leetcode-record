package BinarySearch.P704;

/**
 就二分查找，简单。。。

 时间复杂度：O(logN)                     打败100%
 空间复杂度：O(1)                        打败77.6%
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
