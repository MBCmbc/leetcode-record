package Array.P85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 思路同官方题解方法二，单调栈，自己实现。
 https://leetcode-cn.com/problems/maximal-rectangle/solution/zui-da-ju-xing-by-leetcode-solution-bjlu/

 1. 将矩阵的每一行抽象转换成以当前行为底的heights矩阵，然后带入P84的计算函数，可以得到以当前行为底的最大矩形面积。
 2. 对每一行都进行同样的计算，就可以得到整个矩阵中最大的矩形面积。

 时间复杂度：O(rows * cols)，构造heightsMatrix矩阵需要O(rows*cols)的时间，计算也需要O(rows*cols)的时间。             打败70.05%
 空间复杂度：O(rows * cols)，heightsMatrix矩阵的大小。                                                             打败96.06%
 */
class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] heightsMatrix = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heightsMatrix[i][j] = i == 0 ? 1 : heightsMatrix[i-1][j] + 1;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < rows; i++){
            res = Math.max(res, largestRectangleArea(heightsMatrix[i]));
        }

        return res;
    }

    /**
     P84的单调栈解法，直接拿过来用。
     1. 这里的单调栈，就是栈内元素由底至顶必须是单调递增的，如果新来的元素 <= 栈顶元素，就要把栈顶元素出栈，直至栈空。
     2. 通过单调栈的方式，我们可以确定heights[i]向两边扩展时，第一个高度小于heights[i]的位置，也就是矩形边界，从而确定heights[i]向两边扩展开来的矩形面积。
     3. 通过从左向右和从右向左两次遍历，我们可以确定每个“矩形”的左右边界，从而确定矩形面积。
     时间复杂度：O(N)
     空间复杂度：O(N)
     */
    private int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];      //记录每个矩形的左边界，heights[i]向左第一个高度小于heights[i]的位置，若左边都大于heights[i]，则记-1
        int[] right = new int[len];     //同理，记录右边界，若都大于heights[i]，记len

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            //因为要找第一个高度小于heights[i]的位置，所以要用>=
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            //记录左边界，越界则记-1
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        //清栈，再次遍历，记录右边界。
        stack.clear();
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        //计算每个矩形的大小，记录最大值。
        int res = 0;
        for(int i = 0; i < len; i++){
            res = Math.max(res, (right[i]-left[i]-1) * heights[i]);
        }

        return res;
    }
}
