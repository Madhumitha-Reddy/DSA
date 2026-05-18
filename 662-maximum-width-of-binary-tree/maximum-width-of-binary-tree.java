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
        List<Long> list = new ArrayList<>();
        return dfs(root, 0, 0, list);
    }

    public int dfs(TreeNode root,int level, long index, List<Long> list){
        if(root == null) return 0;

        if(level == list.size()){
            list.add(index);
        }

        int maxWidth = (int)(index - list.get(level) + 1);

        int left = dfs(root.left, level + 1, 2 * index, list);
        int right = dfs(root.right, level + 1, 2 * index + 1, list);

        return Math.max(maxWidth, Math.max(left, right));
    }
}