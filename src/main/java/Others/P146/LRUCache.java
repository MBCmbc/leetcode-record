package Others.P146;

/*
官方题解，采用和LinkedHashMap相同的思想来做：HashMap + 双向链表。
https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/

首先，用内部类DlinkedNode表示每一个节点（既是双向链表内节点也是HashMap的value），然后在HashMap中存储的同时，维护一个最大容量为capacity的双向链表，
将最近一次被操作的节点（set或get）放在链表头部，则最久不被使用的节点就在链表尾部，从而实现LRU缓存功能。

时间复杂度：put()和get()方法的时间复杂度都是O(1)。                                                          打败88.69%
空间复杂度：O(capacity)，双向链表和HashMap都最多存储capacity+1个节点（插入新节点后，未删除尾节点前）。          打败30.33%
*/

import java.util.HashMap;

class LRUCache {
	class DLinkedNode{              //内部类，双向链表节点
		int key;
		int val;
		DLinkedNode prev;
		DLinkedNode next;
		public DLinkedNode(){}
		public DLinkedNode(int key, int val){
			this.key = key;
			this.val = val;
		}
	}

	private HashMap<Integer, DLinkedNode> cache;
	private int size;
	private int capacity;
	private DLinkedNode head, tail;   //dummy头和尾节点

	public LRUCache(int capacity) {     //构造函数，完成初始化
		size = 0;
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if(node == null){   //缓存中没有该key，返回-1
			return -1;
		} else{     //缓存中有该key，移动至双向链表的头部，并返回节点val。
			moveToHead(node);
			return node.val;
		}
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if(node != null){   //cache中已存在该key，完成两步：1.修改key对应node的value。2.node移动至双向链表头部
			node.val = value;
			moveToHead(node);
		} else{ //cache中不存在该key，完成以下4步：
			node = new DLinkedNode(key, value);
			cache.put(key, node);   //1.new一个对应节点node，放入cache。
			addToHead(node);        //2.将新节点node插入双向链表头部。
			++size;                 //3.缓存大小size++
			if(size > capacity){    //4.当size超过容量，执行以下3步：
				DLinkedNode tailNode = removeTail();    //4.1从双向链表尾部删除一个节点
				cache.remove(tailNode.key);             //4.2在cache中也删除该尾节点。
				--size;                                 //4.3缓存大小size--
			}
		}
	}

	void moveToHead(DLinkedNode node){  //节点移动至双向链表头部，分两步：1.当前位置删除该节点，头部添加该节点。
		removeNode(node);
		addToHead(node);
	}

	void removeNode(DLinkedNode node){  //从双向链表中删除某节点
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	void addToHead(DLinkedNode node){   //将某节点添加至双向链表头部
		head.next.prev = node;
		node.next = head.next;
		node.prev = head;
		head.next = node;
	}

	DLinkedNode removeTail(){  //删除双向链表中最后一个有效节点，即dummy尾节点的前一个节点。
		DLinkedNode tailNode = tail.prev;
		removeNode(tailNode);
		return tailNode;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
