package Array.P74;

/*
官方题解，方法二，一次二分查找。
https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/
从描述可以看出，这个矩阵拉开之后就是一个升序数组，可以用二分查找。关键是在矩阵里应用二分。者利用了巧妙的算法：
把每行按序拼接看作数组，用0 ~ rows*columns-1表示各个格子下标，idx表示当前下标，则idx/columns就是在矩阵里的行值，idx%columns就是在矩阵里的列值，
根据这种方式进行二分查找即可。

时间复杂度：O(logMN)，M、N分别代表矩阵的行数和列数，二分查找。            打败100%
空间复杂度：O(1)                                                      打败87.65%
*/

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, columns = matrix[0].length;
        int low = 0, hi = rows*columns - 1;

        while(low <= hi){
            int mid = low + (hi - low) / 2;
            int val = matrix[mid / columns][mid % columns];     //关键，根据mid和columns确定在矩阵中的具体位置
            if(val == target){
                return true;
            } else if(val < target){
                low = mid + 1;
            } else if(val > target){
                hi = mid -1;
            }
        }

        return false;
    }
}
