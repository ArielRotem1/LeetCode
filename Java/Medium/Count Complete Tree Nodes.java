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
    
    //Time: O(log(n)^2)
    //Space: O(log(n))
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1;
        
        int length = (int) Math.pow(2, getDepth(root) - 1);
        int result = length - 1;
        
        int left = 0, right = length - 1;
        
        while(left < right){
            
            int mid = (int) Math.round((right - left) / 2.0) + left;
            int copyMid = mid;
            
            TreeNode node = root;
            
            int temp = length / 2;
            
            while(mid > 0){
                //go right
                if(mid >= temp){
                    node = node.right;
                    mid -= temp;
                }
                //go left
                else node = node.left;
                
                temp /= 2;
            }
            
            while(temp >= 1){
                node = node.left;
                temp /= 2;   
            }
            
            //not same depth
            if(node != null) left = copyMid;
            //same depth
            else{
                right = copyMid;
                
                if(left + 1 == right) return result + left + 1;
            }
        }

        return result + left + 1;
    }
    
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        
        return 1 + getDepth(root.left);
    }
}
