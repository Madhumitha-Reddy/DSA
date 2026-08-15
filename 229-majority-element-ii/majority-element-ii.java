class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int element1 = 0;

        int count2 = 0;
        int element2 = 1;
        for(int i=0; i<nums.length; i++){
            if(count1 == 0 && nums[i] != element2){
                element1 = nums[i];
            }
            if(count2 == 0 && nums[i] != element1){
                element2 = nums[i];

            }
            if(nums[i] == element1){
                count1++;
            }
            else if(nums[i] == element2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == element1){
                count1++;
            }
            if(nums[i] == element2){
                count2++;
            }
        }
        if(count1 > nums.length / 3) list.add(element1);
        if(count2 > nums.length / 3) list.add(element2);

        return list;
    }
}