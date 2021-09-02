package BitManipulation.P137;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author MBC
 * @Date 2021/8/27
 */
/*
自己的解法，哈希表。

1. 遍历数组，用一个哈希表统计各元素的出现次数。
2. 遍历哈希表，找到那个只出现了一次的元素。

时间复杂度：O(N)，遍历数组和哈希表。                打败20.58%
空间复杂度：O(N），哈希表的大小。                   打败56.99%
*/
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //统计出现次数
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        //遍历哈希表，寻找只出现了一次的元素。
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                res = key;
                break;
            }
        }

        return res;
    }
}
