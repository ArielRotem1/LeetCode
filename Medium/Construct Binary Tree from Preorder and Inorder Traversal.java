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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] rootIndex = {-1};

        return buildTree(0, inorder.length - 1, preorder, inorder, rootIndex);
    }
    
    private TreeNode buildTree(int start, int end, int[] preorder, int[] inorder, int[] rootIndex){
        
        if(start > end) return null;
        
        rootIndex[0]++;
        
        TreeNode node = new TreeNode(preorder[rootIndex[0]]);
        
        int i = start;
        for(; inorder[i] != node.val; i++);
        
        node.left = buildTree(start, i - 1, preorder, inorder, rootIndex);
        node.right = buildTree(i + 1, end, preorder, inorder, rootIndex);
        
        return node;
    }
}