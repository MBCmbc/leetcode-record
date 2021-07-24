package Math.P231;

/*
自己的解法。不停地除以2，判断有没有其它奇数因子即可。

时间复杂度：O(logN)，每次除以2，时间复杂度是对数级别。                  打败100%
空间复杂度：O(1)。                                                  打败88.91%
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;            //2的整数次幂一定是正数
        while(true){                       //不停的除以2，直到结果为1（返回true），或发现有其他奇数因子（break后返回false）。
            if(n == 1) return true;
            if(n % 2 == 1){
                break;
            } else {
                n /= 2;
            }
        }

        return false;
    }
}
