package twoPointers;

public class RemoveDuplicatesFromSortedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		ListNode p = head.next;
		ListNode pre = head;
		while(p != null) {
			if(p.val != pre.val) {
				pre.next = p;
				pre = p;
			}
			p = p.next;
		}
		
		pre.next = null;
		return head;
	}
}
// ListNode *deleteDuplicates(ListNode *head) {
//2     // Start typing your C/C++ solution below
//3     // DO NOT write int main() function
//4     if(head==NULL || head->next==NULL)
//5         return head;
//6     ListNode * p = head;
//7      8     while(p->next!=NULL && p->val == p->next->val){
//9         p=p->next;
//10     }
//11 
//12     if(p!=head){
//13         while(head!=p->next)
//14         {
//15             ListNode * tmp = head;
//16             head=head->next;
//17             free(tmp);                      //如果要释放内存的话
//18         }
//19 
//20         return deleteDuplicates(p->next);
//21     }
//22 
//23     head->next=deleteDuplicates(head->next);
//24     return head;
//25 }