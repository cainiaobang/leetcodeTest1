import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int length=nums.length;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]+nums[j]==target){
                    int[] result={i,j};
                    return result;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
              int[] result={i,map.get(target-nums[i])};
              return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
