public class Container_with_most_water {
    public int maxArea(int[] height) {
        int max=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int result=(j-i)*Math.min(height[i],height[j]);
                if(result>max) max=result;
            }
        }
        return max;
    }
}
