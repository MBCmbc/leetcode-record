package Array.P384;

/*
官方题解，方法二，Fisher-Yates 洗牌算法
https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode/
思路：从左到右遍历要打乱的数组，假设当前遍历下标为i，则随机生成一个[i,len)之间的下标randomIdx，然后在数组内交换下标i和下标randomIdx位置的元素。
这就相当于确定了下标i处的元素，然后i右移，继续确定下一位。直至全部确定。

时间复杂度：O(N)，因为生成随机数，和交换元素都是线性时间复杂度。所以时间复杂度及时clone和for循环的复杂度，为O(N)。          打败95.7%
空间复杂度：O(N)，额外的shuffle数组大小。                                                                            打败79.32%
*/

import java.util.Random;

class Solution {
    private int[] origin;   //原始数组
    private int[] shuffle;  //用来打乱的数组
    private int len;        //数组长度
    private Random random = new Random();

    //生成一个[min, max)之间的随机数
    private int randomIdx(int min, int max){
        return random.nextInt(max - min) + min;
    }

    //交换数组nums内，下标idx1和下标idx2处的元素
    private void swap(int[] nums, int idx1, int idx2){
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public Solution(int[] nums) {
        this.origin = nums;
        this.len = nums.length;
        this.shuffle = new int[this.len];
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {  //直接返回原数组即可。
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        System.arraycopy(origin, 0 , shuffle, 0, len);          //1.先把原数组内容复制到shuffle里
        for(int i = 0; i < len; i++){                           //2.再依次确定各个位置的随机元素
            int idx = randomIdx(i, len);
            swap(shuffle, i, idx);
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
