package Greedy.P1647;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author MBC
 * @Date 2021/8/22
 */
/*
2021.8.22 - 网易互联网笔试题。大佬题解，贪心+去重
https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique/solution/tan-xin-si-xiang-tong-ji-qu-zhong-bu-xu-yao-pai-xu/

1. 先统计各个英文字符出现的次数，再用set去重。
2. 用一个set记录已经出现过的频次值，如果当前这个频次值出现过，就把频次值-1（意味着一次删除），直到得到一个没有出现过的频次值，或者为0。
3. 把新的频次值入set。

时间复杂度：O(N)，遍历字符串。                                                                                                                 打败81.04%
空间复杂度：O(sqrt(N))，最坏情况，各字符频次都不同。因为1+2+3+..+t = t*(t+1)/2，即t个频次值对应t^2长度的s，故s长n时，空间复杂度O(sqrt(N))            打败64.83%
*/

class Solution {
    public int minDeletions(String s) {
        //统计频次
        int[] cnts = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnts[s.charAt(i) - 'a']++;
        }


        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int cnt : cnts){
            if(cnt != 0){
                //不停进行删除操作，直至得到一个未出现过的频次值。
                //注意cnt>0才有意义，不能一直删，再删就负了。
                while(cnt > 0 && set.contains(cnt)){
                    cnt--;
                    res++;
                }
                //新频次值入set
                set.add(cnt);
            }
        }

        return res;
    }
}
