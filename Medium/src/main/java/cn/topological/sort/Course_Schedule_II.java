package cn.topological.sort;

import java.util.*;

public class Course_Schedule_II {

    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result=new LinkedList<Integer>();
        List<Set<Integer>> map=getGraph(numCourses,prerequisites);
        List<Integer> degree=computeDegree(numCourses,map);
        for(int i=0;i<numCourses;i++){
            int j=0;
            for(;j<numCourses;j++)
                if(degree.get(j)==0) break;
            if(j==numCourses) {result.clear();break;}
            result.add(j);
            degree.set(j,-1);
            for(Integer mm: map.get(j)){
                degree.set(mm,degree.get(mm)-1);
            }
        }
        int[] res=new int[result.size()];
        if(result.size()==0) return res;
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }
    public List<Set<Integer>> getGraph(int numCourses,int[][] prerequisites){
        List<Set<Integer>> map=new ArrayList<Set<Integer>>( numCourses);
        for(int i=0;i<numCourses;i++)
            map.add(new HashSet<Integer>());
        for(int i=0;i<prerequisites.length;i++){
           // System.out.println(prerequisites[i][1]);
            Set<Integer> set=map.get(prerequisites[i][1]);
            set.add(prerequisites[i][0]);
        }
        return map;
    }
    public List<Integer> computeDegree(int numCourses,List<Set<Integer>> map){
        List<Integer> degree=new ArrayList<Integer>(numCourses);
        for(int i=0;i<numCourses;i++){
            degree.add(0);
        }
        for(int i=0;i<numCourses;i++){
            Set<Integer> set=map.get(i);
            for(Integer s: set){
                Integer mm=degree.get(s)+1;
                degree.set(s,mm);
            }
        }
        return degree;
    }

    //DFS
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
       Stack<Integer> result=new Stack<Integer>();
        List<Set<Integer>> map=getGraph(numCourses,prerequisites);
        boolean[] visited=new boolean[numCourses];
        boolean[] onPath=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]&&dfs_Circle(numCourses,i,map,visited,onPath,result)){
                return new int[0];
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.pop();
        }
        return res;
    }
    public boolean dfs_Circle(int numCourses,int node, List<Set<Integer>> map,boolean[] visited,
                              boolean[] onPath,Stack<Integer> stack){
        if(visited[node]) return false;
        Set<Integer> set=map.get(node);
        visited[node] =true; onPath[node]=true;
        for(Integer mm: set){
            if(onPath[mm] || dfs_Circle(numCourses,mm,map,visited,onPath,stack)){
                return true;
            }
        }
        onPath[node]=false;
        stack.push(node);
        return false;
    }


    public static void main(String[] args){
        int[][] nums={{1,0}};
       System.out.println(Arrays.toString(new Course_Schedule_II().findOrder2(2,nums)));

    }

}
