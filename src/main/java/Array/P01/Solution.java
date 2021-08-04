package Array.P01;

import java.util.HashMap;

/**
 自己的解法，同官方题解2
 https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/

 遍历数组，用一个哈希表存储以往已经出现过的元素以及他们的下标；
 在后面继续遍历的过程中，查找哈希表中是否存在target-nums[i];
 存在则返回，否则继续遍历。

 时间复杂度：O(N)，遍历一遍数组                          打败85.82%
 空间复杂度：O(N)，哈希表的大小                          打败33.22%
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //哈希表，key为元素值，value为元素在数组中的下表
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                //找到一对，返回结果
                return new int[]{i, map.get(target-nums[i])};
            } else {
                //没有匹配项，当前元素放进哈希表，继续遍历
                map.put(nums[i], i);
            }
        }

        //遍历完都没有找到结果，返回一个空数组
        return new int[2];
    }
}
