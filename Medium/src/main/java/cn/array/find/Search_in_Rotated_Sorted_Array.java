package cn.array.find;

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int pos=-1,left=0,right=nums.length-1,length=nums.length;
        if(length==0) return -1;
        while(left<right){
            pos=(left+right)/2;
            if(nums[pos]>=nums[0]) {
                if((pos+1)<(length)&&nums[pos]<nums[pos+1]) left=pos+1;
                else { pos=pos+1;break;}
            }
            else  {
                if((pos-1)>-1&&nums[pos]>nums[pos-1]) right=pos-1;
                else break;
            }
        }
        if(pos==-1)  return(nums[0]==target? 0:-1);
        int pos1=find(nums,0,pos-1,target);
        if(pos1!=-1){
            return pos1;
        }else{
            int pos2=find(nums,pos,length-1,target);
            return pos2!=-1? pos2:-1;
        }
    }
    public int find(int[] nums,int left,int right,int value){
        int pos=0;
        while(left<=right){
            pos=(left+right)/2;
            if(nums[pos]<value) left=pos+1;
            else if(nums[pos]>value) right=pos-1;
            else  return pos;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] num={3,1};
        System.out.println(new Search_in_Rotated_Sorted_Array().search(num,1));
    }

}
