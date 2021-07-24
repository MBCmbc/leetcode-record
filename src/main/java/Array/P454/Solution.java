package Array.P454;

/*
官方题解，分组+哈希表
https://leetcode-cn.com/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
思路：将A和B看作一组，C和D看作一组。
    1.先计算A和B中各元素相加的可能和，用一个哈希表统计所有可能和出现的次数。
    2.再计算C和D中各元素相加的可能和sum，看哈希表中是否存在和为-sum的数，有就在res加上出现次数，没有就不加。

时间复杂度：O(N*N)，双重for循环遍历。               打败43.45%
空间复杂度：O(N*N)，哈希表的大小。                  打败71.32%
*/

import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();        //统计A和B各元素相加的可能和
        for(int u: nums1){
            for(int v : nums2){
                int k = u + v;
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }

        for(int u : nums3){                         //计算C和D中所有元素的可能和sum，并根据map中是否有-sum，统计res。
            for(int v : nums4){
                int k = -(u + v);
                res += map.getOrDefault(k , 0);
            }
        }

        return res;
    }
}
