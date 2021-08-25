package SlidingWindow.P03;

import java.util.HashSet;

/**
 * 同剑指offer P48
 * 自己的解法，滑动窗口法。
 * 1. 用两个指针l和r分别标记窗口的左边界和右边界（左闭右开），用一个HashSet记录窗口内所有的字符；
 * 2. 每次r所指新字符：
 *  a. 若窗口中没有该字符，就加入窗口；
 *  b. 若窗口中有该字符，就不断将l右移，直至窗口中没有该字符。
 * 3. 每次窗口扩大，实时更新记录res
 * <p>
 * 时间复杂度：O(N)，遍历一次字符串。                                                                        打败91.8%
 * 空间复杂度：O(1)，字符的ASCII标的范围是0~127，哈希表最多使用O(128) = O(1)的额外空间。                       打败75.94%
 */

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;      //窗口左边界
        int r = 0;      //窗口右边界
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        while (r < len) {
            char chR = s.charAt(r);
            if (!set.contains(chR)) {                 //新字符再窗口中没有出现过，扩大窗口右边界
                res = Math.max(res, r - l + 1);     //更新结果
                set.add(chR);                       //新字符入集合
                r++;                                //扩大窗口
            } else {
                //r边界字符在窗口中出现过，则不停右移左边界，直至窗口中删去该字符。
                while (s.charAt(l) != chR) {
                    set.remove(s.charAt(l));
                    l++;
                }
                //由于循环结束时，l指针正好位于重复字符上，所以需要再移一次
                set.remove(s.charAt(l));
                l++;
            }
        }

        return res;
    }
}
