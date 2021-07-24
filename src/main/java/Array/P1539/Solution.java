package Array.P1539;

/*
阿里3.8号笔试题，第一题。
思路：因为是找正整数，所以我们用i代表从1开始的所有正整数，依次和数组内的元素进行对比，如果数组内有该元素就继续对比下一个。
    如果没有就说明当前i是缺失的，用count代表目前的i是第几个缺失的正整数，故count++，如此下去，直到count==k为止。

    因为数组是严格升序排列的，所以我们从左往右遍历即可了。

时间复杂度：O(N+K)，N为数组长度，K为输入k，最坏情况下数组内容为1-N的N个数，我们就一直要遍历到N+K才能得到结果返回。      打败53.85%
空间复杂度：O(1)，只使用常数级别的额外空间。                                                                      打败14.21%
*/
class Solution {
	public int findKthPositive(int[] arr, int k) {
		//i代表当前的正整数；count表示我们找到了第几个缺失的正整数；index是数组下标，遍历要用的；res存储最后的结果。
		int i=1, count=0, index = 0, res = 0;
		while(count <= k){
			//看看当前i是否在arr中，在则说明不缺失，下一个。
			if(index < arr.length && arr[index] == i){//注意检查下标，不能越界。若下标越界说明数组遍历完了，后面的都是缺失的元素，应该进入else。
				index++;
			} else {//当前i是缺失的
				count++;            //找到了一个，计数器count++
				if(count == k){     //当count==k，说明找到了结果，i就是，赋值给res后，break，进而return。
					res = i;
					break;
				}
			}
			i++;    //if里和else里i都要++，所以放到外面来了。
		}
		return res;
	}
}
