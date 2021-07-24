package Math.P224;

import java.util.ArrayDeque;
import java.util.Deque;

/*
栈+递归解决所有计算器问题
https://leetcode-cn.com/problems/basic-calculator/solution/java-zhan-di-gui-tong-yong-jie-fa-jie-ju-rtrt/
时间复杂度：打败32.15%
空间复杂度：打败12.95%
*/
class Solution {
	public int calculate(String s) {
		Deque<Character> queue = new ArrayDeque<>();
		for(char c : s.toCharArray()) {
			if(c != ' ') queue.offer(c);    //把所有的有效字符放入队列（即空格以外的字符）。
		}

		return dfs(queue);
	}

	private int dfs(Deque<Character> queue){        //根据queue，使用栈来递归计算表达式的值。
		Deque<Integer> stack = new ArrayDeque<>();  //栈，存储每一个num。

		int num = 0;                    //存储数字。
		char op = '+';                  //标记下一个要入栈的num前的运算符。
		while(!queue.isEmpty()){
			char c = queue.poll();      //取出队首元素，分情况计算。

			if(c == '(') num = dfs(queue);      //左括号进入递归；
			if(Character.isDigit(c)) num = num * 10 + (c - '0');

			if(!Character.isDigit(c) || queue.isEmpty()){    //遇到非数字（+、-、*、/、(、)）或队列内没有剩余元素了，都需要计算数值并入栈。
				if(op == '+'){          //数字前的运算符为‘+’，入栈正数
					stack.push(num);
				} else if(op == '-'){   //数字前的运算符为‘-’，入栈负数
					stack.push(-num);
				} else if(op == '*'){   //数字前的运算符为‘*’，把“前一数字”和当前num的乘积入栈
					int pop = stack.pop();
					stack.push(pop * num);
				} else if(op == '/'){   //数字前的运算符为‘/’，把“前一数字”/当前num的结果入栈
					int pop = stack.pop();
					stack.push(pop / num);
				}

				num = 0;
				op = c;     //入栈后，重置新的运算符和数字，供后面使用
			}

			if(c == ')') break;            //右括号说明当前子式结束，停止循环，在while循环后面返回括号内计算得到的值。
		}

		int res = 0;                    //栈内数字全加起来就是结果。
		for(int i : stack) res += i;
		return res;
	}
}
