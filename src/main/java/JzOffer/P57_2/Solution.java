package JzOffer.P57_2;

/*
剑指offer思路，自己实现代码，也参考了大佬题解，证明部分可以看一下题解。
https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
滑动窗口方法寻找连续正整数序列。用start和end两个指针标记滑动窗口的开始和结束位置，记录窗口内的和sum，根据sum与target的大小关系，
决定窗口边界如何移动（无论start还是end都只需向右移动，无需向左，具体证明可以参考上述题解）。

时间复杂度：O(target)，两指针均单向移动，且分别最多移动（target-1）/2，（target+1）/2步，所以为O(target)。记录subRes视为O(1)。      打败96.08%
空间复杂度：O(1)，除了答案数组只需要常量空间。                                                                                     打败26.9%
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] findContinuousSequence(int target) {
		List<int[]> res = new ArrayList<>();
		int start = 1, end = 2, sum = 3;    //窗口初始左、右边界以及和。
		int middle = (target - 1) / 2;

		while(start <= middle){                 //因为至少包含两个数，所以start + (start+1) <= target，可得终止条件。
			if(sum == target){                  //情况1.
				int[] subRes = new int[end - start + 1];
				for(int i = start; i <= end; i++) subRes[i - start] = i;
				res.add(subRes);                //记录该序列。
				sum -= start;                   //因为以start开头的序列最多只可能有一个，所以将start右移，寻找以start+1开头是否有对应序列。
				++start;
			} else if(sum > target){            //情况2.sum太大，将start右移，以缩小sum。
				sum -= start;
				++start;
			} else{ //sum < target              //情况3.sum太小，将end右移，以增大sum。
				++end;
				sum += end;
			}
		}

		return res.toArray(new int[res.size()][]);
	}
}
