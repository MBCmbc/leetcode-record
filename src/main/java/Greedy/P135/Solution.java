package Greedy.P135;

import java.util.Arrays;

/**
 官方题解，贪心。
 https://leetcode-cn.com/problems/candy/solution/fen-fa-tang-guo-by-leetcode-solution-f01p/

 可以将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理：
 左规则：当ratings[i−1] < ratings[i] 时，i号学生的糖果数量将比 i−1 号孩子的糖果数量多。
 右规则：当ratings[i] > ratings[i+1] 时，i号学生的糖果数量将比 i+1 号孩子的糖果数量多。
 我们遍历该数组两次，处理出每一个学生分别满足左规则或右规则时，最少需要被分得的糖果数量。每个人最终分得的糖果数量即为这两个数量的最大值。

 时间复杂度：O(N)，三次遍历。                                    打败56.32%
 空间复杂度：O(N)，left数组和right数组。                         打败25.23%
 */
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int len = ratings.length;
        int[] left = new int[len];      //左规则
        int[] right = new int[len];     //右规则
        Arrays.fill(left, 1);           //先给每个人分1个糖果。
        Arrays.fill(right, 1);

        //满足左规则需要的最少糖果
        for(int i = 1; i < len; i++){
            if(ratings[i-1] < ratings[i]){
                //ratings[i−1] < ratings[i]，i号学生的糖果数量将比 i−1 号孩子的糖果数量多。
                //ratings[i−1] >= ratings[i]先不做处理，交由有规则处理。
                left[i] = left[i-1] + 1;
            }
        }

        //满足右规则所需要的最少糖果。
        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i+1] + 1;
            }
        }

        //每个人最终分得的糖果是左规则和右规则中的较大值。
        int res = 0;
        for(int i = 0; i < len; i++){
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
}
