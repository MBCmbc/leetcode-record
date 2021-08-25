package Stack.P232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author MBC
 * @Date 2021/8/24
 */
/*
自己的解法，和剑指offer P09思路一致，只不过题目要求实现的函数略有不同。

用两个先进后出的栈进行组合，即可达到队列先进先出的效果，关键点在于：
1. 入队时，都入stack1
2. 出队时，先从stack2取；若stack2为空，就先把stack1都元素都取出来放到stack2，再从stack2取。

时间复杂度：打败100%
空间复杂度：打败64.84%
*/
class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {   //入队直接入stack1
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //stack2为空才把stack1的元素搬过来，否则直接取stack2栈顶元素。
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        //stack2为空才把stack1的元素搬过来，否则直接取stack2栈顶元素。
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        //两栈皆空才为空。
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
