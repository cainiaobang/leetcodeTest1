package union.find;

import java.util.Arrays;

public class Longest_Consecutive_Sequence {
    int result=1;
    int temp=1;
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        boolean[] mark=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(mark[i]) continue;
            temp=1;
            findUtil(nums[i],nums,1,mark);
            findUtil(nums[i],nums,-1,mark);
            if(temp>result) result=temp;
        }
        return result;

    }
    public void findUtil(int num,int[] nums,int differ,boolean[] mark){
        for(int i=0;i<nums.length;i++){
            if(mark[i])continue;
            if(nums[i]-num==differ){
                mark[i]=true;
                temp++;
                findUtil(nums[i],nums,differ,mark);
                break;
            }
        }
    }

    public static void main(String[] args){
        int[] nums={100, 4, 200, 1, 3, 2};
        System.out.println(new Longest_Consecutive_Sequence().longestConsecutive(nums));
    }
}
