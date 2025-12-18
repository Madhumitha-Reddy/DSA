class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int mainGas = 0;
        int idx = 0;
        for(int i=0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            totalGas = totalGas + diff;
            mainGas = mainGas + diff;
            if(mainGas < 0){
            mainGas = 0;
            idx = i + 1;
        }
        }
        return totalGas>=0 ? idx : -1;
    }
}