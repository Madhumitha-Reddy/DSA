class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int longest = 1;
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
        }
        for(int it:st){
            if(!st.contains(it - 1)){
                int count = 1;
                int x = it;

                 while(st.contains(x + 1)){
                    x = x + 1;
                    count = count + 1;
                }

            longest = Math.max(longest, count);
        }

        }

        return longest;
    }
}