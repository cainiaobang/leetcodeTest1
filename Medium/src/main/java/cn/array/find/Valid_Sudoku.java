package cn.array.find;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> setRow=new HashSet<Character>();
        Set<Character> setColumn=new HashSet<Character>();
        int m=0,n=0;
        for(int i=0;i<board.length;i++){
            setRow.clear();setColumn.clear();
            for(int j=0;j<board.length;j++){
                if(board[i][j]!='.'){
                   if(setRow.contains(board[i][j])) return false;
                   else setRow.add(board[i][j]);
                }
                if(board[j][i]!='.'){
                    if(setColumn.contains(board[j][i])) return false;
                    else setColumn.add(board[j][i]);
                }
            }
        }
        for(int i=0;i<board.length-2;i=i+3){
            for(int j=0;j<board.length-2;j=j+3){
                setRow.clear();
                for(int k=i;k<i+3;k++){
                    for(int q=j;q<j+3;q++){
                        if(board[k][q]!='.'){
                            if(setRow.contains(board[k][q]))
                                return false;
                            else setRow.add(board[k][q]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Integer[][] board={{0,1},{3},{5,6,7}};
        Integer[] ac={1,2};
        Collection<Integer> col=Arrays.asList();
        System.out.println(col);

    }

}
