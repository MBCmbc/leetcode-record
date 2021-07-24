package String.P557;

/*
自己的解法，双指针，思路与大佬做这道题的方法类似。
https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
思路：从左到右遍历字符串，用两个指针l和r分别标记一个单词的起始和结束，对该单词进行反转，然后继续遍历剩下的。

时间复杂度：O(N)，l和r指针都是一次遍历，反转单词部分整体加起来看也是线性时间复杂度。            打败99.84%
空间复杂度：O(N)，因为涉及到字符串改变，用字符数组暂存了字符串。                              打败96.22%
*/

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0, len = chars.length;
        while(r < len){
            while(l < len && chars[l] == ' ') l++;      //越过所有空格，找到单词的起始位置
            r = l;                                      //r跟上
            while(r < len && chars[r] != ' ') r++;      //跨过这个单词，找到单词的右边界
            reverse(chars, l, r-1);                     //反转单词
            l = r;                                      //l跟上
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int l, int r){   //反转字符串
        while(l < r){
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}
