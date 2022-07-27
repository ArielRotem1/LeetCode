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
    
    public void flatten(TreeNode root) {
        flatten(null, root);
    }
    
    private TreeNode flatten(TreeNode currNodeInLinkedList, TreeNode node){
        
        if(node == null) return currNodeInLinkedList;
        
        if(currNodeInLinkedList != null){
            currNodeInLinkedList.right = node;
            currNodeInLinkedList = currNodeInLinkedList.right;
        }
        else currNodeInLinkedList = node;
        
        TreeNode left = node.left;
        TreeNode right = node.right;
            
        node.left = null;
        node.right = null;

        currNodeInLinkedList = flatten(currNodeInLinkedList, left);

        currNodeInLinkedList = flatten(currNodeInLinkedList, right);
        
        return currNodeInLinkedList;
    }
}
