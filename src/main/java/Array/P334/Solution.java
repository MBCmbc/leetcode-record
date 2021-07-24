package Array.P334;

/*
自己的暴力解法，对每一个元素，执行以下两个步骤：
    1.先向左找，看有没有小于自己的；
    2.再向右找，看有没有大于自己的。
两个条件同时满足，就存在对应递增三元组，否则不存在。如果所有元素都无法满足这个条件，就返回false。

时间复杂度：O(N*N)，每个元素的判断需要O(N)，N个元素需要O(N*N)。                 打败9.81%
空间复杂度：O(1)，没有使用额外空间。                                          打败98.49%
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        for(int i = 1; i < nums.length - 1; i++){
            if(checkLeft(nums, i) && checkRight(nums, i)) return true;  //两个条件同时满足则可以返回true
        }

        return false;
    }

    private boolean checkLeft(int[] nums, int idx){     //向左找比一个自己小的元素
        for(int i = idx - 1; i >= 0; i--){
            if(nums[i] < nums[idx]) return true;
        }
        return false;
    }

    private boolean checkRight(int[] nums, int idx){    //向右找一个比自己大的元素
        for(int i = idx + 1; i < nums.length; i++){
            if(nums[i] > nums[idx]) return true;
        }

        return false;
    }
}
