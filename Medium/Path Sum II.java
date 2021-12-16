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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        
        pathSum(root, result, new ArrayList<Integer>(), targetSum - root.val);
        
        return result;
    }
    
    private void pathSum(TreeNode node, List<List<Integer>> result, List<Integer> 
        currPath, int targetSum){

        currPath.add(node.val);
        
        if(node.left == null && node.right == null && targetSum == 0){
            result.add(new ArrayList<Integer>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        
        if(node.left != null){
            pathSum(node.left, result, currPath, targetSum - node.left.val);
        }
        if(node.right != null){
            pathSum(node.right, result, currPath, targetSum - node.right.val);
        }
        
        currPath.remove(currPath.size() - 1);
    }
    
}