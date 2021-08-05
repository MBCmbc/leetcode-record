package Array.P15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 大佬的解法，排序+双指针
 https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/

 先排序，然后用三个指针k、i、j进行计算，步骤如下：
 1.固定k，将i、j放在[k+1, nums.length-1]的两端，i和j从两边向中间收缩，寻找和为0的三元组。

 时间复杂度：O(N*N)，固定指针k循环的时间复杂度是O(N)，双指针i和j时间复杂度O(N)。         打败49.42%
 空间复杂度：O(1)，除了结果集合外，只使用了常数级别的额外空间。                         打败54.22%
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);      //先排序
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            //已排序，nums[k]>0，不可能有答案，结束。
            if(nums[k] > 0) {
                break;
            }
            //已经用过的元素跳过，避免重复
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    //sum<0，需要将i右移（和nums[i]重复的元素也不可能有结果，统统跳过。）
                    int iVal = nums[i];
                    while(i < j && nums[i] == iVal){
                        i++;
                    }
                } else if(sum > 0){
                    //sum>0，需要将j左移（和nums[j]重复的元素也不可能有结果，统统跳过。）
                    int jVal = nums[j];
                    while(i < j && nums[j] == jVal){
                        j--;
                    }
                } else {
                    //sum==0，找到一组，存入结果。
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(nums[k]);
                    subRes.add(nums[i]);
                    subRes.add(nums[j]);
                    res.add(subRes);
                    //用过的nums[i]和nums[j]不可能再有其它不重复的结果，统统跳过。
                    int iVal = nums[i], jVal = nums[j];
                    while(i < j && nums[i] == iVal){
                        i++;
                    }
                    while(i < j && nums[j] == jVal){
                        j--;
                    }
                }
            }
        }

        return res;
    }
}
