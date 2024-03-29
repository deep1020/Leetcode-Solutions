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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode ptr=result;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            sum=sum%10;
            ptr.next=new ListNode(sum);
            ptr=ptr.next;
        }
        if(carry==1){
            ptr.next=new ListNode(1);
        }
        return result.next;
    }
}
// T.C -> O(n) n= length of larger linked list
// S.C -> O(n) n= maximum length of result linked list

// 1) Initialize dummy node 'result' with a value 0. It will serve as the head of result linked list
// 2) Initialize a pointer ptr to point to the result node. This pointer is used to traverse the result linked list.
// 3) Initialize a variable carry to store the carry generated while adding digits.
// 4) While loop goes till linked list is null
// Calculate the sum of the corresponding digits from l1 and l2, along with the carry.
// Update l1 and l2 to point to their next nodes if they are not null.
// Update carry to store the carry generated by the sum.
// Update sum to store the single digit by taking the remainder of the sum divided by 10.
// Append a new node with the value of sum to the result linked list.
// Move ptr to the newly added node.
// 5) After the loop ends, if there's still a carry remaining (carry == 1), 
// append a new node with a value of 1 to the result linked list to accommodate the additional digit.
// 6) Return the next node after the dummy node (result.next). 
// This node will be the head of the resultant linked list, excluding the dummy node.
