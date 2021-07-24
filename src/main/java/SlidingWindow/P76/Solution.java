package SlidingWindow.P76;

import java.util.HashMap;

/*
官方题解：滑动窗口。
https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
思路：1. 指针l和r构成一个滑动窗口，r先往右走，直到窗口内包含t中所有字符，然后l向左走，缩小窗口以找到最小子串。
     然后r再往右走寻找下一个最小子串，ansL和ansR记录全局最小子串的始末位置，ansLen记录全局最小子串的长度。
    2. 用两个HashMap，target记录t中各字符的个数，count记录当前子串内各字符的个数。（因为t中可能有重复字符，所以要记录个数）。
        通过比较两个map里各字符的个数，可以确定当前子串是否“覆盖”t。

时间复杂度：打败11.85%                  具体分析看题解。
空间复杂度：打败60.17%
*/
class Solution {
	HashMap<Character, Integer> target = new HashMap<>();   //t中各字符个数
	HashMap<Character, Integer> count = new HashMap<>();    //当前子串各字符个数。
	int ansL = -1, ansR = -1;       //更新记录全局最小覆盖子串的边界位置和长度。
	int ansLen = Integer.MAX_VALUE;
	public String minWindow(String s, String t) {
		int sLen = s.length(), tLen = t.length();
		for(int i = 0; i < tLen; i++){  //根据t构造target这个HashMap
			char c = t.charAt(i);
			target.put(c, target.getOrDefault(c, 0) + 1);
		}

		int l = 0, r= -1;   //滑动窗口的左右边界。
		while(r < sLen){
			r++;
			if(r < sLen && target.containsKey(s.charAt(r))){    //count只记录target中包含的字符在当前子串中的对应个数，其他字符无需记录。
				count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
			}

			while(check() && l <= r){   //在满足“覆盖”的条件下，尽量右移l，以缩小窗口，寻找“最小覆盖子串”。
				if(r - l + 1 < ansLen){ //当前子串更短，更新结果。
					ansL = l;
					ansR = r;
					ansLen = r - l + 1;
				}

				if(target.containsKey(s.charAt(l))){    //l右移如果对count造成了影响，要更新一下。
					count.put(s.charAt(l), count.get(s.charAt(l)) - 1); //因为进while前check了的，所以count.get()一定是存在且>=1的。
				}
				l++;
			}
		}
		//ansR为-1说明没找到；否则根据ansL和ansR的位置返回对应子串。
		return ansR == -1 ? "" : s.substring(ansL, ansR + 1);
	}

	//通过比较两个map的计数，检查当前子串是否满足“覆盖”。
	public boolean check(){
		for(Character c : target.keySet()){
			if(count.getOrDefault(c, 0) < target.get(c)) return false;
		}

		return true;
	}
}
