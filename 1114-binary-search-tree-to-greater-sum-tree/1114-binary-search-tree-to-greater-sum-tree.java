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
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null){
            return null;
        }
        bstToGst(root.right);
        sum+=root.val;
        root.val=sum;
        bstToGst(root.left);
        return root;
    }
}
// T.C -> O(n) recursively iterate each node of tree exactly once
// S.C -> O(h) In worst case, height of BST can be O(n) but in best case height is O(logn) 

// Create global variable sum to store sum value of current node
// Base case: If current node is null, no way to explore further and return null
// Recursively take the right subtree first. This ensures that nodes with greater values are taken before the current node
// Add current node's value to sum
// update current node's value to cummulative sum
// Recursively take the left subtree first. This ensures that nodes with smaller values are taken before the current node
// Return modified tree root after considering all nodes