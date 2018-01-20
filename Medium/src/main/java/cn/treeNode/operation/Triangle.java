package cn.treeNode.operation;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()<=0) return 0;
        int rootVal=triangle.get(0).get(0);
        return rootVal+minUtil(triangle,1,0);
    }
    public int minUtil(List<List<Integer>> triangle,int level, int pos){
        if(level>=triangle.size()) return 0;
        List<Integer> temp=triangle.get(level);
        return Math.min(minUtil(triangle,level+1,pos)+temp.get(pos),minUtil(triangle,level+1,pos+1)+ temp.get(pos+1));
    }
}
