package Array.operation;

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] nums_1=new int[m];
            for(int i=0;i<m;i++)
                nums_1[i]=nums1[i];
            int left=0,right=0;
            for(int i=0;i<m+n;i++){
                if(left<m&&right<n){
                    if(nums_1[left]<nums2[right]){
                        nums1[i]=nums_1[left++];
                    }else{
                        nums1[i]=nums2[right++];
                    }
                }else if(left==m){
                    nums1[i]=nums2[right++];
                }else{
                    nums1[i]=nums_1[left++];
                }
            }
    }
}
