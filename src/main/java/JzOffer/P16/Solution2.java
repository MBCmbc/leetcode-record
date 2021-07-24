package JzOffer.P16;

/*
快速幂的解法，参考：https://www.jianshu.com/p/45a2f9e8391a

时间复杂度：O(logN)             打败98.42%
空间复杂度：O(1)                打败97.47%
*/
class Solution2 {
    public double myPow(double x, int n) {
        long t = n;     //当n为-2^31，取-n会溢出，所以用long型的t转存n。

        boolean isNeg = false;      //标记指数是否为负
        if(t < 0){
            isNeg = true;
            t = -t;
        }

        double res = 1.0d;
        double base = x;
        while(t > 0){               //快速幂求解过程
            if((t&1) != 0){
                res *= base;
            }

            base *= base;
            t >>= 1;
        }

        if(!isNeg){
            return res;
        } else {
            return 1.0d / res;
        }
    }
}