class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height  = new int[m];
        int maxArea = 0;
        for(int i=0; i < n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }

            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] histo){
        int n = histo.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int height = 0;
        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i == n || histo[st.peek()] >= histo[i])){
                height = histo[st.peek()];
                st.pop();

                int width;
                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i - st.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }


            if(i < n){
                st.push(i);
            }
        }
        return maxArea;
    }
}