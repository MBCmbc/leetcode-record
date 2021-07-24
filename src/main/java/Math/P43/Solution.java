package Math.P43;

/*
大佬解法二，优化竖式
https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。具体可以看题解中的图示。

时间复杂度：O(MN)，M和N为两个输入参数的长度，两重for循环。                      打败82.82%
空间复杂度：O(M+N)，res数组和StringBuilder的大小。                            打败99.83%
*/

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1+len2];             //乘数num1位数为M，被乘数num2位数为N，num1 * num2结果res最大总位数为M+N
        for(int i = len1-1; i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            for(int j = len2-1; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int sum = res[i+j+1] + n1 * n2;
                res[i+j+1] = sum % 10;              //num1[i] * num2[j]的结果为tmp(位数为两位，"0x","xy"的形式)
                res[i+j] += sum / 10;               //其第一位位于res[i+j]，第二位位于res[i+j+1]
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len1+len2; i++){
            if(i==0 && res[i]==0) continue;         //计算结果顶多可能存在一个前置0
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
