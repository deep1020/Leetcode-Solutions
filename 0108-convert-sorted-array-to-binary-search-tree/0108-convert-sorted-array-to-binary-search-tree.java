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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length-1);
    }
    public TreeNode BST(int nums[],int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left=BST(nums,start,mid-1);
        newNode.right=BST(nums,mid+1,end);
        return newNode;
    }
}
// T.C -> O(n)
// S.C -> O(1)

// Divide and Conquer and Inorder Traversal
// Here Inorder Traversal of BST is always sorted.
// Mid element will be root element. Left side (smaller elements) will be range of start to mid-1. and Right side will have range from mid+1 to end.   