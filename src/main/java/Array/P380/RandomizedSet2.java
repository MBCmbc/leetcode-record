package Array.P380;

/*
官方题解
思路：用一个动态数组ArrayList存储元素，用一个HashMap存储值和元素下标，以达到尽可能低的时间复杂度。
时间复杂度：getRandom 时间复杂度为O(1)，insert 和 remove 平均时间复杂度为O(1)，在最坏情况下为O(N)，当元素数量超过当前分配的动态数组和哈希表的容量导致空间重新分配时。
空间复杂度：O(N)，在动态数组和哈希表分别存储了N个元素的信息。

执行用时：打败99.24%
内存消耗：打败80.54%
*/

import java.util.*;

class RandomizedSet2 {
	Map<Integer, Integer> map;
	List<Integer> list;
	Random random = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet2() {
		//以元素值为键，元素在数组中的下标为值
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val)) return false;

		//每次添加都是在list末尾，所以直接以数组size作为下标即可。
		map.put(val, list.size());
		list.add(list.size(), val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)) return false;

		//删除元素的时候，用最后一个元素的值覆盖掉要删除的元素，然后删除数组最后一个元素
		//这样每次都是删除最后一个元素，不必执行arraycopy往前移动元素的操作，降低了时间复杂度。

		//获取数组最后一个元素值
		int lastElement = list.get(list.size()-1);
		//查询要删除元素的下标
		int index = map.get(val);
		//用lastElement覆盖要删除的元素
		list.set(index, lastElement);
		//在map中更新lastElement的下标
		map.put(lastElement, index);
		//删除list的末尾位置，也即“无用的、冗余的”最后一个元素
		list.remove(list.size()-1);
		//在map中也删除对应元素的键值对。
		map.remove(val);

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		//在数组下标范围内随机生成一个数，以该数为下标从list中拿到元素值并返回
		return list.get(random.nextInt(list.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
