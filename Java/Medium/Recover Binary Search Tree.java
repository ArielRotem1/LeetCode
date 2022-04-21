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
    private TreeNode node1;
    private TreeNode node2;
    
    public void recoverTree(TreeNode root) {
        recoverTree(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
        
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    
    private boolean recoverTree(TreeNode node, TreeNode min, TreeNode max){
        if(node == null) return false;
        
        if(node.val < min.val){
            if(node1 == null){
                node1 = node;
                node2 = min;
                return recoverTree(node.left, node, node2) || recoverTree(node.right, node2, max);
            }
            else{
                node2 = node;
                return true;
            }
        }
        else if(node.val > max.val){
            if(node1 == null){
                node1 = node;
                node2 = max;
                return recoverTree(node.left, min, node2) || recoverTree(node.right, node2, node);
            }
            else{
                node2 = node;
                return true;
            }
        }   
        return recoverTree(node.left, min, node) || recoverTree(node.right, node, max);
    }
}
