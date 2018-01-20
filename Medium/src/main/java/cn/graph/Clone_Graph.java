package cn.graph;

import java.util.*;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
       return  graphUtil(node,new HashMap<Integer, UndirectedGraphNode>());
    }
    public UndirectedGraphNode graphUtil(UndirectedGraphNode node,  Map<Integer,UndirectedGraphNode> map){
        UndirectedGraphNode root=map.get(node.label);
        if(root==null){
            root=new  UndirectedGraphNode(node.label);
            map.put(root.label,root);
            for(UndirectedGraphNode no:node.neighbors){
                if(no.equals(node)){
                    root.neighbors.add(root);
                }else{
                    root.neighbors.add(graphUtil(no,map));
                }
            }
        }
        return root;
    }
}
