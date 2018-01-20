import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Point start=new Point(0,0);
        Point end=new Point(obstacleGrid.length-1,obstacleGrid[0].length-1);
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1 || obstacleGrid[0][0]==1) return 0;
        Queue<Point> queue=new LinkedList<Point>();
        queue.offer(start);
        int count=0;
        while(!queue.isEmpty()){
            Point p=queue.poll();
            if(p.equals(end)) count++;
            else{
                if(p.x<obstacleGrid.length-1&&obstacleGrid[p.x+1][p.y]!=1) queue.offer(new Point(p.x+1,p.y));
                if(p.y<obstacleGrid[0].length-1&&obstacleGrid[p.x][p.y+1]!=1) queue.offer(new Point(p.x,p.y+1));
            }
        }
        return count;
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid){
        int[][] result=new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)return 0;
        result[0][0]=1;
        int i=1;
        while(i<obstacleGrid[0].length){
            if(obstacleGrid[0][i]==1)
                result[0][i]=0;
            else
                result[0][i]=result[0][i-1];
            i++;
        }
        i=1;
        while(i<obstacleGrid.length){
            if(obstacleGrid[i][0]==1)
                result[i][0]=0;
            else
                result[i][0]=result[i-1][0];
            i++;
        }

        for(i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1)
                    result[i][j]=0;
                else{
                    result[i][j]=result[i-1][j]+result[i][j-1];
                }
                //System.out.println(result[i][j]+"  "+i+" "+j);
            }
        }
        return result[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        int[][] nums={{0,0},{1,0}};
        System.out.println(new Unique_Paths_II().uniquePathsWithObstacles3(nums));
    }

}





class Point {
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
