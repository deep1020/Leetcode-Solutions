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
    List<Integer> list=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return list;
        }
        inorder(root1);
        inorder(root2);
        Collections.sort(list);
        return list;
    }
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
// T.C -> O((n+m)log(n+m))
// Perform inorder traversal on both side of tree takes O(n+m) time where n= number of nodes in 1st tree and
// m= number of nodes in 2nd tree, Adding each nodes value to the list in inorder traversal takes O(1) time. 
// sorting list using Collections.sort() takes O((n+m)log(n+m))
// S.C -> O(n+m)
// ArrayList stores all elements from both trees which takes O(n+m) space
// space used by recursive calls is proportional to the height of trees O(h1+h2)
// Out of these 2 spaces, max space used is O(n+m) as number of elements > height of tree