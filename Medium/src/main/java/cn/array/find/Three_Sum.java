package cn.array.find;

import java.util.*;

public class Three_Sum {
    /**
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> mm=new HashSet<Integer>();
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length;i++) mm.add(nums[i]);
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(mm.contains(0-nums[i]-nums[j])){
                    Integer[] res={nums[i],nums[j],0-nums[i]-nums[j]};
                    result.add(Arrays.asList(res));
                }
            }
        }
        return result;
    }
     */

    /**
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++) {
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        Integer[] res={nums[i],nums[j],nums[k]};
                        result.add(Arrays.asList(res));
                    }
                }
            }
        }
        return result;
    }
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        for(int i=0;i<num.length-2;i++){
            if(i==0 ||(i>0&&num[i]!=num[i-1])){
                    int low=i+1;int high=num.length-1; int sum=0-num[i];
                    while(low<high){
                        if(num[low]+num[high]==sum) {
                            list.add(Arrays.asList(num[i],num[low],num[high]));
                            while(low<high&&num[low]==num[low+1]) low++;
                            while(low<high&&num[high]==num[high-1]) high--;
                            low++;high--;
                        }
                        else if(num[low]+num[high]<sum) low++;
                        else  high--;
                    }
            }
        }
       return list;
    }

    public static void main(String[] args){
        int[] mm={-1,0,1,2,-1,-4};
        List<List<Integer>> res=new Three_Sum().threeSum(mm);
        System.out.println(res);
    }
}
