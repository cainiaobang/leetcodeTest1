package Array.operation;

import java.util.Arrays;

public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int tmp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<nums.length&&nums[nums[i]-1]!=nums[i]){
                tmp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=tmp;
                i--;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args){
        int[] nums={5,3,1,2};
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
            System.out.println(Arrays.toString(nums));
        }

    }
}
