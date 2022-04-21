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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        solve(root, 0);
        return root;
    }
    
    private int solve(TreeNode curr, int add){
        if(curr.right != null){
            curr.val += solve(curr.right, add);
            add = 0;
        }

        curr.val += add;
        
        if(curr.left != null) return solve(curr.left, curr.val);
        
        
        return curr.val;
    }
}
