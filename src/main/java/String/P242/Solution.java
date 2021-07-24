package String.P242;

/*
自己的解法，因为字符串只包含小写字母，所以用一个长26的数组统计各个字母出现的次数，如果s和t中各字符出现的次数相等，则返回true，否则返回false。

时间复杂度：O(N)，N为字符串长度                         打败63.54%
空间复杂度：O(S)，S为字符集大小，此处S为26。             打败98.13%
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){    //统计s中各字符出现的次数
            int idx = s.charAt(i) - 'a';
            cnt[idx]++;
        }

        for(int i = 0; i < t.length() ;i++){    //减去t中各字符出现的次数
            int idx = t.charAt(i) - 'a';
            cnt[idx]--;
        }

        for(int i = 0; i < 26; i++){            //若相减结果为全0，说明是字母异位词，否则不是。
            if(cnt[i] != 0) return false;
        }

        return true;
    }
}