package cn.array.find;

import java.util.Arrays;

public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        for(int i=0;i<result.length;i++){
            Arrays.fill(result[i],-1);
        }
        int[] row={0,1,0,-1};
        int[] col={1,0,-1,0};
        int posRow=0,posCol=0,k=0;
        for(int i=1;i<=n*n;i++){
            result[posRow][posCol]=i;
            if(posRow+row[k]==n || posCol+col[k]==n   || posCol+col[k]==-1 || result[posRow+row[k]][posCol+col[k]]!=-1 ){
                k++;
                k%=4;
            }
            posRow=posRow+row[k];
            posCol=posCol+col[k];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new Spiral_Matrix_II().generateMatrix(3) );
    }
}
