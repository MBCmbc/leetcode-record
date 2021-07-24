package NiuKe.NC119;

import java.util.*;

/*
同剑指offer P40  Solution2
*/
public class Solution2 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if(k==0 || k>input.length) return res;
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
		for(int i = 0; i < k; i++) queue.offer(input[i]);
		for(int i = k; i < input.length; i++){
			if(queue.peek() > input[i]){//先比较一下，再决定是否调整最大堆。如果每次都入队新元素再出队最大元素，最大堆的调整会很耗时。
				queue.poll();
				queue.offer(input[i]);
			}
		}


		for(int i = 0; i < k; i++) res.add(queue.poll());
		return res;
	}
}
