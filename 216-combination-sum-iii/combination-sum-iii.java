class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinationSum(int start, int k, int n, List<Integer> ds, List<List<Integer>> ans) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (k == 0 || n < 0) return;

        for (int i = start; i <= 9; i++) {
            ds.add(i);
            findCombinationSum(i + 1, k - 1, n - i, ds, ans);
            ds.remove(ds.size() - 1); 
        }
    }
}
