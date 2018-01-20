package cn.array.find;

import java.util.Arrays;

public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int distance=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            if((i>0&&nums[i]!=nums[i-1])||i==0 ){
                for(int j=i+1;j<nums.length-1;j++){
                    if(j==i+1 || nums[j]!=nums[j-1]){
                        int k=j+1;
                        while(k<nums.length){
                            if(k==j+1|| nums[k]!=nums[k-1]){
                                int sum=nums[k]+nums[i]+nums[j];
                                if(Math.abs(sum-target)<distance){
                                    result=sum;
                                    distance=Math.abs(sum-target);
                                }
                            }
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }

    // 这种处理方法更好
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
       int result=0;
       int distance=Integer.MAX_VALUE;
       for(int i=0;i<nums.length-2;i++) {
           if ((i > 0 && nums[i] != nums[i - 1]) || i == 0) {
               int low = i + 1;
               int high = nums.length - 1;
               while (low < high) {
                   int sum = nums[i] + nums[low] + nums[high];
                   int dis = Math.abs(sum - target);
                   if (dis < distance) {
                       result = sum;
                       distance = dis;
                       if (dis == 0) return sum;
                   }
                   if (sum < target) low++;
                   else high--;
               }
           }
       }
       return result;
    }
    public static void main(String[] args){
        int[] nums={-1,0,1,1,55};
        System.out.println(new ThreeSumClosest().threeSumClosest2(nums,3));
    }
}
