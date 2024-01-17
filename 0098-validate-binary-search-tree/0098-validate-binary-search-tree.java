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
    public boolean isValidBST(TreeNode root) {
        return ValidateBST(root,Long.MIN_VALUE,Long.MAX_VALUE); 
    }
    boolean ValidateBST(TreeNode root,long lowerBound,long upperBound){
        if(root==null){
            return true;
        }
        if(root.val<=lowerBound || root.val>=upperBound) {
            return false;
        }
        return ValidateBST(root.left,lowerBound,root.val) && ValidateBST(root.right,root.val,upperBound);
    }
}
// T.C -> O(n)
// S.C -> O(1)

// 'ValidateBST' method takes 3 parameters: current node, lower bound, upper bound.
// Set a lowerbound = Long.MIN_VALUE and upperbound = Long.MAX_VALUE (Take Long for larger values) 
// Checks if the current node's value is within the valid range (strictly greater than the lower bound and strictly less than the upper bound).
// It then recursively calls itself for the left and right subtrees, updating the bounds accordingly.
// 'isValidBST' check if a given binary tree is a valid BST.