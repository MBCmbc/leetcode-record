package Array.P84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 官方题解，方法一，单调栈
 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/

 1. 这里的单调栈，就是栈内元素由底至顶必须是单调递增的，如果新来的元素 <= 栈顶元素，就要把栈顶元素出栈，直至栈空。
 2. 通过单调栈的方式，我们可以确定heights[i]向两遍扩展时，第一个高度小于heights[i]的位置，也就是矩形边界，从而确定heights[i]向两边扩展开来的矩形面积。
 3. 通过从左向右和从右向左两次遍历，我们可以确定每个“矩形”的左右边界，从而确定矩形面积。

 时间复杂度：O(N)，遍历两次heights数组。                             打败62.51%
 空间复杂度：O(N)，left数组、right数组以及单调栈的大小。              打败79.80%
 */

class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];      //记录每个矩形的左边界，heights[i]向左第一个高度小于heights[i]的位置，若左边都大于heights[i]，则记-1
        int[] right = new int[len];     //同理，记录右边界，若都大于heights[i]，记len

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            //因为要找第一个高度小于heights[i]的位置，所以要用<=
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
