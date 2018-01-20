package cn.array.find;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations_II {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0) return null;
        Arrays.sort(nums);
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        LinkedList<Integer> list=new LinkedList<Integer>();
        boolean[] mark=new boolean[nums.length];
        int count=0;
        permute2(result,list,nums,mark,count);
        return result;
    }

    public void  permute2(  List<List<Integer>> result,LinkedList<Integer> tempList,int[] nums,boolean[] marks,int count){
        if(count<nums.length){
            for(int i=0;i<nums.length;i++){
                if(!marks[i]){
                    if(i>0&&nums[i]==nums[i-1]&&marks[i-1]) continue;
                    tempList.add(nums[i]);
                    marks[i]=true;
                    permute2(result,tempList,nums,marks,count+1);
                    tempList.removeLast();
                    marks[i]=false;
                }
            }
        }else{
            result.add(new LinkedList<Integer>(tempList));
        }
    }

    public static void main(String[] args){
        int[] nums={1,1,3};
        System.out.println(new Permutations_II().permute(nums) );
    }
}
