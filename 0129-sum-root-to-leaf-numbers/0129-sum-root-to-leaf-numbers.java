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
    public int sumNumbers(TreeNode root) {
        backtrack(root,0);
        return sum;
    }
    public void backtrack(TreeNode root, int prevSum){
        prevSum=(prevSum*10)+root.val;
        if(root.left==null && root.right==null){
            sum+=prevSum;
        }
        if(root.left!=null){
            backtrack(root.left,prevSum);
        }
        if(root.right!=null){
            backtrack(root.right,prevSum);
        }
    }
}
// Backtracking DFS Approach
// T.C -> O(n) where n= number of nodes in a tree
// S.C -> O(h) where h= height of tree