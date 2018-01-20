package cn.array.find;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Four_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            if(i==0 || (i>0&&nums[i]!=nums[i-1])){
               for(int j=i+1;j<nums.length-2;j++){
                   if(j==i+1 || (nums[j]!=nums[j-1])){
                       int low=j+1;int high=nums.length-1;
                       while(low<high) {
                           if (nums[low] + nums[high] + nums[i] + nums[j] == target) {
                               list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                               while(low < high && nums[low] == nums[low + 1]) low++;
                               while(low < high && nums[high] == nums[high - 1]) high--;
                               low++;
                               high--;
                           }else if(nums[low] + nums[high] + nums[i] + nums[j] < target) low++;
                           else high--;
                       }
                   }
               }
            }
        }
        return list;
    }
}
