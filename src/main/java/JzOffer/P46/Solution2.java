package JzOffer.P46;

/**
 自己的解法，动态规划。
 用f(i)表示以第i位数字作为截止，一共有多少种翻译方法。则有递推公式：
 1. f(i+1) = f(i) + f(i-1)       //i位和i+1位拼接起来在[10,25]中，有两种翻译方法：i+1位单独翻译、i位和i+1位拼接翻译
 2. f(i+1) = f(i)                //i位和i+1位拼起来不在[10,25]中，则只能i+1位单独翻译。
 根据上述递推公式，用动态规划的方式实现代码（从左向右）。

 时间复杂度：O(N)。                                                              打败100%
 空间复杂度：O(N),字符串s占用了空间。但其实没多大，int才多长呢？是吧。               打败75.76%
 */

class Solution2 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int pre = 1;     //f(i-1)
        int cur = 1;    //f(i)
        int fur;        //f(i+1)
        for(int i = 1; i < len; i++){
            //拼接数值，不能用Integer.valueOf()，会取成unicode码，而不是数值。
            int val = Character.getNumericValue(s.charAt(i-1)) * 10 + Character.getNumericValue(s.charAt(i));
            if(val >= 10 && val <= 25){
                fur = pre + cur;
            } else {
                fur = cur;
            }

            pre = cur;
            cur = fur;
        }

        return cur;
    }
}
