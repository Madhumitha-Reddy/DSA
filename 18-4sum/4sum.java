class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                HashSet<Integer> set = new HashSet<>();
                for(int k=j+1; k<nums.length; k++){
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long) target - (sum);
                    if(fourth >= Integer.MIN_VALUE && fourth <= Integer.MAX_VALUE && set.contains((int) fourth)){
                        List<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);

                        Collections.sort(temp);

                        if(!list.contains(temp)){
                            list.add(temp);
                        }
                    }

                    set.add(nums[k]);
                }
            }
        }

        return list;
    }
}