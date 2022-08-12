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
    
    //Time: O(n)
    //Space: O(n)
    public boolean isValidBST(TreeNode root) {
        HashSet<Integer> hs = new HashSet();
        hs.add(root.val);
        return isValidBST(root.left, Integer.MIN_VALUE, root.val, hs) && isValidBST(root.right, root.val, Integer.MAX_VALUE, hs);
    }
    
    private boolean isValidBST(TreeNode node, int lowerBound, int upperBound, HashSet<Integer> hs){
        if(node == null) return true;
        if(hs.contains(node.val)) return false;
        if(node.val < lowerBound || node.val > upperBound) return false;

        hs.add(node.val);
        
        return isValidBST(node.left, lowerBound, node.val, hs) && isValidBST(node.right, node.val, upperBound, hs);
    }
}
