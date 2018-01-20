package arrays.operation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int result=0;
        for(int i=0;i<matrix.length;i++){
            for( int j=0;j<matrix[0].length;j++){
                int temp=maxUtil(matrix,i,j);
                if(temp>result) result=temp;
            }
        }
        return result;
    }
    public int  maxUtil(char[][] matrix,int row, int col){
        int result=0;
        int[] row_temp=new int[matrix.length];
        int i=row,j=col,temp=-1;
        while(i<matrix.length){
            j=col;
            while(j<matrix[0].length) {
              if(!(matrix[i][j++]=='1')){
                  temp=j-col-1;
                  break;
              }
            }
            if(temp==-1) temp=j-col;
           if(temp>0){
                row_temp[i++]=temp;
            }else{
               break;
           }
        }
       // System.out.println(Arrays.toString(row_temp));
        return findMaxRectangleInArray(row_temp,row,i-1);
    }

    public int findMaxRectangleInArray(int[] nums,int left,int right){
        Stack<Integer> stack=new Stack<Integer>();
        int i=left,result=0,temp,m;
        while(i<=right){
            if(stack.isEmpty() || nums[stack.peek()]<=nums[i]){
                //System.out.println(nums[i]+"   "+"push");
                stack.push(i++);
            }
            else{
                m=stack.pop();
                temp=nums[m]*(!stack.isEmpty()? (i-stack.peek()-1):i-left );
                if(temp>result) result=temp;
               // System.out.println(result);
            }
        }
        while(!stack.isEmpty()){
            m=stack.pop();
            temp=nums[m]*(!stack.isEmpty()? (i-stack.peek()-1):i-left );
            if(temp>result) result=temp;
        }
        return result;
    }

    public static void main(String[] args){
        /**
        int[] nums={2,1,5,6,2,3};
        System.out.println(new Maximal_Rectangle().findMaxRectangleInArray(nums,0,5));
         */
        char[][] nums={{'0','1','1'},{'0','1','1'},{'1','1','0'}};
        //System.out.println(new Maximal_Rectangle().maxUtil(nums,2,0));
        System.out.println(new Maximal_Rectangle().maximalRectangle(nums));
    }


}
