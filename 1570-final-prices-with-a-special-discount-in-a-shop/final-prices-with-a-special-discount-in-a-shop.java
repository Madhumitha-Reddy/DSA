class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!st.isEmpty() && prices[i] <= prices[st.peek()]){
                int index = st.pop();
                prices[index] = prices[index] - prices[i];
            }
            st.push(i);
        }

        return prices;
    }
}