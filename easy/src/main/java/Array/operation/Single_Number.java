package Array.operation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Single_Number {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Map.Entry<Integer,Integer>> entry=map.entrySet();
        for(Map.Entry<Integer,Integer> en:entry){
            if(en.getValue()==1) return en.getKey();
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        return num;
    }

    public int singleNumber3(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        long sum=0,sum2=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            set.add(nums[i]);
        }
        for(Integer i:set){
            sum2+=i;
        }
        return (int)((sum2*3-sum)/2);
    }

    public static void main(String[] args){
        int[] nums={1};
        System.out.println(new Single_Number().singleNumber3(nums) );
    }
}
