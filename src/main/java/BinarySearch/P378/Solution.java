package BinarySearch.P378;

import java.util.PriorityQueue;

/*
自己的做法，topK问题，显然最大堆。

时间复杂度：O(N*N*logK)，N为矩阵行数。遍历矩阵是N*N，堆的插入和删除时logK。             打败36.71%
空间复杂度：O(K)，最大堆占用的空间。                                                 打败99.30%
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(heap.size() < k){
                    heap.offer(matrix[i][j]);
                } else if(matrix[i][j] < heap.peek()){
                    heap.poll();
                    heap.offer(matrix[i][j]);
                }
            }
        }

        return heap.peek();
    }
}
