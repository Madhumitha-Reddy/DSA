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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       
        while(!q.isEmpty()){
            int n = q.size();
            int largest = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                TreeNode cur = q.poll();
                largest = Math.max(largest, cur.val);

                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }

            list.add(largest);
        }

        return list;
    }
}