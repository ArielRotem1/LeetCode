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
class BSTIterator {
    
    private TreeNode current;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack();
        current = root;
        
        getNext();
    }
    
    public int next() {
        int val = current.val;
        
        current = current.right;
        
        getNext();
        
        return val;
    }
    
    public boolean hasNext() {
        return current != null;
    }
    
    private void getNext(){
        while (current != null) {
            stack.add(current);
            current = current.left;
        }
        
        if(stack.isEmpty()){
            return;
        }
        current = stack.pop();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */