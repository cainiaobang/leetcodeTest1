package arrays.operation;

public class Jump_Game_II {
    public int jump(int[] nums) {
        int result=jump2(0,nums,0);
        return  result;
    }
    public int jump2(int pos,int[] nums,int count){
            int i=1,min=Integer.MAX_VALUE,temp;
            while(i<=nums[pos]){
                if(pos+i<nums.length-1) temp=jump2(pos+i,nums,count+1);
                else  return (count+1);
                if(temp<min)  min=temp;
                i++;
            }
            return min;
    }

    public int jump3(int[] nums){
        if(nums.length<=1) return 0;
        int level=0,currentMax=0,nextMax=0,i=0;
        while(currentMax-i+1>0){
            level++;
            for(;i<=currentMax;i++){
                nextMax=Math.max(nextMax,nums[i]+i);
                if(nextMax>=nums.length-1) return level;
            }
            currentMax=nextMax;
        }
        return 0;

    }

    public static void main(String[] args){
        int[] nums={5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(new Jump_Game_II().jump3(nums));
    }

}
