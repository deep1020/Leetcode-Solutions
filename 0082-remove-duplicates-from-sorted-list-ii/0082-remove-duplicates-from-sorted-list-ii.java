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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        Map<Integer,Integer>map=new TreeMap<>();
        ListNode curr=head;
        while(curr!=null){
            map.put(curr.val,map.getOrDefault(curr.val,0)+1);
            curr=curr.next;
        }
        ListNode newHead=new ListNode(-1);
        ListNode left=newHead;
        for(int i:map.keySet()){
            if(map.get(i)==1){
                ListNode newNode=new ListNode(i);
                left.next=newNode;
                left=newNode;
            }
        }
        return newHead.next;
    }
}
// Craete a HashMap
// put occurrence in a map -> (1,1),(2,1),(3,2),(4,2),(5,1)
// Loop goes through keys in map -> i={1,2,3,4,5}
// if(map.get(i)==1) it means value of i equals to 1 that means we have only elements that occurrence is only 1 in head -> 1,2,5
// create a new ListNode which has object newNode
// ListNode newHead=new ListNode(-1) -> -1 is dummy value
// newNode stores map elements which will be connected by ListNode next
// return ListNode object newHead.next