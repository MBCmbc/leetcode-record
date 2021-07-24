package Others.P292;

/*
把n = 1 ~ 12的情况画一下就可以看出，若我先手，且双方每一步都是最优解；
则只有在n是4的倍数的情况下，我才会输，其他情况都会赢。
官方题解也是和我一样的想法：https://leetcode-cn.com/problems/nim-game/solution/nimyou-xi-by-leetcode/

时间复杂度：O(1)，打败100%
空间复杂度：O(1)，打败98.24%
*/
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}