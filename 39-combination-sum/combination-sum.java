class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, 0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    void helper(int index, int sum, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans){
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length || sum > target) {
            return;
        }
        list.add(candidates[index]);
        helper(index, sum + candidates[index], candidates, target, list, ans);

        list.remove(list.size() - 1);
        helper(index + 1, sum, candidates, target, list, ans);
    }
}