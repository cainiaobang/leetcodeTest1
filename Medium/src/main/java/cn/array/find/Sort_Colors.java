package cn.array.find;

import java.util.Arrays;
import java.util.LinkedList;

public class Sort_Colors {
    public void sortColors(int[] nums) {
        if(nums.length==0) return;
        int red=0,blue=0,white=0;
        int[] red_num=new int[nums.length];
        int[] blue_num=new int[nums.length];
        int[] white_num=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) red_num[red++]=nums[i];
            else if(nums[i]==1) blue_num[blue++]=nums[i];
            else white_num[white++]=nums[i];
        }
        int i=0,j=0,k=0,p=0;
        while(j<red){
            nums[i++]=red_num[j++];
        }
        while(k<blue){
            nums[i++]=blue_num[k++];
        }
        while(p<white){
            nums[i++]=white_num[p++];
        }
    }

    public static void main(String[] args){
        int[] nums={0};
        new Sort_Colors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
