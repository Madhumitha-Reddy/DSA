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
    int temp;
    boolean flag = true;
    void pre(TreeNode root){
        if(root==null)return;
        if(root.val != temp){
            flag = false;
            return;
        } 
        pre(root.left);
        pre(root.right);
    }
    public boolean isUnivalTree(TreeNode root) {
        temp = root.val;
        pre(root);
        return flag;
    }
}