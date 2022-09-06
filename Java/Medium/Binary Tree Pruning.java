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
    public TreeNode pruneTree(TreeNode node) {
        //Time: O(n)
        //Space:O(1)
        if(node == null) return null;
        
        boolean isZeroLeft = pruneTree(node.left) == null;
        
        if(isZeroLeft) node.left = null;
        
        boolean isZeroRight = pruneTree(node.right) == null;
        
        if(isZeroRight) node.right = null;
        
        if(isZeroRight && isZeroLeft && node.val == 0) return null;
        
        return node;
    }
}
