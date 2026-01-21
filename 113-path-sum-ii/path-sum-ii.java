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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new  ArrayList<List<Integer>>();
        dfs(root, targetSum, new ArrayList<>(), list);
        return list;
    }

    void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> list){
        if(root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(new ArrayList<>(path)); 
        }else{
            int rem = targetSum - root.val;
            dfs(root.left, rem, path, list);
            dfs(root.right, rem, path, list);
        }

        path.remove(path.size() - 1);
    }
}