/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        right(root,0,list);
        return list;
    }
    private void right(TreeNode root,int level,List<Integer> list){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.val);
        }
        right(root.right,level+1,list);
        right(root.left,level+1,list);
    }
}
// T.C -> O(n) where n= total number of nodes
// S.C -> O(h+n) where h= height of tree and n= number of nodes at certain height 
// DFS Approach
// Nodes from right subtree are visited before nodes from left subtree
// Keep track of current level. If current level matches the size of list i.e we are at rightmost node, add node's value to the list
// Recursively explore right subtree first and then left subtree, updating level to next by incrementing 1
// Return list containing nodes seen from right side