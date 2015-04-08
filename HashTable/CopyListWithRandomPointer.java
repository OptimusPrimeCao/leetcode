package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CopyListWithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return head;
		RandomListNode head2 = copyIgnoreRandomPointer(head);

		HashMap<RandomListNode, List<RandomListNode>> pointerMap = new HashMap<RandomListNode, List<RandomListNode>>();

		RandomListNode p = head;
		RandomListNode q = head2;
		while(p != null) {
			if(p.random != null) {
				if(pointerMap.containsKey(p.random)) {
					List<RandomListNode> pointers = pointerMap.get(p.random);
					pointers.add(q);
				}

				else {
					List<RandomListNode> pointers = new ArrayList<RandomListNode>();
					pointerMap.put(p.random, pointers);
					pointers.add(q);
				}
			}
			p = p.next;
			q = q.next;

		}

		p = head;
		q = head2;
		while(p != null) {
			if(pointerMap.containsKey(p)) {
				List<RandomListNode> pointers = pointerMap.get(p);
				for(RandomListNode r : pointers)
					r.random = q;	
			}

			p = p.next;
			q = q.next;


		}
		
		return head2;

	}

	public RandomListNode copyIgnoreRandomPointer(RandomListNode head) {
		RandomListNode h2 = new RandomListNode(head.label);
		RandomListNode p = head.next;
		RandomListNode pre = h2;
		while(p != null) {
			RandomListNode q = new RandomListNode(p.label);
			pre.next = q;
			pre = q;
			p = p.next;
		}
		return h2;


	}
	
	
}
