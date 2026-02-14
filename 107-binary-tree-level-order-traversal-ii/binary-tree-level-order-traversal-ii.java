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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int i=0; i<n; i++){
                TreeNode cur = q.peek();
                if(cur != null){
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                    al.add(cur.val);
                    q.poll();
                }
            }
            ans.add(al);
        }
        Collections.reverse(ans);
        return ans;
    }
}