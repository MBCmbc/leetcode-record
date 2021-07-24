package Greedy.P179;

/*
贪心解法,借用比较器帮我们比较，两个字符串如放置才能取得最大值。即(s1+s2)和(s2+s1)比较。
https://leetcode-cn.com/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/

时间复杂度：与Arrays.sort()底层有关，最坏情况下使用插入排序，为O(N*N)。         打败77.56%
空间复杂度：O(N)，额外的strings数组。                                        打败76.32%
*/

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strings = new String[len];
        for(int i = 0; i < len; i++) strings[i] = String.valueOf(nums[i]);  //改用字符串存储
        Arrays.sort(strings, (s1, s2) -> (s2+s1).compareTo(s1+s2)); //利用compareTo方法比较排序

        StringBuilder tmp = new StringBuilder();
        for(String s : strings) tmp.append(s);
        String res =  tmp.toString();           //排序后直接拼接就得到结果，但是可能有前导0，比如数组[0,0]，拼出来是“00”。

        int resLen = res.length();
        int idx = 0;
        while(idx < resLen - 1 && res.charAt(idx) == '0') idx++;    //去除前导0
        return res.substring(idx, resLen);
    }
}
