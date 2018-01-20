package cn.heap;

import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest2(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            if(i<k){
                for(int j=i;j>0;j--){
                    if(nums[j]>nums[j-1]){
                        int temp=nums[j];
                        nums[j]=nums[j-1];
                        nums[j-1]=temp;
                    }else
                        break;
                }
            }else{
                if(nums[i]>nums[k-1]) nums[k-1]=nums[i];
                else continue;
                for(int j=k-1;j>0;j--){
                    if(nums[j]>nums[j-1]){
                        int temp=nums[j];
                        nums[j]=nums[j-1];
                        nums[j-1]=temp;
                    }else
                        break;
                }
            }
        }
        return nums[k-1];
    }

    public int findKthLargest(int[] nums, int k) {
      return findUtil(nums,k,0,nums.length-1);
    }

    public int findUtil(int[] nums,int k,int left,int right){
        int x=partition(nums,left,right);
        if(x+1==k){
            return nums[x];
        }else if(x+1>k){
            return  findUtil(nums,k,left,x-1);
        }else{
           return   findUtil(nums,k,x+1,right);
        }
    }

    public int  partition(int[] nums,int left,int right){
        int x=nums[right];
                int j=left;
                for(int i=left;i<right;i++){
                    if(nums[i]>x){
                        swap(nums,i,j++);
            }
        }
        swap(nums,j,right);
        return j;
    }
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];nums[y]=temp;
    }
    public static void main(String[] args){
        int[] nums={2,1,6,4,3};
        System.out.println(new Kth_Largest_Element_in_an_Array().findKthLargest(nums,4) );
        System.out.println(Arrays.toString(nums));
    }
}
