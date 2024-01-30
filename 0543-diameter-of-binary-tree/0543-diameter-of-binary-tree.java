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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        diameter=Math.max(diameter,leftheight+rightheight);
        return Math.max(leftheight,rightheight)+1;
    }
}
// T.C -> O(n)
// S.C -> O(n)

// Initializes the diameter variable to keep track of the maximum diameter during the traversal.

// diameterOfBinaryTree method:
// Calls the height method, which calculates the height of each subtree and updates the diameter accordingly
// Returns the calculated diameter

// height method:
// Recursively calculates the height of the binary tree while updating the diameter
// Base case: if the current node (root) is null, the height is considered to be 0
// Recursively calculates the height of the left and right subtrees using calls to height(root.left) and height(root.right)
// Height of the current subtree is the maximum of the heights of the left and right subtrees, plus 1 (Math.max(leftheight, rightheight) + 1)
// Diameter is updated by comparing it with the sum of the heights of the left and right subtrees (diameter = Math.max(diameter, leftheight + rightheight))
// Returns the height of the current subtree
