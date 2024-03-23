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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return;
        }        
        ListNode last=head.next;
        ListNode secondLast=head;
        while(last.next!=null){
            last=last.next;
            secondLast=secondLast.next;
        }
        ListNode temp=head.next;
        head.next=last;
        last.next=temp;
        secondLast.next=null;
        reorderList(temp);
    }
}
// T.C -> O(n)
// S.C -> O(1)

// Input: head = [1,2,3,4,5]
// Initialize last to second node '2' and secondLast to first node '1'
// Start iterating last.next is null
//  - Move last to next node
//  - Move secondLast to next node
// At the end of iteration, last will point to last node '5' and secondLast will point to the node before the last node '4'
// Store the reference to the node after head in temp '2'
// Set head.next to last (1->5), making the list as: 1 -> 5 -> 3 -> 4 -> 5 -> null
// Set last.next to temp (5->2), making the list as: 1 -> 5 -> 2 -> 3 -> 4 -> 5 -> null
// Set secondLast to null (4->null), making the list as: 1 -> 5 -> 2 -> 3 -> 4 -> null
// Call reorderList(temp), which will recursively reorder the sublist starting from temp 
// temp becomes head (2 is head in next recursive call) so new list is (1 -> 5 -> 2 -> 3 -> 4 -> null).
// Afterwards, We don't touch (1->5) so perform operations only on (2 -> 3 -> 4 -> null)
// Finally after next recursion, we get (1 -> 5 -> 2 -> 4 -> 3 -> null) 