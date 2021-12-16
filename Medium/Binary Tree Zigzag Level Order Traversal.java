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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if(root == null) return result;
        
        List<Integer> currRow = new ArrayList();
        
        Queue<TreeNode> que = new ArrayDeque();
        
        que.add(root);
        
        int currSize = 0;
        int prevSize = 1;
        int depth = 0;
        
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(depth % 2 == 0) currRow.add(node.val);
            else currRow.add(0, node.val);

            if(node.left != null){
                que.add(node.left);
                currSize++;
            }
            if(node.right != null){
                que.add(node.right);
                currSize++;
            }
            
            prevSize--;
            
            if(prevSize == 0){
                
                prevSize = currSize;
                currSize = 0;
                depth++;
                
                result.add(currRow);
                currRow = new ArrayList();
            }
        }
        
        return result;
    }
}