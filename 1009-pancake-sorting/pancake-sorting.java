class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=arr.length; i>1; i--){
            int maxIndex = 0;
            for(int j=1; j<i; j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }

            }
            if(maxIndex == i - 1){
                continue;
            }

            if(maxIndex != 0){
                reverse(arr, 0, maxIndex);
                list.add(maxIndex + 1);
            }

            reverse(arr, 0 , i-1);
            list.add(i);
        }
        return list;
    }

    public void reverse(int[] arr, int low, int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }   

}