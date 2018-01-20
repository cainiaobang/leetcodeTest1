package arrays.operation;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram3 {
    public int largestRectangleArea(int hist[]){
        if(hist.length==0) return 0;
        Stack<Integer> stack=new Stack<Integer>();
        int result=Integer.MIN_VALUE,temp,i=0;
        while(i<hist.length){
            if(stack.isEmpty() || hist[stack.peek()]<=hist[i] ){
                stack.push(i++);
            }else{
                while(!stack.isEmpty()&&hist[stack.peek()]>hist[i]){
                    Integer m=stack.pop();
                    if(!stack.isEmpty()){
                        temp=hist[m]*(i-stack.peek()-1);
                    }else{
                        temp=hist[m]*i;
                    }
                    if(temp>result) result=temp;
                }
                stack.push(i++);
            }
        }
        while(!stack.isEmpty()){
            Integer m=stack.pop();
            if(!stack.isEmpty()){
                temp=hist[m]*(i-stack.peek()-1);
            }else{
                temp=hist[m]*(i);
            }
            if(temp>result) result=temp;
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums={1,2,3,4};
        System.out.println(new Largest_Rectangle_in_Histogram3().largestRectangleArea(nums));
    }
}
