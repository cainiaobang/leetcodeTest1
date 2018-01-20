package cn.array.find;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int left=0,right=1,count=1,count_num=0;
        int[] result=new int[nums.length];
        result[0]=nums[0];
        while(right<nums.length){
            if(nums[left]==nums[right]){
                if(count_num>1){
                    left=right;
                    right++;
                }
                else{
                    left=right;
                    result[count++]=nums[right++];
                    count_num=2;
                }
            }
            else {
                left=right;
                 result[count++]=nums[right++];
                count_num=0;
            }
        }
        for(int i=0;i<count;i++){
            nums[i]=result[i];
        }
        return count;
    }

    public static  void main(String[] args){
        int[]nums={1,1,1,2,2,3};
        System.out.println(new Remove_Duplicates_from_Sorted_Array_II().removeDuplicates(nums));
    }
}
