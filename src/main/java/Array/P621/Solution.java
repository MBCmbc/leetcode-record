package Array.P621;

/*
https://leetcode-cn.com/problems/task-scheduler/solution/python-xiang-jie-by-jalan/
自己的理解，结合上述大佬的想法，得到如下代码。

思路：找到任务队列中出现次数最多的任务，记其出现次数为maxNum，可以假设一共进行maxNum次循环，每轮循环中包括的任务数为n+1个，
对于前(maxNum-1)次循环，如果一次循环中的不同任务数不足n+1个，就用(待命)来填充。故前(maxNum-1)次循环需要的时间为(maxNum-1) * (n+1)
对于第maxNum次循环(循环次数从1开始计数)，只需统计出现次数并列最多的任务种类数量，放入即可。所以总次数为(maxNum-1) * (n+1) + numOfMax

然而，还有一种特殊情况：按照上述的规则排列后，可能还有多余的不同种类数，对于每一种多出来的种类，可以依次“插入”不同的循环轮次末尾。
这样不会违反冷却时间n的规则。（多余的不同种类任务各自对应的出现次数一定是<=maxNum的，循环的次数一定够用的，所以放心“插入”即可）
比如tasks = ["A","A","A","B","B","B","C","C","D","D"], n = 2
先按正常思路排列：A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
                A -> B -> (待命) -> A -> B -> (待命) -> A -> B
                A -> B -> C -> A -> B -> C -> A -> B -> D
将多余种类插入：  A -> B -> C -> D -> A -> B -> C -> A -> B -> D

这种“有多余”的情况下，需要的时间数就是数组的长度，因为不需要“待命”。
而且因为少计算了一部分的“多余种类数”，这种情况下用正常思路计算出来的时间数必然是小于数组长度的，比如上面的例子，计算结果为8，而实际结果应为10.
所以最终返回结果时判断一下，是返回计算结果还是数组长度，再返回即可。


时间复杂度：遍历了一遍任务队列，所以为O(N)，N为任务队列tasks的长度。                执行用时：打败99.74%
空间复杂度：只用了常数量级的额外空间，故为O(1)。                                   内存消耗：打败35.90%
*/

import java.util.Arrays;

class Solution {
	public int leastInterval(char[] tasks, int n) {
		//如果队列长度等于0或1，那就不需要考虑n，因为肯定不会违反最短间隔时间，直接返回任务队列长度即可
		//而且，这一步对执行时间的提升还挺大的：3ms→2ms
		if(tasks.length <= 1) return tasks.length;

		//用数组统计各种不同的任务分别出现的次数，并排序，以便找到出现次数最多的任务。
		int[] numOfTask = new int[26];
		for(char c : tasks){
			numOfTask[c-'A']++;
		}
		Arrays.sort(numOfTask);
		int maxNum = numOfTask[25];

		//找到出现次数并列最多的任务种类equalToMax，这其中当然包括numOfTask[25]这个“最大值 ”。
		int numOfMax = 1;
		for(int i=24; i>=0; i--){
			if(numOfTask[i] == maxNum){
				numOfMax++;
			}else{
				break;
			}
		}

		//结果为前(maxNum-1)次“满”循环需要的时间，再加上最后一次“不满”循环需要的时间。
		int result = (maxNum-1) * (n+1) + numOfMax;

		//返回前，判断一下是否是特殊情况，即计算结果是否小于数组长度：
		//如果小于，就是特殊情况，返回数组长度；
		//否则，就是正常情况，返回计算结果。
		return result < tasks.length ? tasks.length : result;
	}
}