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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                root = st.pop();
                al.add(root.val);
                root = root.right;
            }
        }
        return al;
    }
}