package cn.array.find;

import java.util.Arrays;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean falg=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) {
                    falg=true;
                    break;
                }
            }
        }


    }
}
