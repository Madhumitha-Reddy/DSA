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
    public boolean findTarget(TreeNode root, int k) {
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
        int sum = 0;
        int i=0,j = al.size()-1;
        while(i < j){
            sum = al.get(i) + al.get(j);
            if(sum == k) return true;
            else if(sum > k){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}