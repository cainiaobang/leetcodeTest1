package cn.treeNode.operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        List<Integer> list=new ArrayList<Integer>();
        list.add(root.val);
        result.add(list);
        List<TreeNode> lists=new LinkedList<TreeNode>();
        lists.add(root);
        levelUtil(result,lists);
        return result;
    }
    public void  levelUtil(  List<List<Integer>> result, List<TreeNode> list){
        List<Integer> lists=new ArrayList<Integer>();
        List<TreeNode> tempList=new ArrayList<TreeNode>();
        for(TreeNode treeNode:list){
            if(treeNode.left!=null){
                tempList.add(treeNode.left);
                lists.add(treeNode.left.val);
            }
            if(treeNode.right!=null){
                tempList.add(treeNode.right);
                lists.add(treeNode.right.val);
            }
        }
        if(lists.size()>0){
            result.add(lists);
            levelUtil(result,tempList);
        }
    }
}
