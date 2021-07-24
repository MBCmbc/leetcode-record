package JzOffer.P53_1;

/**
 自己的解法：
 先用二分法找一个target，然后以target为中心向两边扩散，寻找左右边界，即可计算得到target出现次数。

 时间复杂度：O(logN)，但最坏情况下，若数组里全是target，那就是O(N)           打败100%
 空间复杂度：O(1)                                                         打败80.26%
 */

class Solution3 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            //二分法找一个target
            int m = (l + r) / 2;
            if(nums[m] == target){          //找到target，向两边扩散寻找左右边界
                int p1 = m, p2 = m;         //p1是左边界，p2是右边界
                while(p1 >= 0 && nums[p1] == target){
                    p1--;
                }
                while(p2 < nums.length && nums[p2] == target){
                    p2++;
                }
                res = p2 - p1 - 1;
                break;
            } else if(nums[m] > target){
                r = m - 1;
            } else if(nums[m] < target){
                l = m + 1;
            }
        }

        return res;
    }
}
