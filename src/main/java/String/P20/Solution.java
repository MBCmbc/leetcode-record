package String.P20;

/*
辅助栈做法，思路和大佬一样，自己实现了代码。
https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/
用一个栈存储输入的括号序列，根据有效括号序列的规律：
    1.若为左括号则直接入栈
    2.若为右括号，则前一个括号（即栈顶元素）必为对应的左括号（其他左括号也不行），查看是否符合，如不符合则判断为序列不合法，若符合则将栈顶元素出栈，
      表示该对括号有效（抵消了，像消消乐一样）。
遍历完输入序列，应该全部抵消，即栈为空。若符合则返回true，否则返回false。

时间复杂度：O(N)，N为字符串长度，需要遍历一次字符串。                                                       打败74.7%
空间复杂度：O(N)，合法情况下，栈最多存储N/2个左括号。若不合法也可能序列全为左括号，N个全都要存下来。            打败39.77%
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();    //栈

		for(char c : s.toCharArray()){
			if(c=='(' || c=='[' || c=='{'){             //左括号直接入栈
				stack.push(c);
			} else if(c == ')'){            //右括号判断栈顶元素与自己是否匹配，注意此时栈内要有元素才能进行匹配比较。
				if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else return false;          //若栈已空或不匹配，都说明序列不合法，直接返回false。
			}else if(c == ']'){
				if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
				else return false;
			}else if(c == '}'){
				if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
				else return false;
			}
		}

		return stack.isEmpty();     //若全部匹配成功，最后栈应为空。若不为空说明有多余括号未被匹配，返回false。
	}
}
