package cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Minimum_Path_Sum {

    //DFS
    public int minPathSum(int[][] grid) {
        int[][] mark=new int[grid.length][grid[0].length];
        for(int i=0;i<mark.length;i++)
            Arrays.fill(mark[i],-1);
        Point start=new Point(0,0);
        Point end=new Point(grid.length-1,grid[0].length-1);
        Stack<Point> stack=new Stack<Point>();
        stack.push(start);
        mark[start.x][start.y]=grid[start.x][start.y];
        while(!stack.isEmpty()){
            Point p=stack.peek();
            Point next=getNext(p,mark,grid);
            if(next!=null){
                stack.push(next);
                mark[next.x][next.y]=mark[p.x][p.y]+grid[next.x][next.y];
            }else{
                stack.pop();
            }
        }
        return mark[grid.length-1][grid[0].length-1];
    }

    public Point getNext(Point p,int[][] mark,int[][] grid){
        if(p.x+1<mark.length){
            if(mark[p.x+1][p.y]==-1 || mark[p.x+1][p.y]>mark[p.x][p.y]+grid[p.x+1][p.y]){
                return new Point(p.x+1,p.y);
            }
        }
        if(p.y+1<grid[0].length){
            if(mark[p.x][p.y+1]==-1 || mark[p.x][p.y+1]>mark[p.x][p.y]+grid[p.x][p.y+1]){
                return  new Point(p.x,p.y+1);
            }
        }
        return null;
    }


    //BFS
    public int minPathSum2(int[][] grid) {
        int [][] mark=new int[grid.length][grid[0].length];
        for(int i=0;i<mark.length;i++)
            Arrays.fill(mark[i],-1);
        Point start=new Point(0,0);
        Point end=new Point(grid.length-1,grid[0].length-1);
        Queue<Point> queue=new LinkedList<Point>();
        queue.offer(start);
        mark[start.x][start.y]=grid[start.x][start.y];
        while(!queue.isEmpty()){
            Point p=queue.poll();
            if(p.x+1<mark.length){
                if(mark[p.x+1][p.y]==-1 ){
                    mark[p.x+1][p.y]=mark[p.x][p.y]+grid[p.x+1][p.y];
                    queue.offer(new Point(p.x+1,p.y));
                }else if(mark[p.x+1][p.y]>mark[p.x][p.y]+grid[p.x+1][p.y]){
                    mark[p.x+1][p.y]=mark[p.x][p.y]+grid[p.x+1][p.y];
                }
            }
            if(p.y+1<grid[0].length){
                if(mark[p.x][p.y+1]==-1){
                    mark[p.x][p.y+1]=mark[p.x][p.y]+grid[p.x][p.y+1];
                    queue.offer(new Point(p.x,p.y+1));
                }
                else if(mark[p.x][p.y+1]>mark[p.x][p.y]+grid[p.x][p.y+1]){
                    mark[p.x][p.y+1]=mark[p.x][p.y]+grid[p.x][p.y+1];
                }
            }
        }
        return  mark[grid.length-1][grid[0].length-1];
    }

    //DP
    public int minPathSum3(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}

class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

}
