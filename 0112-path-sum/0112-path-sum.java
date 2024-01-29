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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return targetSum==root.val;
        }
        boolean leftSum=hasPathSum(root.left,targetSum-root.val);
        boolean rightSum=hasPathSum(root.right,targetSum-root.val);
        return leftSum || rightSum;
    }
}
// T.C -> O(n) n= number of nodes in a tree
// S.C -> O(h) h= height of a tree

// Recursion Approach
// 1) If root is none, there isn't any path with desired sum. 
// 2) If root has no childern, the function checks whether the value of leaf node is equal to the remaining targetSum. If they are equal, return true i.e valid path with the targetSum has been found.
// 3) If above base cases are not met, the function recursively checks for a valid path with the targetSum in both left and right subtrees. It subtracts the value of current node from targetSum before passing it to recursive calls.
// 4) Result of recursive calls on the left and right subtrees are then combined using logical OR operation. If either the left or right subtree has a valid path, return true otherwise it returns false.