package DFS.P695;

/**
 自己的做法，dfs。思路同官方题解方法一。
 https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode-solution/
 从二维数组的每一个位置开始，向上、下、左、右四个方向扩散进行dfs搜索，统计岛屿的最大面积。

 时间复杂度：O(R*C)，R表示网格行数，C表示网格列数，最多访问一个网格4次。                 打败100%
 空间复杂度：O(R*C)，递归调用栈的最大深度可能为整个网格的大小。                          打败91.95%
 */

class Solution {
    private int[][] grid;
    private int rows, columns;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
        int res = 0;

        //每个位置都展开搜索，记录最大值。
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                res = Math.max(res, dfs(r,c));
            }
        }

        return res;
    }

    //函数意义：以当前位置为中心向四个方向进行扩散，所能达到的最大陆地面积。
    private int dfs(int r, int c){
        //越界||非陆地，返回0。
        if(r < 0 || r >= rows || c < 0 || c >= columns || grid[r][c] == 0) {
            return 0;
        }

        //统计过的位置，置0，避免重复计算。
        grid[r][c] = 0;
        //四个方向扩散出来的面积，加上当前位置的面积1，就是所能达到的最大陆地面积。
        return dfs(r-1, c) + dfs(r+1, c) + dfs(r, c-1) + dfs(r, c+1) + 1;
    }
}
