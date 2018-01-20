package cn.array.find;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0) return null;
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        LinkedList<Integer> list=new LinkedList<Integer>();
        int[] mark=new int[nums.length];
        int count=0;
        permute2(result,list,nums,mark,count);
        return result;
    }

    public void  permute2(  List<List<Integer>> result,LinkedList<Integer> tempList,int[] nums,int[] marks,int count){
        if(count<nums.length){
            for(int i=0;i<nums.length;i++){
                if(marks[i]!=1){
                    tempList.add(nums[i]);
                    marks[i]=1;
                    permute2(result,tempList,nums,marks,count+1);
                    tempList.removeLast();
                    marks[i]=0;
                }
            }
        }else{
            result.add(new LinkedList<Integer>(tempList));
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(new Permutations().permute(nums) );
    }

}
