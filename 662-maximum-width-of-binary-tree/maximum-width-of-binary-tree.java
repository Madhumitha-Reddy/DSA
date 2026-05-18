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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return bfs(root);
    }

    public int bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        q.offer(root);
        index.offer(0);

        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int start = index.peek();
            int first = 0;
            int last = 0;

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                int curr = index.poll() - start;
                if(i == 0){
                    first = curr;
                }
                if(i == size - 1){
                    last = curr;
                }

                if(node.left != null){
                    q.offer(node.left);
                    index.offer(2 * curr);
                }

                if(node.right != null){
                    q.offer(node.right);
                    index.offer(2 * curr + 1);
                }
            }

            count = Math.max(count, (int)(last - first + 1));
        }

        return count;
    }
}