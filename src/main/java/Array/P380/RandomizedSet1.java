package Array.P380;

import java.util.HashSet;
import java.util.Random;

/*
自己的解法：思路很简单，内部用一个HashSet<Integer>去实现就好了，HashSet的add和remove函数正好分别对应题目要求的insert和remove函数。
而getRandom方法，将HashSet转为数组，再自己生成一个范围覆盖数组下标的随机数，将随机数作为下标返回数组中的元素即可。只是性能很一般。

执行用时：打败7.52%
内存消耗：打败5.37%
*/
class RandomizedSet1 {
	private HashSet<Integer> set;

	/** Initialize your data structure here. */
	public RandomizedSet1() {
		this.set = new HashSet<Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		return set.add(val);
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		return set.remove(val);
	}

	/** Get a random element from the set. */
	public int getRandom() {
		//将HashSet转为数组ints
		int size = set.size();
		Integer[] ints = new Integer[size];
		set.toArray(ints);
		//生成范围覆盖数组下标的随机数
		Random random = new Random();
		int index = random.nextInt(size);
		//返回随机值
		return ints[index];
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
