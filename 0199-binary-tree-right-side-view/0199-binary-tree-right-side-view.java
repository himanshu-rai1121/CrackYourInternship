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
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        que.offer(root);
        while(!que.isEmpty())
        {
            int n = que.size();
            
            ans.add(que.peek().val);
            
            for(int i=0;i<n;i++)
            {
                TreeNode temp = que.poll();
                if(temp.right!=null)
                    que.offer(temp.right);
                if(temp.left!=null)
                    que.offer(temp.left);
            }
            
        }
        return ans;

    }
}