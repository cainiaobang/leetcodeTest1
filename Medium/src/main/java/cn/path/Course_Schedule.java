package cn.path;

import java.util.*;

public class Course_Schedule {
    /**
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length<=1) return numCourses==prerequisites.length*2;
        Set<Integer> set=new HashSet<Integer>();
        int p=0,q=0;
        p=prerequisites[0][0];
        q=prerequisites[0][1];
        for(int i=1;i<prerequisites.length;i++){
            if(prerequisites[i][0]==p || prerequisites[i][0]==q){

            }
        }
    }
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>  map=new HashMap<Integer, List<Integer>>();
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list=map.get(prerequisites[i][0]);
            if(list==null){
                list=new ArrayList<Integer>();
                map.put(prerequisites[i][0],list);
            }
            list.add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]&&dfsUtil(i,map,new HashSet<Integer>(),visited)){
               return false;
            }
        }
        return true;
    }

    public boolean dfsUtil(int pos, Map<Integer,List<Integer>>  map, Set<Integer> set,boolean[] visited){
        List<Integer> list=map.get(pos);
        if(list==null || visited[pos]) return false;
        set.add(pos);
        visited[pos]=true;
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext()){
            Integer next=iterator.next();
            if(set.contains(next)) return true;
            if(dfsUtil(next,map,set,visited)){
                return true;
            }
        }
        set.remove(pos);
        return false;
    }

    public static void main(String[] args){
        int[][] nums={{0,2},{0,1},{1,2},{2,0}};
        System.out.println(new Course_Schedule().canFinish(3,nums));
    }


}
