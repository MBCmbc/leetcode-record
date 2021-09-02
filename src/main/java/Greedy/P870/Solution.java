package Greedy.P870;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author MBC
 * @Date 2021/8/31
 */
/*
田忌赛马问题，官方题解，贪心算法。
https://leetcode-cn.com/problems/advantage-shuffle/solution/you-shi-xi-pai-by-leetcode/

思路：
1. 如果 A 中最小的牌 a 能击败 B 中最小的牌 b，那么我们应当将它们配对。否则， a 将无益于我们的比分，因为它无法击败任何牌。
2. 我们为什么要在 a > b 时将 a 和 b 配对呢？这是因为此时在 A 中的每张牌都比 b 要大，所以不管我们在 b 前面放置哪张牌都可以得分。我们可以用手中最弱的牌来与 b 配对，这样会使 A 中剩余的牌严格地变大，因此会有更多得分点。

算法【贪心】：
1. 目前在 B 中要被击败的最小的牌将始终是 b = sortedB[j]。对于在 sortedA 中的每张卡 a，要么 a 能够击败牌 b（将 a 放入 map[b]），要么把 a 扔掉（将 a 放入 remaining）。
2. 之后，我们可以使用此前标注的 map 和 remaining 来重构答案。

时间复杂度：O(NlogN)。              打败54.5%
空间复杂度：O(N)。                  打败5.11%
*/

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        //先得到nums1和nums2的排序副本
        int[] sortedNums1 = Arrays.copyOf(nums1, len);
        Arrays.sort(sortedNums1);
        int[] sortedNums2 = Arrays.copyOf(nums2, len);
        Arrays.sort(sortedNums2);

        //存储找到nums1[i] - nums2[j]对应关系的元素，key为nums2的元素，value为nums1中满足条件的元素。
        Map<Integer, Deque<Integer>> map = new HashMap<>();     //这里Deque看作栈还是队列都行，只要能赢，无所谓先后关系。
        for(int num : sortedNums2){
            map.put(num, new ArrayDeque<>());
        }

        //nums1中无用的元素
        Deque<Integer> remaining = new ArrayDeque<>();

        int j = 0;
        for(int num : sortedNums1){
            //找到对应关系。因为nums2中可能有重复元素，所以用集合来存，又nums1也可能又重复元素，所以用Deque。
            if(num > sortedNums2[j]){
                map.get(sortedNums2[j++]).offer(num);
            } else {
                //无用元素
                remaining.offer(num);
            }
        }

        //构建排列好的A
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            Deque<Integer> deque = map.get(nums2[i]);
            if(deque.size() > 0){
                //有可以赢nums2[i]的元素，放进来。
                res[i] = deque.poll();
            } else {
                //没有对应元素，从无用元素中取一个放进来。
                res[i] = remaining.poll();
            }
        }

        return res;
    }
}
