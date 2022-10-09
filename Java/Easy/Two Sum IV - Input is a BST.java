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
//Time: O(nlogn)
//Space: O(logn)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }
    
    private boolean findTarget(TreeNode root, TreeNode node, int k) {
        if(node == null) return false;
        
        if(hasNode(root, k - node.val, node)) return true;
        
        return findTarget(root, node.left, k) || findTarget(root, node.right, k);
    }
    
    private boolean hasNode(TreeNode node, int val, TreeNode usedNode){
        if(node != usedNode && node.val == val) return true;
        
        if(node.val > val && node.left != null) return hasNode(node.left, val, usedNode);
        if(node.val < val && node.right != null) return hasNode(node.right, val, usedNode);
        
        return false;
    }
}
