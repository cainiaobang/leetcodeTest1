package cn.array.find;

import java.util.Arrays;

public class Word_Search {
    public boolean exist(char[][] board, String word) {
        boolean[][] mark=new boolean[board.length][board[0].length];
        for(int i=0;i<mark.length;i++){
            Arrays.fill(mark[i],false);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(match(board,word,mark,i,j,0))return true;
            }
        }
        return false;
    }
    public boolean match(char[][] board,String word,boolean[][] mark,int row,int col,int count){
        if(count==word.length()) return true;
        if(row<0||row>=board.length||col<0||col>=board[0].length||mark[row][col]|| board[row][col]!=word.charAt(count)) return false;
        else{
            mark[row][col]=true;
            if(match(board,word,mark,row-1,col,count+1)) return true;
            if(match(board,word,mark,row+1,col,count+1)) return true;
            if(match(board,word,mark,row,col-1,count+1)) return true;
            if(match(board,word,mark,row,col+1,count+1)) return true;
            mark[row][col]=false;
        }
        return false;
    }

    public static void main(String[] args){
        char[][] nums={ {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Word_Search().exist(nums,"ABCB"));
    }
}
