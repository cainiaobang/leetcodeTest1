package cn.array.find;

import java.util.Arrays;

public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int distance,pos=-1;
        for(int i=nums.length-2;i>=0;i--){
            distance=Integer.MAX_VALUE;
            pos=-1;
           for(int j=i+1;j<nums.length;j++){
               if(nums[j]>nums[i]&&nums[j]-nums[i]<=distance){
                   distance=nums[j]-nums[i];
                   pos=j;
               }
           }
           if(pos!=-1) {
               int tmp=nums[i];
               nums[i]=nums[pos];nums[pos]=tmp;
               Arrays.sort(nums,i+1,nums.length);
               break;
           }
        }
        if(pos==-1) Arrays.sort(nums);
    }
    public static void main(String[] args){
        int[] nums={7,4,5,1};
        new Next_Permutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
