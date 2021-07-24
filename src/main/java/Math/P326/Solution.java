package Math.P326;

/*
官方题解，方法一，循环迭代。
https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/

两种情况：
    1. n < 1 返回false
    2. n >= 1，可以整除的情况下，不断地除以3，把n里面所有的“3因子”除掉，如果最后结果为1则为3的幂，否则不是。

时间复杂度：O(logN)，不断除以3，时间复杂度是对数级别。                  打败98.98%
空间复杂度：O(1)。                                                  打败68.9%
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;    //情况1

        while(n % 3 == 0){  //可以整除的情况下，不断地除以3
            n /= 3;
        }

        return n == 1;           //“3因子”除完后，最终结果为1则返回true，否则返回false。
    }
}
