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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return 0;
        q.add(root);
        int value = root.val;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode cur = q.poll();
                if(i == 0){
                    value = cur.val;
                }
                if(cur != null){
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                }
            }
        }
        return value;
    }
}