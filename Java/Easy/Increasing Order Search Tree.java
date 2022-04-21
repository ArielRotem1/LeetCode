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
    public TreeNode increasingBST(TreeNode root) {
        return solve(root, null);
    }
    
    private TreeNode solve(TreeNode curr, TreeNode prev){
        
        if(curr.right != null){
            curr.right = solve(curr.right, prev);
            prev = null;
        }
        
        if(prev != null){
            prev.left = null;
            curr.right = prev;
        }

        if(curr.left != null){
            return solve(curr.left, curr);
        }

        curr.left = null;

        return curr;
    }
}
