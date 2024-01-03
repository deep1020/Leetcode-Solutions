/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev= null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

// T.C -> O(n)
// S.C -> O(1)

// 1st iteration
// 1->2->3->4->5->null head=1, prev=null
// 1->null  2->3->4->5 head.next becomes prev which is null, prev becomes head which is 1, and head becomes next which is 2
// 2nd iteration
// 2->1->null   3->4->5 head=2, prev=1
// head.next becomes prev which is 1, prev becomes head which is 2, and head becomes next which is 3
// and so on till head becomes null
// 3->2->1->null    4->5
// 4->3->2->1->null 5
// 5->4->3->2->1->null  break loop

// Using Recursion
// if(head == null || head.next == null) {
//     return head;
// }
// ListNode revHead = reverseList(head.next);
// ListNode temp = head.next;
// temp.next = head;
// head.next = null;
// return revHead;

// T.C -> O(n)
// S.C -> O(n)