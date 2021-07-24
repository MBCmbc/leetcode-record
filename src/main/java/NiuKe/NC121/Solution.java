package NiuKe.NC121;

import java.util.ArrayList;

/*
字符串的全排列，同leetcode P47,只不过一个是int数组，一个是字符串。
题目里没说清楚，应该要去重。
 */
public class Solution {
	ArrayList<String> res = new ArrayList<>();
	int len;
	boolean[] used;
	char[] chars;

	public ArrayList<String> Permutation(String str) {
		if (str == null || str.length() == 0) return res;
		chars = str.toCharArray();
		len = str.length();
		used = new boolean[len];
		recur("");
		return res;
	}

	public void recur(String s) {
		if (s.length() == len && !res.contains(s)) {
			res.add(s);
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!used[i]) {
				s += chars[i];
				used[i] = true;
				recur(s);
				s = s.substring(0, s.length() - 1);
				used[i] = false;
			}
		}
	}
}
