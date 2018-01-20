package cn.array.find;

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<=0 || matrix[0].length<=0) return false;
        for(int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0]&&target<=matrix[i][matrix[0].length-1]){
                int left=0,right=matrix[0].length-1,middle=0;
                while(left<=right){
                    middle=(left+right)/2;
                    if(matrix[i][middle]>target) right=middle-1;
                    else if(matrix[i][middle]<target)left=middle+1;
                    else return  true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] nums={{1,3}};
        System.out.println(new Search_a_2D_Matrix().searchMatrix(nums,3) );
    }
}
