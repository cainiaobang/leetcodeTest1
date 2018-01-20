package cn.array.find;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Integer[] num=new Integer[target];
        Arrays.sort(nums);
        backTrack(nums,num,result,nums.length-1,0,target);
        return result;
    }
    public void backTrack(int[] nums,Integer[] num,List result,int start,int len,int remain){
        if(remain<0) return;
        else if(remain==0){
            Integer[] resul=new Integer[len];
            System.arraycopy(num,0,resul,0,len);
            result.add(Arrays.asList(resul));
        }else{
            while(start>0&&nums[start]>remain) start--;
                for(int i=start;i>=0;i--){
                    if(i!=start&&nums[i]==nums[i+1]) continue;
                    num[len]=nums[i];
                    backTrack(nums,num,result,i-1,len+1,remain-nums[i]);
                }
        }
    }

    public static void main(String[] args){
        int[] nums={10,1,2,7,6,1,5};
        System.out.println(new Combination_Sum_II().combinationSum2(nums,8));
    }

}
