package cn.treeNode.operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        List<Integer> list=new LinkedList<Integer>();
        pathUtil(result,list,sum,root);
        return result;
    }
    public void pathUtil(List<List<Integer>> result,List<Integer> list,int sum,TreeNode root){
        if(root==null) return ;
        if(sum==root.val&&root.left==null&&root.right==null){
            list.add(root.val);
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return ;
        }
        list.add(root.val);
        pathUtil(result,list,sum-root.val,root.left);
        pathUtil(result,list,sum-root.val,root.right);
        list.remove(list.size()-1);
    }

    public static void main(String[] args){
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        System.out.println(new Path_Sum_II().pathSum(treeNode,3));
    }
}
