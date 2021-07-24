package Others.P412;

import java.util.ArrayList;
import java.util.List;

/*
根据题目描述，写就完了~

设两位二进制数字，高位1代表是3的倍数，0则不是；低位1代表是5的倍数，0则不是。则有四种可能：
    1. 11，既是3的倍数，又是5的倍数
    2. 10，是3的倍数，但不是5的倍数
    3. 01，不是3的倍数，但是5的倍数
    4. 00，既不是3的倍数，也不是5的倍数
1~n的每个数只能是上述四种情况中的一种，进行判断即可。

时间复杂度：O(N)，遍历1~n。                             打败98.36%
空间复杂度：O(1)，如果不计结果数组的话。                  打败65.81%
*/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i%3==0 && i%5 == 0){     //1. 先判断是否同时为3和5的倍数
                res.add("FizzBuzz");
            } else if(i % 3 == 0){      //2. 不满足1的情况下，看是否为3的倍数
                res.add("Fizz");
            } else if(i % 5 == 0){      //3. 1和2都不满足的情况下，看是否为5的倍数
                res.add("Buzz");
            } else{                     //4. 1、2和3都不满足，既不是3的倍数又不是5的倍数
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
