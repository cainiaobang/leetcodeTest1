package cn.array.find;

public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1,pos=0;
        while(left<=right){
            pos=(left+right)/2;
            if(nums[pos]<target)left=pos+1;
            else if(nums[pos]>target)right=pos-1;
            else return pos;
        }
        if(nums[pos]<target) return pos+1;
        else return pos;
    }

    public static void main(String[] args){
        int[] nums={1,3,5,6};
        System.out.println(new Search_Insert_Position().searchInsert(nums,7));
    }
}
