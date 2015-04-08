package Sorting;
/*
 * priority队列的使用(注意构造器，会抛出illegalArgumentException)
 * 
 * 
 * 
 */
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	         val = x;
	         next = null;
	      }
	 }
public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0)
            return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), 
				new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}

		});
		for(ListNode l : lists) {
			if(l != null) {
				queue.add(l);
			}
		}
		if(queue.size() == 0){
			return null;
		}
		
		ListNode iNode = queue.poll();
		ListNode head = iNode;
		if(iNode.next != null) {
			queue.add(iNode.next);
		}
		if(queue.size() != 0) {
			ListNode preINode = iNode;
			while(queue.size() > 1) {
				iNode = queue.poll();

				preINode.next = iNode;

				if(iNode.next != null) {
					queue.add(iNode.next);
				}
				preINode = iNode;
			}

			preINode.next = queue.poll();
		}
		return head;
		}
	public static void main(String[] args) {
		new MergekSortedLists().mergeKLists(new LinkedList<ListNode>());
		List s = new LinkedList();
		s.add(null);
		System.out.println(s.size());
	}
	}

