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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        
        int prevSize = 1;
        int currSize = 0;
        
        while(prevSize != 0){
            for(int i = 0; i < prevSize; i++){
                TreeNode node = que.poll();
                
                if(i == prevSize - 1) res.add(node.val);
                
                if(node.left != null){
                    que.add(node.left);
                    currSize++;
                }
                if(node.right != null){
                    que.add(node.right);
                    currSize++;
                }
            }
            
            prevSize = currSize;
            currSize = 0;
        }
        
        return res;
    }
}