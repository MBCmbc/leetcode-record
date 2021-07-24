package JzOffer.P30;

/*
自己的解法，和题解思路大致相同，只不过helperStack中，存储的元素更多一些。

不同之处在于：helperStack存储的是到目前为止，stack中从bottom到同高度这一段元素中的最小值，也就是说helperStack始终和stack的size相同。

时间复杂度和空间复杂度，与题解相同。

时间复杂度：O(1)        打败70%
空间复杂度：O(N)        打败97.13%
*/

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack2 {
    private Deque<Integer> stack;
    private Deque<Integer> helperStack;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new ArrayDeque<>();
        helperStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        //无论那种情况，helperStack都会同步插入一个到目前为止所有元素中的最小值
        if(helperStack.isEmpty()){
            helperStack.push(x);
        } else{
            helperStack.push(Math.min(x, helperStack.peek()));
        }
    }

    public void pop() {
        //出栈时helperStack和stack保持同步出栈，即可维持最小函数功能。
        stack.pop();
        helperStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helperStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
