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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedNodes=new ArrayList<>();
        inorder(root,sortedNodes);
        return sortedArrayToBST(sortedNodes,0,sortedNodes.size()-1);
    }
    private void inorder(TreeNode root,List<Integer> sortedNodes){
        if(root==null){
            return;
        }
        inorder(root.left,sortedNodes);
        sortedNodes.add(root.val);
        inorder(root.right,sortedNodes);
    }
    private TreeNode sortedArrayToBST(List<Integer> sortedNodes,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(sortedNodes.get(mid));
        node.left=sortedArrayToBST(sortedNodes,left,mid-1);
        node.right=sortedArrayToBST(sortedNodes,mid+1,right);
        return node;
    }
}
// T.C -> O(n) inorder function iterates each node exactly once taking O(n) time
// S.C -> O(n) ArrayList stores sorted sequence of inorder traversal, taking O(n) space

// inorder function performs in-order traversal of tree and stores node values in a sorted list of node values.
// sortedArrayToBST function constructs a balanced BST from sorted list
// It recursively selects the middle element of the current subarray as the root and then constructs the left and right subtrees from the left and right subarrays respectively.