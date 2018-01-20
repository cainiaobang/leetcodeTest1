package Array.operation;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int sum=nums[0],i=1,max=sum;
        while(i<nums.length){
            if(nums[i]>0) {
                if(sum>=0){
                    sum+=nums[i];
                    if(sum>max) max=sum;
                }else{
                    sum=nums[i];
                    if(sum>max) max=sum;
                }

            }
            else{
                if(sum>0){
                    sum+=nums[i];
                }
                else{
                    if(sum<nums[i]){
                        sum=nums[i];
                        if(sum>max) max=sum;
                    }
                }
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums={-2,5,-3,4,-1};
        System.out.println(new Maximum_Subarray().maxSubArray(nums) );
    }
}
