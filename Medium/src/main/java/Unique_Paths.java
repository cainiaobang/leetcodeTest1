import java.awt.*;
import java.util.*;

public class Unique_Paths {
    public int uniquePaths(int m, int n){
       return getPath(m,n);
    }
    public int getPath(int m,int n){
        if(m>1&&n>1) return getPath(m-1,n)+getPath(m,n-1);
        else if(m>1) return getPath(m-1,n);
        else if(n>1) return getPath(m,n-1);
        else return 1;
    }

    //BFS
    public int uniquePaths2(int m,int n){
        Point start=new Point(1,1);
        Point end=new Point(m,n);
        Queue<Point> queue=new LinkedList<Point>();
        queue.offer(start);
        int count=0;
        while(!queue.isEmpty()){
             Point p=queue.poll();
             if(p.equals(end)) count++;
             else{
                 if(p.x<m) queue.offer(new Point(p.x+1,p.y));
                 if(p.y<n) queue.offer(new Point(p.x,p.y+1));
             }
        }
        return count;
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


    //DFS
    /**
    public int uniquePaths2(int m,int n){
        int[][] map=new int[m+1][n+1];
        for(int i=)
        Point start=new Point(1,1);
        Point end=new Point(m,n);
        Stack<Point> stack=new Stack<Point>();
        stack.push()
    }
     */

    //DP
    public int uniquePaths3(int m,int n){
        int[][] result=new int[m][n];
        Arrays.fill(result[0],1);
        for(int i=0;i<m;i++)
            result[i][0]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                result[i][j]=result[i-1][j]+result[i][j-1];
            }
        }
        return result[m-1][n-1];
    }


    public static void main(String[] args){
        System.out.println(new Unique_Paths().uniquePaths3(2,3) );
    }
}
