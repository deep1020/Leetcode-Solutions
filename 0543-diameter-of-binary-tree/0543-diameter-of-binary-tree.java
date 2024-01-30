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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int diam1=diameterOfBinaryTree(root.left);
        int diam2=diameterOfBinaryTree(root.right);
        int diam3=height(root.left)+height(root.right);
        return Math.max(diam3,Math.max(diam1,diam2));
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        int tree_height=Math.max(leftheight,rightheight)+1;
        return tree_height;
    }
}
// T.C -> O(n^2) nested recursion
// S.C -> O(n) space used by the call stack during the recursive calls.

// diameterOfBinaryTree method:
// calculate diameter of a binary tree
// If root is null, diameter is 0
// It recursively calculates the diameter of the left and right subtrees
// It also calculates diameter that passes through the root (diam3), which is the sum of the heights of the left and right subtrees.

// height method:
// calculates height of a binary tree at root
// If root is null, height is 0
// It recursively calculates the height of the left and right subtrees
// The height of the current tree is the maximum of the heights of the left and right subtrees, plus 1 (Math.max(leftheight, rightheight) + 1).