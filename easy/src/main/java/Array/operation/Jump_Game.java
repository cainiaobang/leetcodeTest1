package Array.operation;

public class Jump_Game {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int jumplength=nums[0],i=0,temp=0,maxLength=jumplength;
        while(maxLength<nums.length-1){
            if(jumplength==0) return false;
            temp=0;
            for(int j=1;j<=jumplength;j++){
                if(i+j+nums[i+j]>temp) temp=i+j+nums[i+j];
            }
            i=maxLength;
            jumplength=temp-maxLength;
            maxLength=temp;
        }
        return true;
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(new Jump_Game().canJump(nums) );
    }
}
