package SlidingWindow.P438;

/*
参考大佬题解，思路一，滑动窗口+数组
https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-z-nx6b/
思路：因为字符串中只包含小写英文字母，所以考虑用长26的数组pCnt存储p中各个字符出现的次数。同时在s中维持一个长度为pLen的滑动窗口，统计窗口中各字符出现的次数sCnt，若统计结果和pCnt相同，则说明是一个字母异位词。

时间复杂度：O(N)，N为max(pLen, sLen-pLen)                   打败73.61%
空间复杂度：O(1)                                            打败86.37%
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if(sLen < pLen) return res;
        int[] sCnt = new int[26], pCnt = new int[26];   //sCnt表示s中滑动窗口内各字符出现次数，pCnt表示p内各字符出现次数。
        for(int i = 0; i < pLen; i++){  //初始化
            sCnt[s.charAt(i) - 'a']++;
            pCnt[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sCnt, pCnt)) res.add(0);   //为了避免出现越界异常，先额外处理offset为0的情况。

        for(int i = 0; i < sLen - pLen; i++){   //窗口滑动，统计不同窗口内的字符出现次数，并比较。
            sCnt[s.charAt(i) - 'a']--;          //每次滑动，左边少一个字符，右边多一个字符。只修改这些字符的统计即可。
            sCnt[s.charAt(i+pLen) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)) res.add(i+1);     //滑动后再统计比较的，所以begin位置其实是i+1
            //因为数组长度为常数，所以Arrays.equals()复杂度为O(1)
        }

        return res;
    }
}
