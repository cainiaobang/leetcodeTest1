package cn.array.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length=candidates.length;
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        int left=0,right=length-1,pos=0;
        while(left<=right){
            pos=(left+right)/2;
            if(candidates[pos]<candidates[right]) left=pos+1;
            else if(candidates[pos]>candidates[right]) right=pos-1;
            else break;
        }
        if((pos-1)>=0&&candidates[pos]>target) pos-=1;
        LinkedList<Integer> list=new LinkedList<Integer>();
        combianation(result,candidates,0,pos,target,list);
        return result;
    }

    public void combianation(List result,int[] nums,int left,int right,int target,List list){
       if(target==0)  result.add(new LinkedList(list));
       else if(target<0) return;
       else {
           for(int i=left;i<=right;i++){
               list.add(nums[i]);
               combianation(result,nums,i,right,target-nums[i],list);
               list.remove((list.size()-1));
           }
       }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<Integer>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        int[] nums={2, 3, 6, 7};
        System.out.println(new Combination_Sum().combinationSum(nums,7));
    }
}
