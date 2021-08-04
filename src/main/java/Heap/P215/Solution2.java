package Heap.P215;

/**
 * @Author MBC
 * @Date 2021/8/3
 */

import java.util.PriorityQueue;

/**
 自己的解法，用最小堆。

 但是看题解居然是自己实现了一个堆，手动进行堆的构造和调整，优点惊了。。。。

 时间复杂度：打败52.2%
 空间复杂度：打败36.4%
 */
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums){
            heap.offer(num);
            if(heap.size() > k){
                heap.poll();
            }
        }

        return heap.peek();
    }
}
