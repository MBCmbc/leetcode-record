package Math.P134;

/*
官方题解，一次遍历
https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/
思路：首先检查第0个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查。

时间复杂度：O(N)，根据思路，是单次遍历，最多把环路走两圈（只有从最后一个位置出发可以绕一圈）。          打败100%
空间复杂度：O(1)。                                                                              打败68.18%
*/

class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;  //汽车出发位置
        while(start < len){
            int gasSum = 0, costSum = 0;    //分别代表出发到目前为止，加油总量，耗油总量
            int cnt = 0;    //从start处出发，一共走过了几步
            while(cnt < len){
                int idx = (start + cnt) % len;  //汽车当前所在位置
                gasSum += gas[idx]; //更新加油量
                costSum += cost[idx];   //更新耗油量
                if(costSum > gasSum) break; //耗油 > 加油，说明无法到达。
                else cnt++; //否则，说明可以再往前一步
            }

            if(cnt == len) return start;    //cnt==len说明走了一圈，返回start
            else start = start + cnt + 1;   //否则说明无法走一圈，第一个无法到达的加油站出发，再尝试
        }

        return -1;  //从任何一个位置出发都不行
    }
}
