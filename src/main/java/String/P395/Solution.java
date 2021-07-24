package String.P395;

/*
大佬题解，分治+递归。（题解里对于递归的理解也很到位，可以细品）
https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
思路：
    1.先统计一下各字符的出现次数。若某字符总出现次数小于k，则要找的最长子串必然不包括该字符。
    2.所以，以出现次数小于k的字符为分隔符，对整个字符串进行拆分。
    3.对每个拆分得到的字符串，继续递归拆分寻找，直至不会再被拆分，就找到一个满足要求的子串。
    4.递归的过程中记录这些子串长度的max，返回即可。

时间复杂度：O(N*26*26)，递归最多26层，for循环遍历26次，每次拆分字符串需要O(N)。             打败64.48%
空间复杂度：O(26*26)，最多递归26层，每层需要一个大小为26的cnt数组。                         打败31.89%
*/

class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length(), res = 0;
        if(len < k) return 0;               //递归的终止条件。字符串长度小于k，不可能有字符重复k次。
        int[] cnt = new int[26];
        for(int i = 0; i < len; i++){       //统计字符串中各字符的出现次数。
            cnt[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(cnt[i] > 0 && cnt[i] < k){   //字符出现次数不足k，按该字符进行拆分
                for(String subString : s.split(String.valueOf((char)(i + 'a')))){
                    //对拆分出来的每个子串，递归计算满足要求的最长子串，并记录最大长度。
                    res = Math.max(res, longestSubstring(subString, k));
                }
                //只对第一个碰到的出现次数小于k的字符处理即可，其他出现次数小于k的字符，会在后续的递归过程中被处理。
                //直至子字符串满足题目要求
                return res;
            }
        }

        //如果出现次数都大于k，就说明当前字符串是满足要求的，返回len即可。
        return len;
    }
}
