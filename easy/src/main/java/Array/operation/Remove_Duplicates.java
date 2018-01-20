package Array.operation;

import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                nums[i]=Integer.MIN_VALUE;
            }
            else set.add(nums[i]);
        }
        int count=0;
        for(int i=0;i<set.size();i++){
            if(nums[i]==Integer.MIN_VALUE){
                for(int j=i;j<nums.length-1-count;j++){
                    int tmp=nums[j];nums[j]=nums[j+1];nums[j+1]=tmp;
                }
                i--;count++;
            }
        }
        return set.size();
    }
}
