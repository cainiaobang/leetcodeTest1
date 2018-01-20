package arrays.operation;

public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        int left=0,right=heights.length-1;
        return findMax(heights,left,right);
    }
    public int findMax(int[] heights,int left,int right){
        int max=0;
        if(left>right) return 0;
        int temp_left, temp_right,temp;
        temp= findValue(left,right,heights);
        if(temp>max)max=temp;
        temp_left=findMax(heights,left+1,right);
        temp_right=findMax(heights,left,right-1);
        temp=Math.max(temp_left,temp_right);
        if(temp>max)    max=temp;
        return max;
    }
    public int findValue(int left,int right,int[] height){
        int min=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++)
            if(height[i]<min)  min=height[i];
        return (right-left+1)*min;
    }
    public static void main(String[] args){
        int[] nums={6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        System.out.println(new Largest_Rectangle_in_Histogram().largestRectangleArea(nums) );
    }

}
