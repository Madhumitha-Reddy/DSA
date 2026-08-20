class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            list.add(nums1[i]);
        }

        for(int i=0; i<n; i++){
            list.add(nums2[i]);
        }

        Collections.sort(list);
            int left = 0;
            int right = list.size() - 1;
            int mid = left + (right - left) / 2;
            if(list.size() % 2 != 0){
                return list.get(mid);
            }else{
                int mid1 = list.get(mid);
                int mid2 = list.get(mid + 1);

                return (double) (mid1 + mid2) / 2;
            }
    }
}