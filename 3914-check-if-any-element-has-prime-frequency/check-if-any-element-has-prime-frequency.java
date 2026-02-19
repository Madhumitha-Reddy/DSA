class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(freq.containsKey(num)){
                freq.put(num, freq.get(num) + 1);
            }else{
                freq.put(num, 1);
            }
        }

        for(int count : freq.values()){
            if(isPrime(count)){
                return true;
            }
        }

        return false;
    }

    public boolean isPrime(int n){
        if(n <= 1){
            return false;
        }

        for(int i=2; i*i<=n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}