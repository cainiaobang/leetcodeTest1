package cn.treeNode.operation;

import java.awt.*;
import java.util.*;

public class Surrounded_Regions {
    public void solve(char[][] board) {
        if(board.length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X') continue;
                boolean[][] mark=new boolean[board.length][board[0].length];
                mark[i][j]=true;
                Set<Point> set=new HashSet<Point>();
                Queue<Point> queue=new LinkedList<Point>();
                queue.add(new Point(i,j));
                set.add(new Point(i,j));
                boolean flag=false;
                while(!queue.isEmpty()&&!flag){
                        Point point=queue.poll();
                      if(point.x==0 || point.x==board.length-1 || point.y==0 || point.y==board[0].length-1){
                         flag=true;break;
                     }
                    // System.out.println(point.x+"  "+point.y);
                        if(point.x-1>=0&&board[point.x-1][point.y]=='O'){
                            if(!mark[point.x-1][point.y]){
                                set.add(new Point(point.x-1,point.y));
                                queue.add(new Point(point.x-1,point.y));
                                mark[point.x-1][point.y]=true;
                            }
                            if(point.x-1==0) {flag=true;break;}
                        }
                        if(point.x+1<=board.length-1&&board[point.x+1][point.y]=='O'){
                            if(!mark[point.x+1][point.y]){
                                set.add(new Point(point.x+1,point.y));
                                queue.add(new Point(point.x+1,point.y));
                                mark[point.x+1][point.y]=true;
                            }
                            if(point.x+1==board.length-1) {flag=true;break;}
                        }
                        if(point.y-1>=0&&board[point.x][point.y-1]=='O'){
                            if(!mark[point.x][point.y-1]){
                                set.add(new Point(point.x,point.y-1));
                                queue.add(new Point(point.x,point.y-1));
                                mark[point.x][point.y-1]=true;
                            }
                            if(point.y-1==0) {flag=true;break;}
                        }
                        if(point.y+1<=board[0].length-1&&board[point.x][point.y+1]=='O'){
                            if(!mark[point.x][point.y+1]){
                                set.add(new Point(point.x,point.y+1));
                                queue.add(new Point(point.x,point.y+1));
                                mark[point.x][point.y+1]=true;
                            }
                            if(point.y+1==board[0].length-1) {flag=true;break;}
                        }
                }
                if(!flag&&queue.isEmpty()){
                    Iterator<Point> iterator=set.iterator();
                    while(iterator.hasNext()){
                        Point p=iterator.next();
                        board[p.x][p.y]='X';
                    }
                }
            }
        }
    }

    public static void main(String[] args){


        char[][] map={
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X' ,'O','X','X'}
        };

       // char[][] map={{'0','0','0'},{'0','0','0'},{'0','0','0'}};
        new Surrounded_Regions().solve(map);
        for(int i=0;i<map.length;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public void solve2(char[][] board) {
        int rown = board.length;
        if (rown==0) return;
        int coln = board[0].length;
        for (int row=0; row<rown; ++row) {
            for (int col=0; col<coln; ++col) {
                if (row==0 || row==rown-1 || col==0 || col==coln-1) {
                    if (board[row][col]=='O') {
                        Queue<Integer> q = new LinkedList<Integer>();
                        board[row][col]='1';
                        q.add(row*coln+col);
                        while (!q.isEmpty()) {
                            int cur = q.poll();
                            int x = cur/coln;
                            int y = cur%coln;
                            if (y+1<coln && board[x][y+1]=='O') {
                                q.add(cur+1);
                                board[x][y+1] = '1';
                            }
                            if (x+1<rown && board[x+1][y]=='O') {
                                q.add(cur+coln);
                                board[x+1][y] = '1';
                            }
                            if (y-1>=0 && board[x][y-1]=='O') {
                                q.add(cur-1);
                                board[x][y-1] = '1';
                            }
                            if (x-1>=0 && board[x-1][y]=='O') {
                                q.add(cur-coln);
                                board[x-1][y] = '1';
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<rown; ++i) {
            for (int j=0; j<coln; ++j) {
                if (board[i][j]=='O') {
                    board[i][j]='X';
                } else if (board[i][j]=='1') {
                    board[i][j]='O';
                }
            }
        }
    }
}
