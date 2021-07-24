package JzOffer.P51;

/**
 * Krahets大神解法，利用归并排序的思想，在排序的过程中统计逆序对的个数，具体思路可以参考以下链接：
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
 *
 * 时间复杂度：O(NlogN)，归并排序时间复杂度            打败76.09%
 * 空间复杂度：O(N)，tmp暂存数组的大小                 打败71.14%
 */
class Solution {
    int[] nums;
    int[] tmp;  //因为归并排序会直接修改原数组，所以合并时需要一个tmp数组暂存当前状态。

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];         //tmp数组最大时需要存储nums的所有元素
        return recur(0, nums.length - 1);
    }

    public int recur(int l, int r) {
        if (l >= r) return 0;        //终止条件
        int m = (l + r) / 2;        //递归划分
        int res = recur(l, m) + recur(m + 1, r);
        //往下是合并阶段
        int i = l, j = m + 1;     //i，j分别是左右两个子数组当前元素的指针
        for (int k = l; k <= r; k++) {     //tmp暂存当前状态
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {               //左边子数组已经合并完，把右边的当前元素放进去即可
                nums[k] = tmp[j++];
            } else if (j == r + 1) {        //右边子数组已经合并完，同理。
                nums[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {    //因为统计逆序对是严格大于号，所以等于号放这里
                nums[k] = tmp[i++];         //i所指元素更小，入nums
            } else {                        //j所指元素更小，符合逆序对要求
                nums[k] = tmp[j++];             //1.进行归并排序
                res += (m - i + 1);                 //2.同时统计逆序对
            }
        }
        return res;
    }
}
