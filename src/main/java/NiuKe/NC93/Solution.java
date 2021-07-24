package NiuKe.NC93;

import java.util.*;

/*
设计LRU缓存结构
同leetcode P146，用hashmap+双向链表的方式实现。双向链表头部为最近一次使用的，尾部为最久未使用的。
*/
public class Solution {
	/**
	 * lru design
	 * @param operators int整型二维数组 the ops
	 * @param k int整型 the k
	 * @return int整型一维数组
	 */
	class DLinkedNode{
		int key, val;
		DLinkedNode prev, next;
		DLinkedNode(){}
		DLinkedNode(int key, int val){
			this.key = key;
			this.val = val;
		}
	}

	private HashMap<Integer, DLinkedNode> cache;
	private int size, capacity;
	private DLinkedNode head, tail;

	public int[] LRU (int[][] operators, int k) {
		//把构造函数的功能合并进此函数，各变量在此初始化。
		cache = new HashMap<>();
		size = 0;
		capacity = k;
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;        //一系列初始化操作

		// write code here
		ArrayList<Integer> resTmp = new ArrayList<>();
		for(int i = 0; i < operators.length; i++){    //根据输入数组模拟执行一系列set、get操作。
			if(operators[i][0] == 1){    //set操作
				set(operators[i][1], operators[i][2]);
			} else {//operators[i][0] == 2        get操作
				resTmp.add(get(operators[i][1]));
			}
		}

		int[] res = new int[resTmp.size()];
		for(int i = 0; i < resTmp.size(); i++) res[i] = resTmp.get(i);
		return res;
	}

	public int get(int key){
		DLinkedNode node = cache.get(key);
		if(node == null) {
			return -1;
		} else {
			moveToHead(node);
			return node.val;
		}
	}

	public void set(int key, int val){
		DLinkedNode node = cache.get(key);
		if(node != null){
			node.val = val;
			moveToHead(node);
		} else{
			node = new DLinkedNode(key ,val);
			cache.put(key, node);
			addToHead(node);
			++size;
			if(size > capacity){
				DLinkedNode tailNode = removeTail();
				cache.remove(tailNode.key);
				--size;
			}
		}
	}

	void moveToHead(DLinkedNode node){
		removeNode(node);
		addToHead(node);
	}

	void removeNode(DLinkedNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	void addToHead(DLinkedNode node){
		head.next.prev = node;
		node.next = head.next;
		node.prev = head;
		head.next = node;
	}

	DLinkedNode removeTail(){
		DLinkedNode tailNode = tail.prev;
		removeNode(tailNode);
		return tailNode;
	}
}
