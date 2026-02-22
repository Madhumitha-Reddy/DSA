class Solution {
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int rev = reverse(num);
            int diff = num - rev;

            if(map.containsKey(diff)){
                count = (count + map.get(diff)) % mod;
            }

            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        return (int)count;
    }

    public int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}