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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return 0;
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()){
            int n = q.size();
            sum = 0;
            for(int i=0; i<n; i++){
                TreeNode cur = q.poll();

                sum += cur.val;

                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                
            }

        }
        return sum;
    }
}