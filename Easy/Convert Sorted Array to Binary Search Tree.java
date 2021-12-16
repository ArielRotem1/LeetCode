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
    //addToTree(root, nums[indexRight]);
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(nums[nums.length/2]);
        
        solve(0, nums.length/2 - 1, root, nums);
        solve(nums.length/2 + 1, nums.length - 1, root, nums);
        
        return root;
    }
    
    private void solve(int start, int end, TreeNode root, int[] nums){
        if(start > end) return;
        
        int middle = (end - start) / 2 + start;
        
        addToTree(root, nums[middle]);
        
        solve(start, middle - 1, root, nums);
        solve(middle + 1, end, root, nums);
    }
    
    private void addToTree(TreeNode node, int num){
        if(node.val < num){
            //go to right
            if(node.right != null){
                addToTree(node.right, num);
            }
            else{
                node.right = new TreeNode(num);
            }
        }
        else if(node.val > num){
            //go to left
            if(node.left != null){
                addToTree(node.left, num);
            }
            else{
                node.left = new TreeNode(num);
            }
        }
        
        return;
    }
    
    
}