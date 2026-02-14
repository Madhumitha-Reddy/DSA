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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Long> sums = new ArrayList<>();
        if (root == null) return 0;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            long sum = 0;

            for(int i=0; i<n; i++){
                TreeNode cur = q.poll();
                sum += cur.val;

                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            sums.add(sum);

        }

        if(sums.size() < k) return -1;

        Collections.sort(sums, Collections.reverseOrder());

        return sums.get(k - 1);
    }
}