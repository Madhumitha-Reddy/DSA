class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind; i<nums.length; i++){
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}