package cn.array.find;

public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
         int left=0,right=nums.length-1,pos=0;
         int[] position={-1,-1};
         while(left<=right){
             pos=(left+right)/2;
             if(nums[pos]<target)left=pos+1;
             else if(nums[pos]>target) right=pos-1;
             else{
                 left=pos;
                 while((left-1)>=0&&nums[left]==nums[left-1]) left--;
                 position[0]=left;
                 while((pos+1)<nums.length&&nums[pos+1]==nums[pos]) pos++;
                 position[1]=pos;
                 return position;
             }
         }
         return position;
    }
}
