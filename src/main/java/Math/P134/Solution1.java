package Math.P134;

/*
暴力法，按照题目和示例的描述，一步一步检查即可。

时间复杂度：O(N*N)，最坏情况下，两层for循环都走完。             打败13.83%
空间复杂度：O(1)，未使用额外空间                              打败59.09%
*/

class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){    //检查从每个位置出发，是否有成功的可能
            if(check(gas, cost, i)) return i;   //有则返回
        }

        return -1;      //没有，返回-1
    }

    private boolean check(int[] gas, int[] cost, int start){    //检查从某个位置出发能否环绕一周
        int len = gas.length;
        int idx = start;    //当前位置的下标
        int rem = gas[idx]; //当前油箱剩余油量
        for(int i = 0; i < len; i++){   //绕一周
            rem = rem - cost[idx];
            if(rem < 0) return false;   //先计算能否到达下一节点
            idx = (idx + 1) % len;
            rem = rem + gas[idx];   //如果能到达，加好油后继续往前走。
        }

        return true;    //途中没有出现负油量，可以环绕一周，返回true。
    }
}
