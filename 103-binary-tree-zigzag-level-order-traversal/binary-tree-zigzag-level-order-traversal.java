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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wraplist = new ArrayList<>();
        if(root == null)return wraplist;
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0; i<levelNum; i++){
                root = queue.poll();
                if(leftToRight){
                    sublist.add(root.val);
                }else{
                    sublist.add(0, root.val);
                }
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            leftToRight = !leftToRight;
            wraplist.add(sublist);
            
        }
        return wraplist;
    }
}