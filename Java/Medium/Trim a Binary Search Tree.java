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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        
        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        else if(root.val > high){
            return trimBST(root.left, low, high);
        }
        else{
            root.left = trimBST(root.left, low, high);
            
            root.right = trimBST(root.right, low, high);
        }
        
        return root;
    }
    
    //this solution reduce the search space by knowing that the tree is BST
//     public TreeNode trimBST(TreeNode root, int low, int high) {
//         return trimBST(root, low, high, Integer.MAX_VALUE, Integer.MIN_VALUE);
//     }
    
//     private TreeNode trimBST(TreeNode root, int low, int high, int highestValue, int lowestValue) {
//         if(root == null) return null;
        
//         if(root.val < low) return trimBST(root.right, low, high, highestValue, root.val);
//         else if(root.val > high) return trimBST(root.left, low, high, root.val, lowestValue);
//         else{
//             if(highestValue - 1 <= high && lowestValue + 1 >= low){
//                 return root;
//             }
            
//             root.left = trimBST(root.left, low, high, root.val, lowestValue);
            
//             root.right = trimBST(root.right, low, high, highestValue, root.val);
//         }
        
//         return root;
//     }
}
