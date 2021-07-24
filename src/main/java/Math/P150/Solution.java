package Math.P150;

import java.util.ArrayDeque;
import java.util.Deque;

/*
自己实现，根据题目描述中最后的说法，用栈的方式存储并计算即可。

时间复杂度：O(N),遍历tokens数组。                                           打败63.15%
空间复杂度：O(N)，栈的大小，栈内元素个数不会超过tokens数组长度。                打败88.66%
*/
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                }
            }
        }
        return stack.peek();
    }

    private boolean isNumber(String token){
        return !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
