/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val =   val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int find(TreeNode root, int mx)
    {
        if(root==null)
            return 0;
        
        mx = Math.max(mx,root.val);
        int x = find(root.left,mx);
        int y = find(root.right,mx);
        int p = root.val>=mx ? 1 : 0;
        return x+y+p;
    }
    public int goodNodes(TreeNode root) {
        int mx = root.val;
        return find(root,mx);
    }
}