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
    public int kthSmallest(TreeNode root, int k) {
        
        if(root.left != null){
            int res = kthSmallest(root.left, k);
            if(res >= 0) return res;
            else k = -res;
        }
        
        if(k == 1){
            return root.val;
        }
        else if(k > 1){
            k--;
        }
        
        if(root.right != null){
            int res = kthSmallest(root.right, k);
            if(res >= 0) return res;
            else k = -res;
        }
            
        return -k;
    }
}
