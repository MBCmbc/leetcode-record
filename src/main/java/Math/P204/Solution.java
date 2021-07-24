package Math.P204;

/*
官方题解，方法二，埃氏筛。
https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
思路：设isPrime[i] 表示数i是不是质数，如果是质数则为1，否则为0。从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即0，这样在运行结束的时候我们即能知道质数的个数。

对于一个质数x，如果按上文说的我们从2x开始标记其实是冗余的，应该直接从x*x开始标记，因为2x,3x... 这些数一定在x之前就被其他数的倍数标记过了，例如2的所有倍数,3的所有倍数等。

时间复杂度：O(NloglogN)，分析复杂，见题解。                     打败28.19%
空间复杂度：O(N)，isPrime数组的大小。                          打败5%
*/

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];     //标记数组，1表示是质数，0表示不是质数
        Arrays.fill(isPrime, 1);
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){    //没有被标记为合数，就一定是质数
                ++res;
                if((long)i*i < n){      //因为i*i可能溢出，所以先用long型存储，判断一下是否小于n。若大于等于n也无需进行标记。
                    for(int j = i*i; j < n; j += i){    //从i*i开始，标记i的倍数为合数
                        isPrime[j] = 0;
                    }
                }
            }
        }

        return res;
    }
}
