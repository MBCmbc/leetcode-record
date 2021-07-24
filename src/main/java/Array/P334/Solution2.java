package Array.P334;

/*
大佬题解，应该是贪心的思想。
https://leetcode-cn.com/problems/increasing-triplet-subsequence/solution/pou-xi-ben-zhi-yi-wen-bang-ni-kan-qing-t-3ye2/
核心想法：遍历一遍数组，希望遍历到的这个数three，前面已经有一个比他小的数two，再前面有一个比two小的数one。
我们需要维护两个变量：one和two。代表递增子序列的第一个数和第二个数。
时间复杂度：O(N)，遍历一次数组                  打败100%
空间复杂度：O(1)                              打败68.75%
*/
class Solution2 {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        for(int three : nums){
            //假设我们已经有了one和two这两个数，那么three的大小有以下三种情况：
            if(three > two) return true;            //找到一个子序列
            else if(three <= one) one = three;       //更新one，two不动。相当于保留了old one，two以及new one这两个序列。
                //注意上一行必须是three<=one，这样才能保证下一行的对应条件是three>one，进而保证更新得到的two>one,满足题目要求。
            else two = three;   //即one < three <= two，应该更新two为three。
        }

        return false;       //遍历完都没找到。
    }
}
