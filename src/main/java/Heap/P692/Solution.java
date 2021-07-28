package Heap.P692;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 自己的思路，HashMap+堆。自己实现但遇到了一些小问题，又参考了官方题解。
 * https://leetcode-cn.com/problems/top-k-frequent-words/solution/qian-kge-gao-pin-dan-ci-by-leetcode-solu-3qk0/
 *
 * 先用一个HashMap统计各个单词的出现次数，然后针对TopK问题，用堆的方式来解决。
 * 但题目有另外要求“如果不同的单词有相同出现频率，按字母顺序排序”，在自定义排比较器里要注意处理。
 *
 * 时间复杂度：O(l*n+m*l*logk)，其中n表示给定字符串序列的长度，m表示实际字符串种类数，l表示字符串的平均长度。我们需要l*n的时间将字符串插入到哈希表中，以及每次插入元素到优先队列中都需要l*logk的时间，共需要插入m次。                      打败99.79%
 *
 * 空间复杂度：O(l*(m+k))，其中l表示字符串的平均长度，m表示实际字符串种类数。哈希表空间占用为O(l*m)，优先队列空间占用为O(l*k)。        打败10.94%
 *
 * @Author MBC
 * @Date 2021/7/28
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //统计各单词出现次数
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //k个出现次数最多的，用最小堆。
        //又因为要求“如果不同的单词有相同出现频率，按字母顺序排序”，在出现次数相同的情况下要额外处理。
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });

        //对于固定size大小的堆，用下面这种方式处理更优雅，也更鲁棒。
        //新元素先入堆，再把额外的堆顶剔除。
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll().getKey());
        }
        //因为最小堆，先poll出来的是出现次数较少的，所以需要reverse一下。
        Collections.reverse(res);
        return res;
    }
}
