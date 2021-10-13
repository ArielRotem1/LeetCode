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
    public boolean isSubtree(TreeNode currNode, TreeNode subRoot) {
        if(currNode == null) return false;
        
        if(currNode.val == subRoot.val){
            if(isSubTree(currNode, subRoot)){
                return true;
            }
        }
        
        boolean resultLeft = isSubtree(currNode.left, subRoot);
        if(resultLeft) return true;
        
        boolean resultRight = isSubtree(currNode.right, subRoot);
        
        return resultRight;
    }
    
    private boolean isSubTree(TreeNode currNode, TreeNode subTree){
        if((currNode.left != null && subTree.left == null) ||
          (currNode.left == null && subTree.left != null)) return false;
        if((currNode.right != null && subTree.right == null) ||
          (currNode.right == null && subTree.right != null)) return false;
        
        if(currNode.left != null && subTree.left != null){
            if(currNode.left.val != subTree.left.val) return false;
            
            boolean result = isSubTree(currNode.left, subTree.left);
            if(!result) return false;
        }
        
        if(currNode.right != null && subTree.right != null){
            if(currNode.right.val != subTree.right.val) return false;
            
            boolean result = isSubTree(currNode.right, subTree.right);
            if(!result) return false;
        }
        
        return true;
    }
}
