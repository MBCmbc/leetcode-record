package Array.P350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
自己的解法，先对两个数组排序，然后每个数组一个指针进行遍历，相等则加入结果集合，不相等则数值较小的那个指针向前走，直到相等或遍历完。

时间复杂度：O(N1logN1 + N2logN2)。N1为nums1长度，N2为nums2长度，排序时间复杂度。遍历为O(N1+N2)。                打败87.96%
空间复杂度：O(N)，N=min(N1,N2)。动态数组tmp的大小，因为是交集，所以是求min。                                    打败75.84%
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);     //先排序
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>();      //动态数组暂存结果
        int p1 = 0, p2 = 0;     //两个指针
        while(p1 < nums1.length && p2 < nums2.length){      //双指针遍历
            if(nums1[p1] == nums2[p2]){     //相等则加入结果集合
                tmp.add(nums1[p1]);
                ++p1;
                ++p2;
            } else if(nums1[p1] > nums2[p2]){       //不相等则小数指针前进，大数指针等待
                ++p2;
            } else if(nums1[p1] < nums2[p2]){
                ++p1;
            }
        }

        int len = tmp.size();           //转为int[]形式返回。
        int[] res = new int[len];
        for(int i = 0; i < len; i++) res[i] = tmp.get(i);
        return res;
    }
}
