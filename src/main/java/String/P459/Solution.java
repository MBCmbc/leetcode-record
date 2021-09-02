package String.P459;

/**
 * @Author MBC
 * @Date 2021/9/2
 */
/*
自己的解法，暴力。

思路：
1. 重复子串的长度可能为[1, len/2]，把所有可能的长度k都检查一下，是否能以重复子串的方式构成整个字符串。
2. 任一长度k满足条件就可以返回true了。

时间复杂度：O(N*N)，两层for循环。               打败73.81%
空间复杂度：O(1)。                             打败77.21%
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        //对所有可能的长度i进行检查
        for(int i = 1; i <= len / 2; i++){
            //长度i时len的因子才有可能满足条件。
            if(len % i == 0 && check(s, len, i)){
                return true;
            }
        }

        return false;
    }

    //len表示字符串的长度，k表示要check的子串长度。【其实就是字符串s的前k个字符】
    private boolean check(String s, int len, int k){
        //从第k个字符开始检查，通过取余计算得到其对应于要检查的子串中的位置，如果不相等就不满足条件。
        for(int i = k; i < len; i++){
            if(s.charAt(i) != s.charAt(i % k)){
                return false;
            }
        }

        return true;
    }
}
