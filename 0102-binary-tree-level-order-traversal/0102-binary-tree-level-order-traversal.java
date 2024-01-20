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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level_list=new ArrayList<>();
            int size=q.size(); // Initialize before for loop as queue size is dynamic
            for(int i=0;i<size;i++){
                TreeNode currNode=q.poll();
                level_list.add(currNode.val);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            result.add(level_list);
        }
        return result;
    }
}
// T.C -> O(n) where n = number of nodes in binary tree as we visit each node in the tree exactly once
// S.C -> O(n) where n = number of nodes in binary tree. In worst case, queue can store all the nodes of the last level of the binary tree, which is approximately half of the total number of nodes in the tree

// When level change to next, initialize new ArrayList and add elements of current level
// 1) Base case: If root is null, return null ArrayList
// 2) Add root element in queue: {3}
// 3) Iterate while loop until queue becomes empty
// 4) Create ArrayList to store elements at current level
// 5) Initialize size of queue before traverse through queue elements because the size of the queue changes dynamically as you may add new nodes to it during the traversal which will affect the changes in the queue size.
// 6) Iterate for loop to traverse all elements in queue
// 7) Remove current node from queue: {} (Help to include other elements at next level)
// 8) Add currnt node in ArrayList [3]
// 9) If there is an element to the left of current node(3), add it in a queue: {9}
// 10) If there is an element to the right of current node(3), add it in a queue: {9,20}
// 11) Add all elements in result ArrayList at current level: [[3]]

// For loop end since size of queue was 1
// Now in a queue, we have 2 elements that we added: {9,20}
// Reinitialize ArrayList for the next level
// Next iteration of for loop, size of queue is 2
// Remove current node from queue: {20}
// Add current node in ArrayList: [[3],[9]]
// There is no element to the left and right of current node(9)
// In the next iteration of for loop, remove current node from queue: {}
// Add current node in ArrayList: [[3],[9,20]]
// There is one element to the left as well as right of current node(20)
// Add them in a queue: {15,7}
// Same process going on and we get level order ArrayList: [[3],[9,20],[15,7]]
// Finally return result ArrayList: [[3],[9,20],[15,7]]