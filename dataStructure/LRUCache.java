package dataStructure;

import java.util.HashMap;

public class LRUCache {
	class CacheNode {
		public CacheNode(int key,int value) {
			this.key = key;
			this.value = value;
			next = null;
			pre = null;
		}
		
		CacheNode next;
		CacheNode pre;
		int value;
		int key;

	}
	
//设置公共头尾节点	
	CacheNode head;
	CacheNode tail;
	HashMap<Integer, CacheNode> cache;
	int cacheCapacity;
	
	public LRUCache(int capacity) {
		head = new CacheNode(0,0);
		tail = new CacheNode(0,0);
		head.next = tail;
		tail.pre = head;
		cache = new HashMap<Integer, CacheNode>(capacity);
		cacheCapacity = capacity;
	}

	public int get(int key) {
		if(!cache.containsKey(key)) 
			return -1;
		
		CacheNode cacheNode = cache.get(key);
		moveToHead(cacheNode);
		return cacheNode.value;
		
	}

	public void set(int key, int value) {
		if(cache.containsKey(key)) {
			CacheNode cNode = cache.get(key);
			cNode.value = value;
			moveToHead(cNode);
			return;
		}
		if(!cache.containsKey(key) && cache.size() < cacheCapacity) {
			CacheNode cNode = new CacheNode(key, value);
			cache.put(key, cNode);
			moveToHead(cNode);
		}
		else{
			CacheNode cNode = tail.pre;
			cache.remove(cNode.key);
			cNode.key = key;
			cNode.value = value;
			cache.put(key, cNode);
			moveToHead(cNode);
			
		}
		return;
		
		
	}
	
	private void moveToHead(CacheNode cNode) {
		if(cNode.pre != null)
			cNode.pre.next = cNode.next;
		if(cNode.next != null)
			cNode.next.pre = cNode.pre;
		
		head.next.pre = cNode;
		cNode.next = head.next;
		head.next = cNode;
		cNode.pre = head;
	}
	private void removeFromTail(CacheNode cNode) {
		
	}
}
