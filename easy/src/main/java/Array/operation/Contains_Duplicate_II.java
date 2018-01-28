package Array.operation;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length-1;i++){
           for(int j=i+1;j<=i+k&&j<nums.length;j++){
               if(nums[i]==nums[j]) return true;
           }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i])-i)<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
