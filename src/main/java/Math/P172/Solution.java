package Math.P172;

/*
参考大佬题解：
https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
一通分析之后，发现其实就是统计1~n各个因子中所有的5的个数，即n/5 + n/25 + n/125 +......

时间复杂度：O(logN),每次除以5               打败94.16%
空间复杂度：O(1)                           打败54.08%
*/

class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while(n > 0){
            cnt += n/5;
            n /= 5;
        }
        return cnt;
    }
}
