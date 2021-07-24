package BinarySearch.P378;

/*
官方题解，方法三，二分查找
https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/

思路：具体还是看题解~
根据矩阵特点，矩阵中>mid和<=mid的数分别分布在右下和左上两个板块，可以根据分界线统计左上板块的元素的个数，就能直到mid属于top几。
根据这样的思路，我们就可以对矩阵进行二分，查找小于等于某mid值的元素个数为k的mid。

时间复杂度：O(N*log(r-l))，N为矩阵尺寸，r为矩阵元素最大值，l为矩阵元素最小值。二分查找log(r-l)次，每次是O(N)复杂度。        打败100%
空间复杂度：O(1)。                                                                                                  打败63.89%
*/
class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n-1][n-1];
        while(l < r){
            int mid = l + (r - l) / 2;
            int cnt = count(matrix, n , mid);
            if(cnt < k){            //元素个数不足k，mid太小了，向右缩小查找空间
                l = mid + 1;
            } else{                 //元素个数>=k，结果可能是当前mid，也可能是比mid更小的值，向左缩小查询空间。
                r = mid;
            }
        }

        return l;   //返回l或r均可。
    }

    //计算矩阵中<=mid的元素个数
    private int count(int[][] matrix, int n, int mid){
        int r = n - 1, c = 0;           //从左下角开始寻找并计数
        int cnt = 0;                    //计数值
        while(r >= 0 && c <= n-1){
            if(matrix[r][c] <= mid){    //当前网格值<=mid，则本列向上所有元素都满足，加上。
                cnt += r+1;
                c++;                    //并且列指针右移，计算下一列的。
            } else{
                r--;                    //否则，向上移动，看本列更小的值中有没有<=mid的。
            }
        }

        return cnt;
    }
}
