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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode tail=swapPairs(head.next.next);
        ListNode temp=head;
        head=head.next;
        head.next=temp;
        temp.next=tail;
        return head;
    }   
}
// T.C -> O(n)
// S.C -> O(1)

// Base case: If head or head.next is null, we will stop function and return head
// If base condition is not true, we will call function with value head.next.next and get the head of swapped pairs.
// we swap head and head.next then connect thier tail
// return head at the end